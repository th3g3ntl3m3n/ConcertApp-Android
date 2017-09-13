package th3g3ntl3m3n.concertapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.EditReports;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.Setting;

/**
 * Created by ram on 9/8/17.
 */


public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new EditReports();
            case 1:
                // Games fragment activity
                return new Setting();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

}
