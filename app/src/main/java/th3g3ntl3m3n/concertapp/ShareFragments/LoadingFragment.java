package th3g3ntl3m3n.concertapp.ShareFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import th3g3ntl3m3n.concertapp.R;

/**
 * Created by th3g3ntl3m3n on 14/8/17.
 */

public class LoadingFragment extends Fragment {

    public LoadingFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_image, container, false);

        ImageView img = view.findViewById(R.id.loadingImage);
        Animation rotation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anim);
        rotation.setFillAfter(true);
        img.startAnimation(rotation);
        return view;
    }
}
