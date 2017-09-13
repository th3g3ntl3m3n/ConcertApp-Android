package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.adapters.SettingAreaAdapter;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 29/8/17.
 */

public class SettingAreaFragment extends Fragment {
    private static final String TAG = SettingAreaFragment.class.getSimpleName();
    static FragmentPageListener listener;
    private RestClient restClient;
    private RecyclerView.Adapter adapter;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new SettingAreaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_branch_fragment_layout, container, false);
        restClient = new RestClient();
        RecyclerView recyclerView = view.findViewById(R.id.arealist);
        adapter = new SettingAreaAdapter(new ArrayList<DemoUser>(), listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        getAreasList();
        (view.findViewById(R.id.addarea)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLangDialog();
            }
        });

        return view;
    }

    public void updateAreas(String areaname) {
        Call<ArrayList<DemoUser>> listCall = restClient.getApiService().addArea(new DemoUser(areaname));
        listCall.enqueue(new Callback<ArrayList<DemoUser>>() {
            @Override
            public void onResponse(Call<ArrayList<DemoUser>> call, Response<ArrayList<DemoUser>> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
                ((SettingAreaAdapter) adapter).updateAreas(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<DemoUser>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getAreasList() {
        Call<ArrayList<DemoUser>> demoUserCall = restClient.getApiService().getAreas();
        Log.d(TAG, "getAreasList: ");
        demoUserCall.enqueue(new Callback<ArrayList<DemoUser>>() {
            @Override
            public void onResponse(Call<ArrayList<DemoUser>> call, Response<ArrayList<DemoUser>> response) {
                if (response.body().size() > 0) {
                    Log.d(TAG, "onResponse: " + response.body().get(0).getName());
                    ((SettingAreaAdapter) adapter).updateAreas(response.body());
                } else {
                    Log.d(TAG, "onResponse: " + " empty no data");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DemoUser>> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    public void backPressed() {
        listener.onSwitchToNextFragment(Constants.SETTINGACTIVITY);
    }

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText areaName = dialogView.findViewById(R.id.edit1);

        dialogBuilder.setTitle("Add Area");
        dialogBuilder.setMessage("Please enter area name below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                String name = areaName.getText().toString();
                if (name.equals("")) {
                    Snackbar.make(getView(), "Provide some Area name", Snackbar.LENGTH_SHORT).show();
                } else {
                    updateAreas(name);
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
