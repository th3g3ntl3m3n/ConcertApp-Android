package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.ShareFragments.LoadingFragment;
import th3g3ntl3m3n.concertapp.ShareFragments.MonthFragment;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.ReportsPOJO;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;
import th3g3ntl3m3n.concertapp.interfaces.MonthNameListener;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class DetailReportManager extends Fragment implements MonthNameListener {
    private static final String TAG = DetailReportManager.class.getSimpleName();
    static FragmentPageListener listener;
    public MonthFragment monthFragment;
    public Button button;
    public MonthNameListener monthNameListener;
    private ArrayList<ReportsPOJO> allData;
    private String monthName;
    private LoadingFragment loadingFragment;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new DetailReportManager();
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
        allData = new ArrayList<>();
        String[] arrayData = getActivity().getResources().getStringArray(R.array.clinic_names);
        monthNameListener = this;
        loadingFragment = new LoadingFragment();
        RecyclerView recyclerView = view.findViewById(R.id.branchNames);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new BasicAdapter(arrayData);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMonthDialog();
            }
        });
        if (monthName != null) button.setText(monthName);
        RestClient restClient = new RestClient();
        String name = Constants.getBranchName(getActivity());
        Call<ArrayList<ReportsPOJO>> arrayListCall = restClient.getApiService().getReportsWithPusk(name);
        addLoadingFragment();
        arrayListCall.enqueue(new Callback<ArrayList<ReportsPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<ReportsPOJO>> call, Response<ArrayList<ReportsPOJO>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).getClinic_no());
                allData.addAll(response.body());
                removeLoadingFragment();
            }

            @Override
            public void onFailure(Call<ArrayList<ReportsPOJO>> call, Throwable t) {
                t.printStackTrace();
                removeLoadingFragment();
            }
        });
    }

    public void showMonthDialog() {
        monthFragment = MonthFragment.newInstanse(monthNameListener);
        monthFragment.show(getActivity().getSupportFragmentManager(), "Hey");
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

    @Override
    public Button getButton() {
        return button;
    }

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.VIEWREPORTACTIVITYM);
    }

    class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {
        private final String TAG = BasicAdapter.class.getSimpleName();
        private Map<String, String> dataClinic = new HashMap<>();
        private String[] arrayData;
        private Context context;

        public BasicAdapter(String[] data) {
            arrayData = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            context = parent.getContext();
            TextView textView = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_list_row, parent, false);
            return new ViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mtext.setText(arrayData[position]);
            holder.mtext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int isAvail = 0;
                    for (int i = 0; i < allData.size(); i++) {
                        if (Integer.parseInt(allData.get(i).getClinic_no()) == position) {
                            if (allData.get(i).getMonth().equals(button.getText().toString())) {
                                Constants.putPositionInPrefs(context, position);
                                monthName = button.getText().toString();
                                isAvail = 1;
                                Log.d(TAG, "onclickbindview: " + monthName);
                                dataClinic.put("month", allData.get(i).getMonth());
                                dataClinic.put("clinic", allData.get(i).getClinic_no());
                                dataClinic.put("report", allData.get(i).getReport());
                                listener.setClinicData(dataClinic);
                                listener.onSwitchToNextFragmentActivity(Constants.DEEPDETAILM);
                                Log.d(TAG, "onClick: " + Constants.getPositionFromPrefs(context));
                                break;
                            } else {
                                isAvail = 0;
                            }
                        }
                    }
                    if (isAvail == 0)
                        Snackbar.make(view, "NO REPORT FILLED YET SELECTED MONTH", Snackbar.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrayData.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView mtext;

            ViewHolder(TextView view) {
                super(view);
                mtext = view;
            }
        }
    }
}
