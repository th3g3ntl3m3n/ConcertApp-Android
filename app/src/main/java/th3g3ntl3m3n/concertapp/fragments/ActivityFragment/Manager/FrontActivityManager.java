package th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class FrontActivityManager extends Fragment {

    static FragmentPageListener listener;

    public static Fragment newInstance(FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        return new FrontActivityManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_front_manager, container, false);

        (view.findViewById(R.id.viewReport)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "CLICKED", Snackbar.LENGTH_LONG).show();
                listener.onSwitchToNextFragmentActivity(Constants.VIEWREPORTACTIVITYM);
            }
        });

        (view.findViewById(R.id.mapView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "CLICKED AGAIN", Snackbar.LENGTH_LONG).show();
                listener.onSwitchToNextFragmentActivity(Constants.MAPVIEWM);
            }
        });

        return view;
    }
}
