package th3g3ntl3m3n.concertapp.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.data.DemoUser;

/**
 * Created by th3g3ntl3m3n on 23/8/17.
 */

public class SettingAccountFragmentAdapter
        extends RecyclerView.Adapter<SettingAccountFragmentAdapter.ViewHolder> {

    private static final String TAG = SettingAccountFragmentAdapter.class.getSimpleName();
    ArrayList<DemoUser> dataUsers;
    String empDesig;

    public SettingAccountFragmentAdapter() {
        this.dataUsers = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_account_custom_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + dataUsers.get(position).getType());
        if (Integer.parseInt(dataUsers.get(position).getType()) == Constants.MANAGER) {
            empDesig = "Manager";
        } else {
            empDesig = "Employee";
        }
        holder.designation.setText(empDesig);
        holder.user_name.setText(dataUsers.get(position).getName());
    }

    public void updateDataSet(ArrayList<DemoUser> demoUsers) {
        this.dataUsers = demoUsers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataUsers.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView designation, user_name;

        public ViewHolder(View itemView) {
            super(itemView);
            designation = itemView.findViewById(R.id.designation);
            user_name = itemView.findViewById(R.id.user_name);
            designation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "clicked here", Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
