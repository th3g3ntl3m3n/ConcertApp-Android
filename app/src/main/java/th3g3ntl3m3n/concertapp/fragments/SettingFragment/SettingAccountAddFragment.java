package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.data.User;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 28/8/17.
 */

public class SettingAccountAddFragment extends Fragment {

    private static final String TAG = SettingAccountAddFragment.class.getSimpleName();
    static FragmentPageListener listener;
    Map<String, ArrayList<String>> dataValuesMap = new HashMap<>();

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new SettingAccountAddFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_account_add_fragment, container, false);
        final EditText username = view.findViewById(R.id.username);
        final EditText password = view.findViewById(R.id.password);
        final Spinner types = view.findViewById(R.id.types);
        final EditText fullName = view.findViewById(R.id.full_name);
        final Spinner puskesmas = view.findViewById(R.id.puskesmas);
        final Spinner areas = view.findViewById(R.id.areas);
        getAllThing();

        puskesmas.setVisibility(View.GONE);
        areas.setVisibility(View.GONE);

        types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (view != null) {
                    Snackbar.make(getView(), "Changed from " + ((TextView) view).getText().toString(), Snackbar.LENGTH_SHORT).show();
                    String name = ((TextView) view).getText().toString();
                    if (name.equals("Manager")) {
                        areas.setVisibility(View.VISIBLE);
                        puskesmas.setVisibility(View.GONE);
                    } else {
                        puskesmas.setVisibility(View.VISIBLE);
                    }
                    ArrayAdapter<String> adapterOfSpinner = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, new ArrayList<String>(dataValuesMap.keySet()));
                    adapterOfSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areas.setAdapter(adapterOfSpinner);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        areas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = ((TextView) view).getText().toString();
                ArrayAdapter<String> adapterOfSpinner = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item,
                        dataValuesMap.get(name));
                adapterOfSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                puskesmas.setAdapter(adapterOfSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        (view.findViewById(R.id.addUser)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                int accountType = 1002;
                String manager = "Manager";
                if (manager.equals(types.getSelectedItem().toString())) {
                    accountType = 1001;
                }
                RestClient restClient = new RestClient();
                User user;
                if (accountType == 1001) {
                    user = new User(username.getText().toString(),
                            password.getText().toString(),
                            fullName.getText().toString(),
                            false,
                            true,
                            accountType, areas.getSelectedItem().toString());
                } else {
                    user = new User(username.getText().toString(),
                            password.getText().toString(),
                            fullName.getText().toString(),
                            false,
                            true,
                            accountType, areas.getSelectedItem().toString(), puskesmas.getSelectedItem().toString());
                }
                Call<DemoUser> userCall = restClient.getApiService().addUser(user);

                userCall.enqueue(new Callback<DemoUser>() {
                    @Override
                    public void onResponse(Call<DemoUser> call, Response<DemoUser> response) {
                        Snackbar.make(view, response.body().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<DemoUser> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        return view;
    }

    public void getAllThing() {
        Log.d(TAG, "getAllThing: " + "Calling method");
        RestClient restClient = new RestClient();
        Call<ArrayList<DemoUser>> call = restClient.getApiService().getAllThing();
        call.enqueue(new Callback<ArrayList<DemoUser>>() {
            @Override
            public void onResponse(Call<ArrayList<DemoUser>> call, Response<ArrayList<DemoUser>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).getArea());
                for (DemoUser obj : response.body()) {
                    dataValuesMap.put(obj.getArea(), obj.getList());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DemoUser>> call, Throwable t) {

            }
        });
    }

    public void backPressed() {
        listener.onSwitchToNextFragment(Constants.SETTINGACCOUNTACTIVITY);
    }
}
