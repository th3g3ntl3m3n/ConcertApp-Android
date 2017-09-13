package th3g3ntl3m3n.concertapp.fragments.SettingFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by ram on 9/8/17.
 */

public class SettingDetail extends Fragment {

    static FragmentPageListener listener;

    public SettingDetail() {
    }


    public static SettingDetail newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new SettingDetail();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_detail_layout, container, false);
        return view;
    }
}
