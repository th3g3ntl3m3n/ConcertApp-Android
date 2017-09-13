package th3g3ntl3m3n.concertapp.fragments.ActivityFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.adapters.AccountDetailAdapter;
import th3g3ntl3m3n.concertapp.data.ClinicOne;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.Demo;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.DataListener;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 10/8/17.
 */

public class ActivitiesDetail extends Fragment {

    private static final String TAG = ActivitiesDetail.class.getSimpleName();
    static FragmentPageListener listener;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public ActivitiesDetail() {
        Log.d(TAG, "ActivitiesDetail: " + ActivitiesDetail.class.getCanonicalName());
    }

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new ActivitiesDetail();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_detail_layout, container, false);
        recyclerView = rootView.findViewById(R.id.accountDetailList);
        adapter = new AccountDetailAdapter(getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        final DataListener listener1 = (DataListener) adapter;
        final Gson gson = new Gson();
        (rootView.findViewById(R.id.saveButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] dataValues = listener1.getData();
                int p = Constants.getPositionFromPrefs(getActivity());
                int i = 0;
                Map<String, String> data = new ClinicOne().getClinicData(p);
                for (String key : data.keySet()) {
                    data.put(key, dataValues[i]);
                    i += 1;
                }
                final String areaName = Constants.getAreaName(getActivity());
                if (areaName.equals("NULL")) {
                    Snackbar.make(view, "AREA IS NULL", Snackbar.LENGTH_LONG).show();
                    return;
                }
                String jsonString = gson.toJson(data);
                Log.d(TAG, "onClick: " + jsonString);
                Map<String, String> extraData = listener.getClinicData();
                RestClient restClient = new RestClient();
                String emp_name = Constants.getUsername(getActivity());
                String monthName = extraData.get("month");
                String clinic_no = extraData.get("clinic");
                Call<DemoUser> makeCall = restClient.getApiService().insertReport(new Demo(emp_name, monthName, jsonString, clinic_no, areaName));
                makeCall.enqueue(new Callback<DemoUser>() {
                    @Override
                    public void onResponse(Call<DemoUser> call, @NonNull Response<DemoUser> response) {
                        Log.d("TAG", "onResponse: save" + response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<DemoUser> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        return rootView;
    }

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.EDITACTIVITY);
    }


}
