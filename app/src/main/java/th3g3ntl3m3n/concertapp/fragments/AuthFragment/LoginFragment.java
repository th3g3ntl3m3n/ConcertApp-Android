package th3g3ntl3m3n.concertapp.fragments.AuthFragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.POJOResponse;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;
import th3g3ntl3m3n.concertapp.loadingscreen.LoadingFragment;

/**
 * Created by ram on 9/8/17.
 */

public class LoginFragment extends Fragment {

    public static final String TAG = LoginFragment.class.getSimpleName();
    static FragmentPageListener listener;
    private EditText email, pass;
    private LoadingFragment loadingFragment;
    private View signup;

    public static LoginFragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        final View login = view.findViewById(R.id.btn_login);
        signup = view.findViewById(R.id.link_signup);

        TextView companyName = view.findViewById(R.id.comapnyName);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Quicksand-Regular.otf");
        companyName.setTypeface(font);

        email = view.findViewById(R.id.input_email);
        pass = view.findViewById(R.id.input_password);

        email.setText("admin");
        pass.setText("hawkscode");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String us_email = email.getText().toString();
                final String us_pass = pass.getText().toString();

                if (us_email.equals("") || us_pass.equals("")) {
                    Snackbar.make(view, "Please Fill Both Fields", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                loadingFragment = new LoadingFragment();
                addLoadingFragment();

                if (isNetworkAvailable()) {
                    authInternet(view, us_email, us_pass);
                } else {
                    if (Constants.loginUser(getActivity(), us_email, us_pass)) {
                        if (Constants.getUserType(getActivity()) == Constants.ADMIN) {
                            listener.isAdmin(1);
                        }
                        removeLoadingFragment();
                        listener.getFragmentCode(Constants.ACCOUNTFRAGMENT);
                    } else {
                        removeLoadingFragment();
                        Snackbar.make(view, "Please provide correct credentials. If you are using it first time please enable your internet", Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.getFragmentCode(Constants.SIGNUPFRAGMENT);
            }
        });

        return view;
    }

    private void removeLoadingFragment() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .remove(loadingFragment).commit();
    }

    private void addLoadingFragment() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.loadingFrameContainer, loadingFragment).commit();
    }

    public void authInternet(final View view, final String us_email, final String us_pass) {

        RestClient restClient = new RestClient();
        Call<POJOResponse> makeCall = restClient.getApiService().getLoginAuth(us_email, us_pass);

        makeCall.enqueue(new Callback<POJOResponse>() {
            @Override
            public void onResponse(@NonNull Call<POJOResponse> call, @NonNull Response<POJOResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
                String responseCode = response.body().getCode();
                if (responseCode.equals("200")) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    Snackbar.make(view, " " + response.body().getType(), Snackbar.LENGTH_SHORT).show();
                    if (response.body().getType() == Constants.ADMIN) {
                        listener.isAdmin(1);
                    }
                    Constants.loginUserWithInternetCreds(getActivity(), us_email, us_pass, response.body());
                    removeLoadingFragment();
                    listener.getFragmentCode(Constants.ACCOUNTFRAGMENT);
                } else {
                    Snackbar.make(view, response.body().getCode(), Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<POJOResponse> call, Throwable t) {
                removeLoadingFragment();
                Log.d(TAG, "onFailure: " + t.getMessage());
                ((TextView) signup).setText(t.getMessage());
                t.printStackTrace();
                Snackbar.make(view, "Server Error : Failed " + t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
