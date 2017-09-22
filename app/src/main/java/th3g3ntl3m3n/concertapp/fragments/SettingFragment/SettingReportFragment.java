package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 23/8/17.
 */

public class SettingReportFragment extends Fragment {

    static FragmentPageListener listener;

    public static Fragment newInstance(FragmentPageListener l) {
        listener = l;
        return new SettingReportFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_clinic_type_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<DemoUser> demoUserArrayList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.clinicTypeList);
        final RecyclerView.Adapter adapter = new ClinicAdapter(demoUserArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        final RestClient restClient = new RestClient();
        Call<ArrayList<DemoUser>> arrayListCall = restClient.getApiService().getAllClinicTypes();
        arrayListCall.enqueue(new Callback<ArrayList<DemoUser>>() {
            @Override
            public void onResponse(Call<ArrayList<DemoUser>> call, Response<ArrayList<DemoUser>> response) {
                if (response.body().size() > 0) {
                    demoUserArrayList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DemoUser>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Button button = view.findViewById(R.id.addClinicButton);
        final EditText editText = view.findViewById(R.id.clinicName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<DemoUser> demoUserCall = restClient.getApiService().addClinicType(new DemoUser(editText.getText().toString()));
                demoUserCall.enqueue(new Callback<DemoUser>() {
                    @Override
                    public void onResponse(Call<DemoUser> call, Response<DemoUser> response) {
                        if (response.body().getMessage().equals("success")) {
                            demoUserArrayList.add(new DemoUser(editText.getText().toString()));
                            adapter.notifyDataSetChanged();
                            editText.setText("");
                        }
                    }

                    @Override
                    public void onFailure(Call<DemoUser> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }

    public void backPressed() {
        listener.onSwitchToNextFragment(Constants.SETTINGACTIVITY);
    }

    class ClinicAdapter extends RecyclerView.Adapter<ClinicAdapter.ViewHolder> {
        private ArrayList<DemoUser> reportsPOJOS;

        public ClinicAdapter(ArrayList<DemoUser> reportsPOJOS) {
            this.reportsPOJOS = reportsPOJOS;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_row, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(reportsPOJOS.get(position).getType());
        }

        @Override
        public int getItemCount() {
            return reportsPOJOS.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }
    }
}
