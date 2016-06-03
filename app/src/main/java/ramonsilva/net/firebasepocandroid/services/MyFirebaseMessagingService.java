package ramonsilva.net.firebasepocandroid.services;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import ramonsilva.net.firebasepocandroid.R;

/**
 * Created by ramonsilva on 19/05/16.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();
    private static final int ID_NOTIFICACAO = 1000;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle("Notificacao do Firebase")
                        .setSound(defaultSoundUri)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText(remoteMessage.getNotification().getBody());

        NotificationManager mNotificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);


        mNotificationManager.notify(ID_NOTIFICACAO, mBuilder.build());

    }
}
