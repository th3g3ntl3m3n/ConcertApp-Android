package th3g3ntl3m3n.concertapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee.ActivitiesDetail;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee.EditReports;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee.FrontActivity;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee.MapFragment;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee.ReportDetail;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Employee.ViewReports;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager.DeepDetailReportManager;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager.DetailReportManager;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager.FrontActivityManager;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager.MapViewManager;
import th3g3ntl3m3n.concertapp.fragments.ActivityFragment.Manager.ViewReportManager;
import th3g3ntl3m3n.concertapp.fragments.AuthFragment.AccountFragment;
import th3g3ntl3m3n.concertapp.fragments.AuthFragment.LoginFragment;
import th3g3ntl3m3n.concertapp.fragments.AuthFragment.SignupFragment;
import th3g3ntl3m3n.concertapp.fragments.BlankFragment.BlankFragment;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.Setting;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.SettingAccountAddFragment;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.SettingAccountFragment;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.SettingAreaFragment;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.SettingAreaPuskesmasAddFragment;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.SettingBranchFragment;
import th3g3ntl3m3n.concertapp.fragments.SettingFragment.SettingReportFragment;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

public class MainDataActivity extends AppCompatActivity {

    private static final String TAG = MainDataActivity.class.getSimpleName();
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Fragment baseAuthFragment;
    private FragmentPageListener listener;
    private int userType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_data);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        if (Constants.isUserLoggedIn(this)) {
            baseAuthFragment = AccountFragment.newInstance(Constants.getUsername(this), listener);
        } else {
            baseAuthFragment = LoginFragment.newInstance(listener);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        listener = adapter.new FragmentPagerListener();
        adapter.addFragment(new FrontActivity(), "Activity");
        adapter.addFragment(new AccountFragment(), "Account");
        if (Constants.isUserLoggedIn(this) && (Constants.getUserType(this) == Constants.ADMIN)) {
            adapter.addFragment(new Setting(), "Setting");
        }
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1, true);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 2 && adapter.getItem(2) instanceof SettingReportFragment) {
            ((SettingReportFragment) adapter.getItem(2)).backPressed();
        } else if (viewPager.getCurrentItem() == 2 && adapter.getItem(2) instanceof SettingBranchFragment) {
            ((SettingBranchFragment) adapter.getItem(2)).backPressed();
        } else if (viewPager.getCurrentItem() == 2 && adapter.getItem(2) instanceof SettingAccountFragment) {
            ((SettingAccountFragment) adapter.getItem(2)).backPressed();
        } else if (viewPager.getCurrentItem() == 2 && adapter.getItem(2) instanceof SettingAccountAddFragment) {
            ((SettingAccountAddFragment) adapter.getItem(2)).backPressed();
        } else if (viewPager.getCurrentItem() == 2 && adapter.getItem(2) instanceof SettingAreaFragment) {
            ((SettingAreaFragment) adapter.getItem(2)).backPressed();
        } else if (viewPager.getCurrentItem() == 2 && adapter.getItem(2) instanceof SettingAreaPuskesmasAddFragment) {
            ((SettingAreaPuskesmasAddFragment) adapter.getItem(2)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof ActivitiesDetail) {
            ((ActivitiesDetail) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof MapFragment) {
            ((MapFragment) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof EditReports) {
            ((EditReports) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 1 && adapter.getItem(1) instanceof SignupFragment) {
            ((SignupFragment) adapter.getItem(1)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof ViewReports) {
            ((ViewReports) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof ViewReportManager) {
            ((ViewReportManager) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof ReportDetail) {
            ((ReportDetail) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof MapViewManager) {
            ((MapViewManager) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof DeepDetailReportManager) {
            ((DeepDetailReportManager) adapter.getItem(0)).backPressed();
        } else if (viewPager.getCurrentItem() == 0 && adapter.getItem(0) instanceof DetailReportManager) {
            ((DetailReportManager) adapter.getItem(0)).backPressed();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
            builder.setMessage("Do you really want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                    alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                }
            });
            alert.show();
//            super.onBackPressed();
        }
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        private final FragmentManager fragmentManager;
        private Fragment fragmentAtPos2, fragmentAtPos0;

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
            fragmentManager = manager;

        }

        @Override
        public Fragment getItem(int position) {
            if (position == 2) {

                if (fragmentAtPos2 == null) fragmentAtPos2 = Setting.newInstance(listener);
                if (fragmentAtPos2 instanceof BlankFragment)
                    fragmentAtPos2 = Setting.newInstance(listener);
                if (!Constants.isUserLoggedIn(MainDataActivity.this))
                    fragmentAtPos2 = new BlankFragment();
                return fragmentAtPos2;

            } else if (position == 0) {

                userType = Constants.getUserType(MainDataActivity.this);
                if (fragmentAtPos0 == null) {
                    fragmentAtPos0 = FrontActivity.newInstance(listener);
                    if (userType == Constants.MANAGER) {
                        fragmentAtPos0 = FrontActivityManager.newInstance(listener);
                    }
                }
                if (fragmentAtPos0 instanceof BlankFragment) {
                    fragmentAtPos0 = FrontActivity.newInstance(listener);
                    if (userType == Constants.MANAGER) {
                        fragmentAtPos0 = FrontActivityManager.newInstance(listener);
                    }
                }
                if (!Constants.isUserLoggedIn(MainDataActivity.this)) {
                    fragmentAtPos0 = new BlankFragment();
                }
                Log.d(TAG, "getItem: " + fragmentAtPos0);
                return fragmentAtPos0;

            } else if (position == 1) {

                if (baseAuthFragment == null)
                    baseAuthFragment = LoginFragment.newInstance(listener);
                return baseAuthFragment;

            }
            return null;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public void removeFragment(int position) {
            mFragmentList.remove(position);
            mFragmentTitleList.remove(position);
        }

        @Override
        public int getItemPosition(Object object) {
            Log.d(TAG, "getItemPosition: " + object);
//            if (object instanceof Setting && fragmentAtPos2 instanceof SettingDetail)
//                return POSITION_NONE;
//            if (object instanceof SettingDetail && fragmentAtPos2 instanceof Setting)
//                return POSITION_NONE;
//
//            if (object instanceof EditReports && fragmentAtPos0 instanceof ActivitiesDetail)
//                return POSITION_NONE;
//            if (object instanceof ActivitiesDetail && fragmentAtPos0 instanceof EditReports)
//                return POSITION_NONE;
//
//            if (object instanceof LoginFragment && baseAuthFragment instanceof SignupFragment)
//                return POSITION_NONE;
//            if (object instanceof SignupFragment && baseAuthFragment instanceof LoginFragment)
//                return POSITION_NONE;
//
//            if (object instanceof AccountFragment && baseAuthFragment instanceof LoginFragment)
//                return POSITION_NONE;
//            if (object instanceof LoginFragment && baseAuthFragment instanceof AccountFragment)
//                return POSITION_NONE;

            return POSITION_NONE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        private final class FragmentPagerListener implements FragmentPageListener {
            Map<String, String> dataValues;

            public void onSwitchToNextFragment(int activityCode) {
                fragmentManager.beginTransaction().remove(fragmentAtPos2).commit();
                if (activityCode == Constants.SETTINGACCOUNTACTIVITY) {
                    fragmentAtPos2 = SettingAccountFragment.newInstance(listener);
                } else if (activityCode == Constants.SETTINGACCOUNTADD) {
                    fragmentAtPos2 = SettingAccountAddFragment.newInstance(listener);
                } else if (activityCode == Constants.SETTINGBRANCHACTIVITY) {
                    fragmentAtPos2 = SettingBranchFragment.newInstance(listener);
                } else if (activityCode == Constants.SETTINGREPORTACTIVITY) {
                    fragmentAtPos2 = SettingReportFragment.newInstance(listener);
                } else if (activityCode == Constants.SETTINGACTIVITY) {
                    fragmentAtPos2 = Setting.newInstance(listener);
                } else if (activityCode == Constants.SETTINGAREA) {
                    fragmentAtPos2 = SettingAreaFragment.newInstance(listener);
                } else if (activityCode == Constants.SETTINGAREAPUSKESMASADD) {
                    fragmentAtPos2 = SettingAreaPuskesmasAddFragment.newInstance(listener);
                }
                notifyDataSetChanged();
            }

            public void onSwitchToNextFragmentActivity(int activityCode) {
                fragmentManager.beginTransaction().remove(fragmentAtPos0).commit();
                if (activityCode == Constants.FRONTACTIVITYE) {
                    fragmentAtPos0 = FrontActivity.newInstance(listener);
                } else if (activityCode == Constants.EDITACTIVITYE) {
                    fragmentAtPos0 = EditReports.newInstance(listener);
                } else if (activityCode == Constants.DETAILACTIVITYE) {
                    fragmentAtPos0 = ActivitiesDetail.newInstance(listener);
                } else if (activityCode == Constants.VIEWACTIVITYE) {
                    fragmentAtPos0 = ViewReports.newInstance(listener);
                } else if (activityCode == Constants.VIEWDETAILACTIVITYE) {
                    fragmentAtPos0 = ReportDetail.newInstance(listener);
                } else if (activityCode == Constants.MAPVIEWACTIVITYE) {
                    fragmentAtPos0 = MapFragment.newInstance(listener);
                } else if (activityCode == Constants.VIEWREPORTACTIVITYM) {
                    fragmentAtPos0 = ViewReportManager.newInstance(listener);
                } else if (activityCode == Constants.FRONTACTIVITYM) {
                    fragmentAtPos0 = FrontActivityManager.newInstance(listener);
                    Log.d(TAG, "onSwitchToNextFragmentActivity: " + fragmentAtPos0);
                } else if (activityCode == Constants.DETAILREPORTM) {
                    fragmentAtPos0 = DetailReportManager.newInstance(listener);
                } else if (activityCode == Constants.MAPVIEWM) {
                    fragmentAtPos0 = MapViewManager.newInstance(listener);
                } else if (activityCode == Constants.DEEPDETAILM) {
                    fragmentAtPos0 = DeepDetailReportManager.newInstance(listener);
                }
                notifyDataSetChanged();
            }

            @Override
            public Map<String, String> getClinicData() {
                return dataValues;
            }

            @Override
            public void setClinicData(Map<String, String> data) {
                dataValues = data;
            }

            @Override
            public void getFragmentCode(int code) {
                fragmentManager.beginTransaction().remove(baseAuthFragment).commit();
                if (code == Constants.ACCOUNTFRAGMENT) {
                    baseAuthFragment = AccountFragment.newInstance(Constants.getUsername(getApplicationContext()), listener);
                } else if (code == Constants.LOGINFRAGMENT) {
                    baseAuthFragment = LoginFragment.newInstance(listener);
                } else if (code == Constants.SIGNUPFRAGMENT) {
                    baseAuthFragment = SignupFragment.newInstance(listener);
                }
                notifyDataSetChanged();
            }

            @Override
            public void isAdmin(int code) {
                Log.d(TAG, "isAdmin: " + code);
                if (code == 1) {
                    adapter.addFragment(new Setting(), "Setting");
                } else {
                    if (mFragmentList.size() == 3) {
                        adapter.removeFragment(2);
                    }
                }
                notifyDataSetChanged();
            }
        }
    }
}
