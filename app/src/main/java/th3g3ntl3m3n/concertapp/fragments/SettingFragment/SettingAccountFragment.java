package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.adapters.SettingAccountFragmentAdapter;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;
import th3g3ntl3m3n.concertapp.loadingscreen.LoadingFragment;

/**
 * Created by th3g3ntl3m3n on 23/8/17.
 */

public class SettingAccountFragment extends Fragment {

    private static final String TAG = SettingAccountFragment.class.getSimpleName();
    static FragmentPageListener listener;
    public LoadingFragment loadingFragment;

    public static Fragment newInstance(FragmentPageListener l) {
        listener = l;
        return new SettingAccountFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_account_fragment_layout, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.accountList);
        RecyclerView.Adapter adapter = new SettingAccountFragmentAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        loadingFragment = new LoadingFragment();
        addLoadingFragment();
        getUsersFromAir(adapter);
        (view.findViewById(R.id.adduser)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSwitchToNextFragment(Constants.SETTINGACCOUNTADD);
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

    public void getUsersFromAir(final RecyclerView.Adapter adapter) {
        RestClient restClient = new RestClient();
        Call<ArrayList<DemoUser>> getArrayListUsers = restClient.getApiService().getAllUsers();
        getArrayListUsers.enqueue(new Callback<ArrayList<DemoUser>>() {
            @Override
            public void onResponse(Call<ArrayList<DemoUser>> call, Response<ArrayList<DemoUser>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).getName());
                if (response.body().get(0).getName().equals("empty")) {
                    Log.d(TAG, "onResponse: " + " empty no data");
                } else {
                    ((SettingAccountFragmentAdapter) adapter).updateDataSet(response.body());
                }
                removeLoadingFragment();
            }

            @Override
            public void onFailure(Call<ArrayList<DemoUser>> call, Throwable t) {
                removeLoadingFragment();
            }
        });
    }

    public void backPressed() {
        listener.onSwitchToNextFragment(Constants.SETTINGACTIVITY);
    }
}
