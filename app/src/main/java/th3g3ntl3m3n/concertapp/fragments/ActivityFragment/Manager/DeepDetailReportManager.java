package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.ShareFragments.LoadingFragment;
import th3g3ntl3m3n.concertapp.data.ClinicOne;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 15/9/17.
 */

public class DeepDetailReportManager extends Fragment {
    private static final String TAG = DeepDetailReportManager.class.getSimpleName();
    static FragmentPageListener listener;
    private LoadingFragment loadingFragment;
    private ArrayList<String> clinicData;
    private ArrayList<String> clinicDataValues;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new DeepDetailReportManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.report_detail_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.reportDetailList);
        loadingFragment = new LoadingFragment();
        Map<String, String> data = listener.getClinicData();
        int p = Integer.parseInt(data.get("clinic"));
        ClinicOne clinicOne = new ClinicOne();
        clinicData = clinicOne.getClinicList(p);
        clinicDataValues = new ArrayList<>();
        Gson gson = new Gson();
        Type stringStringMap = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> mapReport = gson.fromJson(data.get("report"), stringStringMap);
        for (String key : mapReport.keySet()) {
            clinicDataValues.add(mapReport.get(key));
        }
        RecyclerView.Adapter adapter = new DetailAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.DETAILREPORTM);
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

    class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_detail_row_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.fieldName.setText(clinicData.get(position));
            holder.fieldValue.setText(clinicDataValues.get(position));
        }

        @Override
        public int getItemCount() {
            return clinicData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView fieldName, fieldValue;

            public ViewHolder(View itemView) {
                super(itemView);
                fieldName = itemView.findViewById(R.id.fieldName);
                fieldValue = itemView.findViewById(R.id.fieldValue);
            }
        }
    }
}
