package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee;

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
 * Created by th3g3ntl3m3n on 18/8/17.
 */

public class FrontActivity extends Fragment {

    static FragmentPageListener listener;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new FrontActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_front_employee, container, false);

        rootView.findViewById(R.id.fillReport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSwitchToNextFragmentActivity(Constants.EDITACTIVITYE);
            }
        });

        rootView.findViewById(R.id.viewReport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSwitchToNextFragmentActivity(Constants.VIEWACTIVITYE);
            }
        });

        rootView.findViewById(R.id.mapView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSwitchToNextFragmentActivity(Constants.MAPVIEWACTIVITYE);
            }
        });

        return rootView;
    }
}
