package th3g3ntl3m3n.concertapp.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 22/8/17.
 */

public class SettingViewAdapter extends RecyclerView.Adapter<SettingViewAdapter.ViewHolder> {

    private static final String TAG = SettingViewAdapter.class.getSimpleName();
    private String[] names = new String[]{"Account", "Puskesmas", "Report", "History", "Message", "Notification", "Tracker"};
    private int[] icons = new int[]{
            R.drawable.user1,
            R.drawable.bank,
            R.drawable.view,
            R.drawable.history,
            R.drawable.chat,
            R.drawable.noti,
            R.drawable.graph};

    private FragmentPageListener listener;

    public SettingViewAdapter(FragmentPageListener l) {
        listener = l;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.setting_row_layout_with_check, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(names[position]);
        holder.imageView.setImageResource(icons[position]);
        if (holder.getAdapterPosition() < 3) {
            holder.aSwitch.setVisibility(View.GONE);
        }
        holder.textView.setOnClickListener(new ItemClickListener(position));
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        SwitchCompat aSwitch;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.settingName);
            aSwitch = itemView.findViewById(R.id.aSwitch);
            imageView = itemView.findViewById(R.id.listLogo);
        }
    }

    private class ItemClickListener implements View.OnClickListener {

        private int position;

        ItemClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Work In Progress " + position, Snackbar.LENGTH_SHORT).show();
            switch (position) {
                case 0:
                    listener.onSwitchToNextFragment(Constants.SETTINGACCOUNTACTIVITY);
                    break;
                case 1:
                    listener.onSwitchToNextFragment(Constants.SETTINGAREA);
                    break;
                case 2:
                    listener.onSwitchToNextFragment(Constants.SETTINGREPORTACTIVITY);
                    break;
                default:
                    break;
            }
        }
    }
}
