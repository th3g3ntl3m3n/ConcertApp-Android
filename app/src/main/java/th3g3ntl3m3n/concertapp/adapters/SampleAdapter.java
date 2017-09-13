package th3g3ntl3m3n.concertapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;
import th3g3ntl3m3n.concertapp.interfaces.SpinnerListener;

/**
 * Created by th3g3ntl3m3n on 12/8/17.
 */

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

    private static final String TAG = SampleAdapter.class.getSimpleName();
    private static Map<String, String> dataClinic = new HashMap<>();
    private String[] arrayData;
    private FragmentPageListener listenerForAdapter;
    private Context context;
    private String monthName;
    private SpinnerListener spinnerListener;

    public SampleAdapter(String[] data, FragmentPageListener listener, SpinnerListener spinnerListener) {
        arrayData = data;
        this.spinnerListener = spinnerListener;
        listenerForAdapter = listener;
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
                Constants.putPositionInPrefs(context, position);
                monthName = spinnerListener.getValue();
                Log.d(TAG, "onclickbindview: " + monthName);
                dataClinic.put("month", monthName);
                dataClinic.put("clinic", String.valueOf(holder.getAdapterPosition()));
                listenerForAdapter.setClinicData(dataClinic);
                listenerForAdapter.onSwitchToNextFragmentActivity(Constants.DETAILACTIVITY);
                Log.d(TAG, "onClick: " + Constants.getPositionFromPrefs(context));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mtext;

        public ViewHolder(TextView view) {
            super(view);
            mtext = view;
        }
    }
}
