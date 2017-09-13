package th3g3ntl3m3n.concertapp.fragments.AuthFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.POJOResponse;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by ram on 9/8/17.
 */

public class SignupFragment extends Fragment {

    static FragmentPageListener listener;
    ProgressDialog progressDialog;

    public static SignupFragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new SignupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Authenticating.. Please Wait.");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment_layout, container, false);
        final EditText eu_name = view.findViewById(R.id.input_name);
        final EditText eU_email = view.findViewById(R.id.input_email);
        final EditText eu_pass = view.findViewById(R.id.input_password);

        (view.findViewById(R.id.btn_signup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                String uname, email, pass;
                uname = eu_name.getText().toString();
                email = eU_email.getText().toString();
                pass = eu_pass.getText().toString();

                if (uname.equals("") && email.equals("") && pass.equals("")) {
                    Snackbar.make(view, "Please Fill All Fields", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.show();
                RestClient restClient = new RestClient();
                Call<POJOResponse> makeCall = restClient.getApiService().getSignup(uname, pass, email);
                makeCall.enqueue(new Callback<POJOResponse>() {
                    @Override
                    public void onResponse(Call<POJOResponse> call, Response<POJOResponse> response) {
                        String responseCode = response.body().getCode();
                        if (responseCode.equals("200")) {
                            Snackbar.make(view, response.body().getName() + ". Please Login", Snackbar.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            backPressed();
                        } else {
                            progressDialog.dismiss();
                            Log.d("TAG", "onResponse: " + response.body().getCode());
                            Snackbar.make(view, response.body().getName(), Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<POJOResponse> call, Throwable t) {

                    }
                });

            }
        });

        (view.findViewById(R.id.link_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backPressed();
            }
        });

        return view;
    }

    public void backPressed() {
        listener.getFragmentCode(Constants.LOGINFRAGMENT);
    }
}
