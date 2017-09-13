package th3g3ntl3m3n.concertapp.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 29/8/17.
 */

public class SettingAreaAdapter
        extends RecyclerView.Adapter<SettingAreaAdapter.ViewHolder> {

    private static final String AREANAME = "AREA NAME";
    static FragmentPageListener listener;
    private static String areaname;
    private ArrayList<DemoUser> demoUserArrayList;

    public SettingAreaAdapter(ArrayList<DemoUser> demoUserList, FragmentPageListener fragmentPageListener) {
        demoUserArrayList = demoUserList;
        listener = fragmentPageListener;
    }

    public static String getAreaname() {
        return areaname;
    }

    public void updateAreas(ArrayList<DemoUser> demoUserArrayList) {
        this.demoUserArrayList = demoUserArrayList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_account_custom_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(AREANAME);
        holder.name.setText(demoUserArrayList.get(position).getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "clicked On Card", Snackbar.LENGTH_SHORT).show();
                areaname = demoUserArrayList.get(position).getName();
                listener.onSwitchToNextFragment(Constants.SETTINGAREAPUSKESMASADD);

            }
        });
    }

    @Override
    public int getItemCount() {
        return demoUserArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, name;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.designation);
            name = itemView.findViewById(R.id.user_name);
        }
    }
}
