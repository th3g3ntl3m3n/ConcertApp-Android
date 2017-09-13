package th3g3ntl3m3n.concertapp.interfaces;

import java.util.Map;

/**
 * Created by th3g3ntl3m3n on 10/8/17.
 */

public interface FragmentPageListener {

    void onSwitchToNextFragment(int code);

    void onSwitchToNextFragmentActivity(int code);

    void getFragmentCode(int code);

    void isAdmin(int code);

    Map<String, String> getClinicData();

    void setClinicData(Map<String, String> data);


}
