package th3g3ntl3m3n.concertapp.fragments.ActivityFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.adapters.SampleAdapter;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;
import th3g3ntl3m3n.concertapp.interfaces.SpinnerListener;

/**
 * Created by ram on 9/8/17.
 */

public class EditReports extends Fragment implements SpinnerListener {

    static FragmentPageListener listener;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String spinnerValue;
    private SpinnerListener spinnerListener;

    public EditReports() {
    }

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new EditReports();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_layout, container, false);

        final Spinner spinner = rootView.findViewById(R.id.spinnerView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.month_names, R.layout.custom_spinner_row);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinnerListener = EditReports.this;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerValue = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        String[] arrayData = getActivity().getResources().getStringArray(R.array.clinic_names);

        mRecyclerView = rootView.findViewById(R.id.listView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SampleAdapter(arrayData, listener, spinnerListener);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.FRONTACTIVITY);
    }

    @Override
    public String getValue() {
        return spinnerValue;
    }
}
