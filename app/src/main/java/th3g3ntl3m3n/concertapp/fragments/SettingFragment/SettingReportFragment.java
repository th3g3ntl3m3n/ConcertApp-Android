package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 23/8/17.
 */

public class SettingReportFragment extends Fragment {

    static FragmentPageListener listener;

    public static Fragment newInstance(FragmentPageListener l) {
        listener = l;
        return new SettingReportFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.setting_report_fragment_layout, container, false);
    }

    public void backPressed() {
        listener.onSwitchToNextFragment(Constants.SETTINGACTIVITY);
    }
}
