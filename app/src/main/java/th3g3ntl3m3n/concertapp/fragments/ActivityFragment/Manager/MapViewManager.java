package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class MapViewManager extends Fragment {
    static FragmentPageListener listener;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new MapViewManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_map_employee, container, false);
        int userType = Constants.getUserType(getActivity());
        String infoString = "";
        if (userType == Constants.MANAGER) {
            infoString += "User Type\t\t:\t\tManager\n";
        } else {
            infoString += "User Type\t\t:\t\tEmployee\n";
            String pusk = Constants.getPuskName(getActivity());
            infoString += "Puskesmas\t\t:\t\t" + pusk + "\n";
        }
        String areaname = Constants.getAreaName(getActivity());
        infoString += "User Area\t\t:\t\t" + areaname + "\n";
        TextView textView = view.findViewById(R.id.infoText);
        textView.setText(infoString);
        return view;
    }

    public void backPressed() {
        listener.onSwitchToNextFragmentActivity(Constants.FRONTACTIVITYM);
    }
}
