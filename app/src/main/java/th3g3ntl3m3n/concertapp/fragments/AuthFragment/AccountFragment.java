package th3g3ntl3m3n.concertapp.fragments.AuthFragment;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.FragmentPageListener;

/**
 * Created by ram on 9/8/17.
 */

public class AccountFragment extends Fragment {

    public static final String TAG = AccountFragment.class.getSimpleName();
    static String name;
    static FragmentPageListener listener;

    Context mcontext;

    public static Fragment newInstance(String uname, FragmentPageListener fragmentPageListener) {
        listener = fragmentPageListener;
        name = uname;
        return new AccountFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        mcontext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_account_layout, container, false);

        ((TextView) rootView.findViewById(R.id.username)).setText(name);

        rootView.findViewById(R.id.logoutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Constants.logoutUser(getActivity())) {
                    listener.isAdmin(3);
                    listener.getFragmentCode(Constants.LOGINFRAGMENT);
                    Snackbar.make(container, "LoggedOut Successfully", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(mcontext)
                        .setSmallIcon(android.R.drawable.stat_notify_missed_call)
                        .setContentTitle("Hi There")
                        .setColor(Color.YELLOW)
                        .setContentText("You clicked me");

        Intent notificationIntent = new Intent(Intent.ACTION_SEND);
        PendingIntent contentIntent = PendingIntent.getActivity(mcontext, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) mcontext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(0, builder.build());
        }
    }
}
