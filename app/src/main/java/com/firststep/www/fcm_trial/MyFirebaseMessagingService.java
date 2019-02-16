package com.firststep.www.fcm_trial;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        sendNotiofication(remoteMessage.getNotification().getBody());
    }

    private void sendNotiofication(String body) {
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT );

        Uri defaultSoundUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notioficationBuilder=new NotificationCompat.Builder(this);
        notioficationBuilder.setSmallIcon(R.drawable.common_google_signin_btn_icon_dark);
        notioficationBuilder.setContentTitle("Android");
        notioficationBuilder.setContentText(body);
        notioficationBuilder.setAutoCancel(true);
        notioficationBuilder.setSound(defaultSoundUri);
        notioficationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notioficationBuilder.build());
    }
}
