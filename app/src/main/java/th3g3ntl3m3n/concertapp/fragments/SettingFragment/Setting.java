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
import th3g3ntl3m3n.concertapp.adapters.SettingViewAdapter;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by ram on 9/8/17.
 */

public class Setting extends Fragment {

    private static final String TAG = Setting.class.getSimpleName();
    static FragmentPageListener listener;

    public Setting() {

    }

    public static Setting newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new Setting();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.setting_layout_main, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.settingPage);
        RecyclerView.Adapter adapter = new SettingViewAdapter(listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
//        getAllThing();

        return rootView;
    }

    public void getAllThing() {
        Log.d(TAG, "getAllThing: " + "Calling method");
        RestClient restClient = new RestClient();
        Call<ArrayList<DemoUser>> call = restClient.getApiService().getAllThing();
        call.enqueue(new Callback<ArrayList<DemoUser>>() {
            @Override
            public void onResponse(Call<ArrayList<DemoUser>> call, Response<ArrayList<DemoUser>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).getArea());
            }

            @Override
            public void onFailure(Call<ArrayList<DemoUser>> call, Throwable t) {

            }
        });
    }
}
