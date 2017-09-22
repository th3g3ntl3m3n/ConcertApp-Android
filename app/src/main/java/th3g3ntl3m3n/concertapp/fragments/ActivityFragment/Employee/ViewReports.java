package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee;

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
 * Created by th3g3ntl3m3n on 18/8/17.
 */

public class ViewReports extends Fragment implements MonthNameListener {

    private static final String TAG = ViewReports.class.getSimpleName();
    static FragmentPageListener listener;
    public MonthFragment monthFragment;
    public Button button;
    public MonthNameListener monthNameListener;
    private LoadingFragment loadingFragment;
    private ArrayList<ReportsPOJO> allData;
    private String monthName;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new ViewReports();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_manager_report_view_layout, container, false);
        button = rootView.findViewById(R.id.monthNames);
        allData = new ArrayList<>();
        String[] arrayData = getActivity().getResources().getStringArray(R.array.clinic_names);
        monthNameListener = this;
        loadingFragment = new LoadingFragment();
        RecyclerView recyclerView = rootView.findViewById(R.id.branchNames);
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
        Call<ArrayList<ReportsPOJO>> arrayListCall = restClient.getApiService().getEmpReport(Constants.getUsername(getActivity()));
        addLoadingFragment();
        arrayListCall.enqueue(new Callback<ArrayList<ReportsPOJO>>() {
            @Override
            public void onResponse(Call<ArrayList<ReportsPOJO>> call, Response<ArrayList<ReportsPOJO>> response) {
                allData.addAll(response.body());
                removeLoadingFragment();
            }

            @Override
            public void onFailure(Call<ArrayList<ReportsPOJO>> call, Throwable t) {
                t.printStackTrace();
                removeLoadingFragment();
            }
        });
        return rootView;
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

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.FRONTACTIVITYE);
    }

    @Override
    public Button getButton() {
        return button;
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
                    int isAvail = 1;
                    for (int i = 0; i < allData.size(); i++) {
//                    Log.d(TAG, "onClick: " + allData.get(i).getClinic_no() + " " + allData.get(i).getMonth());
                        if (Integer.parseInt(allData.get(i).getClinic_no()) == position) {
                            Log.d(TAG, "onClick: " + button.getText().toString() + " " + allData.get(i).getClinic_no() + " " + allData.get(i).getMonth());
                            if (allData.get(i).getMonth().equals(button.getText().toString())) {
                                Constants.putPositionInPrefs(context, position);
                                monthName = button.getText().toString();
                                dataClinic.put("month", allData.get(i).getMonth());
                                dataClinic.put("clinic", allData.get(i).getClinic_no());
                                dataClinic.put("report", allData.get(i).getReport());
                                dataClinic.put("area", allData.get(i).getArea_name());
                                dataClinic.put("emp", allData.get(i).getEmp_name());
                                dataClinic.put("pusk", allData.get(i).getPusk_name());
                                listener.setClinicData(dataClinic);
                                isAvail = 0;
                                listener.onSwitchToNextFragmentActivity(Constants.VIEWDETAILACTIVITYE);
                                Log.d(TAG, "onClick: " + Constants.getPositionFromPrefs(context));
                                break;
                            } else {
                                isAvail = 1;
                            }
                        }
                    }
                    if (isAvail == 1
                            )
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
