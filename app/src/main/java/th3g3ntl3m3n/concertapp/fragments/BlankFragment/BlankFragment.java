package th3g3ntl3m3n.concertapp.fragments.BlankFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th3g3ntl3m3n.concertapp.R;

/**
 * Created by th3g3ntl3m3n on 18/8/17.
 */

public class BlankFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blank_login, container, false);
    }
}
