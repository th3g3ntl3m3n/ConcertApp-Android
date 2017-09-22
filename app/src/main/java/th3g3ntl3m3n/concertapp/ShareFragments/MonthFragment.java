package th3g3ntl3m3n.concertapp.ShareFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.interfaces.MonthNameListener;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class MonthFragment extends DialogFragment {
    private static final String TAG = MonthFragment.class.getSimpleName();
    static MonthNameListener listener;
    private String[] monthNames;

    public MonthFragment() {
    }

    public static MonthFragment newInstanse(MonthNameListener monthNameListener) {
        listener = monthNameListener;
        return new MonthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.month_dialog_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        monthNames = getActivity().getResources().getStringArray(R.array.month_names);
        RecyclerView recyclerView = view.findViewById(R.id.monthListView);
        RecyclerView.Adapter adapter = new DemoAdapter();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.month_layout, parent, false);
            return new DemoAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.button.setText(monthNames[position]);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MonthFragment.this.dismiss();
                    Log.d(TAG, "onClick: " + listener);
                    (listener.getButton()).setText(monthNames[holder.getAdapterPosition()]);
                }
            });
        }

        @Override
        public int getItemCount() {
            return monthNames.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private Button button;

            ViewHolder(View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.monthButton);
            }
        }
    }
}
