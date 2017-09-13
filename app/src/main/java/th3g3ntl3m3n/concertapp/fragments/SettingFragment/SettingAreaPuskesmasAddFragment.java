package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.adapters.PuskesmasAdapter;
import th3g3ntl3m3n.concertapp.adapters.SettingAreaAdapter;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.data.Puskesmas;
import th3g3ntl3m3n.concertapp.interfaces.AreaListener;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 29/8/17.
 */

public class SettingAreaPuskesmasAddFragment extends Fragment {

    private static final String TAG = SettingAreaPuskesmasAddFragment.class.getSimpleName();
    static FragmentPageListener listener;
    RecyclerView.Adapter adapter;
    String nameOfArea;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new SettingAreaPuskesmasAddFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_area_add_puskesmas_layout, container, false);

        final RecyclerView recyclerView = view.findViewById(R.id.puskesmasList);
        adapter = new PuskesmasAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        final Button button = view.findViewById(R.id.addButtonPuskesmas);
        button.setVisibility(View.GONE);
        nameOfArea = SettingAreaAdapter.getAreaname();
        final AreaListener areaListener = (AreaListener) adapter;
        final FloatingActionButton floatingActionButton = view.findViewById(R.id.addpuskesmas);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLangDialog(floatingActionButton, button);
            }
        });
        getPuskesmasForArea();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                List<String> data = Arrays.asList(areaListener.getValue());
                ArrayList<String> newData = new ArrayList<>();
                newData.addAll(data);
                Snackbar.make(view, "CLICKED TO SAVE " + nameOfArea + " " + newData.get(0), Snackbar.LENGTH_SHORT).show();
                RestClient restClient = new RestClient();
                Call<DemoUser> call = restClient.getApiService().addPuskesmas(new Puskesmas(newData, nameOfArea));
                call.enqueue(new Callback<DemoUser>() {
                    @Override
                    public void onResponse(Call<DemoUser> call, Response<DemoUser> response) {
                        Log.d(TAG, "onResponse: " + response.body().getCode());
                        Snackbar.make(view, response.body().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<DemoUser> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

    public void getPuskesmasForArea() {
        RestClient restClient = new RestClient();
        Call<DemoUser> listCall = restClient.getApiService().getPuskesmas(new Puskesmas(nameOfArea));
        listCall.enqueue(new Callback<DemoUser>() {
            @Override
            public void onResponse(Call<DemoUser> call, Response<DemoUser> response) {
                Log.d(TAG, "onResponse: " + response.body().getCode());
            }

            @Override
            public void onFailure(Call<DemoUser> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void backPressed() {
        listener.onSwitchToNextFragment(Constants.SETTINGAREA);
    }

    public void showChangeLangDialog(final FloatingActionButton floatingActionButton, final Button button) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText areaName = dialogView.findViewById(R.id.edit1);
        areaName.setHint("Number of Puskesmas");
        areaName.setInputType(InputType.TYPE_CLASS_NUMBER);
        dialogBuilder.setTitle("Add puskesmas");
        dialogBuilder.setMessage("Please enter number of puskesmas");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                String name = areaName.getText().toString();
                if (name.equals("")) {
                    Snackbar.make(getView(), "Provide some Area name", Snackbar.LENGTH_SHORT).show();
                } else {
                    ((PuskesmasAdapter) adapter).updateRows(Integer.parseInt(name));
                    floatingActionButton.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);
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
