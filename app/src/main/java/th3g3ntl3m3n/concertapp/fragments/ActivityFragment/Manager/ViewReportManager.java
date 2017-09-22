package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.ShareFragments.MonthFragment;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.ReportsPOJO;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;
import th3g3ntl3m3n.concertapp.interfaces.MonthNameListener;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class ViewReportManager extends Fragment implements MonthNameListener {

    private static final String TAG = ViewReportManager.class.getSimpleName();
    static FragmentPageListener listener;
    public MonthFragment monthFragment;
    public Button button;
    public MonthNameListener monthNameListener;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new ViewReportManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_manager_report_view_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.monthNames);
        monthNameListener = this;
        ArrayList<ReportsPOJO> reportsPOJOArrayList = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMonthDialog();
            }
        });
        recyclerView = view.findViewById(R.id.branchNames);
        adapter = new BranchAdapter(reportsPOJOArrayList);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        getAllReports(reportsPOJOArrayList);

    }

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.FRONTACTIVITYM);
    }

    public void getAllReports(final ArrayList<ReportsPOJO> reportsPOJOS) {
        RestClient restClient = new RestClient();
        String areaName = Constants.getAreaName(getActivity());
        Call<ArrayList<ReportsPOJO>> arrayListCall = restClient.getApiService().getReports(areaName);
        arrayListCall.enqueue(new Callback<ArrayList<ReportsPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<ReportsPOJO>> call, Response<ArrayList<ReportsPOJO>> response) {
                reportsPOJOS.addAll(response.body());
                adapter.notifyDataSetChanged();
//                String reports = response.body().get(0).getReport();
//                Gson gson = new Gson();
//                Type stringStringMap = new TypeToken<Map<String, String>>(){}.getType();
//                Map<String, String> mapReport = gson.fromJson(reports, stringStringMap);
//                Log.d(TAG, "onResponse: " + mapReport.size());
            }

            @Override
            public void onFailure(Call<ArrayList<ReportsPOJO>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showMonthDialog() {
        monthFragment = MonthFragment.newInstanse(monthNameListener);
        monthFragment.show(getActivity().getSupportFragmentManager(), "Hey");
    }

    @Override
    public Button getButton() {
        return button;
    }

    class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.ViewHolder> {
        private Map<String, String> dataClinic;
        private ArrayList<ReportsPOJO> reportsPOJOS;

        public BranchAdapter(ArrayList<ReportsPOJO> reportsPOJOS) {
            this.reportsPOJOS = reportsPOJOS;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_row, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.textView.setText(reportsPOJOS.get(position).getName());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Constants.setBranchName(getActivity(), reportsPOJOS.get(position).getName());
                    listener.onSwitchToNextFragmentActivity(Constants.DETAILREPORTM);
                }
            });
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
