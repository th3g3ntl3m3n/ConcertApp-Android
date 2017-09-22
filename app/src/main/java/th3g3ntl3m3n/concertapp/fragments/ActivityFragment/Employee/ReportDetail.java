package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.RestClient;
import th3g3ntl3m3n.concertapp.ShareFragments.LoadingFragment;
import th3g3ntl3m3n.concertapp.data.ClinicOne;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.Demo;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class ReportDetail extends Fragment {
    private static final String TAG = ReportDetail.class.getSimpleName();
    static FragmentPageListener listener;
    private LoadingFragment loadingFragment;
    private ArrayList<String> clinicData;
    private ArrayList<String> clinicDataValues;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new ReportDetail();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_detail_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.accountDetailList);
        loadingFragment = new LoadingFragment();
        final Map<String, String> data = listener.getClinicData();
        int p = Integer.parseInt(data.get("clinic"));
        ClinicOne clinicOne = new ClinicOne();
        clinicData = clinicOne.getClinicList(p);
        clinicDataValues = new ArrayList<>();
        final Gson gson = new Gson();
        Type stringStringMap = new TypeToken<Map<String, String>>() {
        }.getType();
        final Map<String, String> mapReport = gson.fromJson(data.get("report"), stringStringMap);
        for (String key : mapReport.keySet()) {
            clinicDataValues.add(mapReport.get(key));
        }
        RecyclerView.Adapter adapter = new DetailAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        final RestClient restClient = new RestClient();
        Button button = view.findViewById(R.id.saveButton);
        button.setText("Update");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Map<String, String> dataValues = new LinkedHashMap<>();
                int i = 0;
                for (String key : mapReport.keySet()) {
                    dataValues.put(key, clinicDataValues.get(i));
                    i++;
                }
                Log.d(TAG, "onClick: " + gson.toJson(dataValues));
                String monthName = data.get("month");
                String empName = data.get("emp");
                String clinic_no = data.get("clinic");
                String pusk = data.get("pusk");
                String area = data.get("area");
                Call<DemoUser> makeCall = restClient
                        .getApiService()
                        .insertReport(new Demo(empName, monthName, gson.toJson(dataValues), clinic_no, area, pusk));
                makeCall.enqueue(new Callback<DemoUser>() {
                    @Override
                    public void onResponse(Call<DemoUser> call, Response<DemoUser> response) {
                        Log.d("TAG", "onResponse: save" + response.body().toString());
                        Snackbar.make(view, response.body().getMessage(), Snackbar.LENGTH_SHORT).show();
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
        listener.onSwitchToNextFragmentActivity(Constants.VIEWACTIVITYE);
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_data_row, parent, false);
            return new ViewHolder(view, new CustomTextWatcher());
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.customTextWatcher.updatePosition(holder.getAdapterPosition());
            holder.fieldName.setText(clinicData.get(holder.getAdapterPosition()));
            holder.fieldValue.setText(clinicDataValues.get(holder.getAdapterPosition()));
        }

        @Override
        public int getItemCount() {
            return clinicData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView fieldName;
            private EditText fieldValue;
            private CustomTextWatcher customTextWatcher;

            public ViewHolder(View itemView, CustomTextWatcher customTextWatcher) {
                super(itemView);
                fieldName = itemView.findViewById(R.id.fieldName);
                fieldValue = itemView.findViewById(R.id.fieldValue);
                this.customTextWatcher = customTextWatcher;
                fieldValue.addTextChangedListener(customTextWatcher);
            }
        }

        class CustomTextWatcher implements TextWatcher {
            private int position;

            void updatePosition(int position) {
                this.position = position;
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                // no op
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Log.d(TAG, "onTextChanged: " + position);
//                formValues[position] = charSequence.toString();
//                clinicDataValues[position] = charSequence.toString();
                clinicDataValues.set(position, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // no op
            }
        }
    }
}
