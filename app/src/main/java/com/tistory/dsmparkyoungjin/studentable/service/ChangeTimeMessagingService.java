package com.tistory.dsmparkyoungjin.studentable.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.domain.local.NoticePrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.NoticePrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

import java.util.Objects;
import java.util.Random;

public class ChangeTimeMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NoticePrefHelper prefHelper = new NoticePrefHelperImpl(getApplicationContext());

        if (prefHelper.isEnable()) {
            showNotification(
                    Objects.requireNonNull(remoteMessage.getNotification()).getTitle(),
                    remoteMessage.getNotification().getBody()
            );
        }
    }

    private void showNotification(String title, String body) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "com.tistory.dsmparkyoungjin.studentable";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            notificationChannel.setDescription("CHANNEL");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);

            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(body)
                .setContentInfo("info");

        assert notificationManager != null;
        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());
    }

    @Override
    public void onNewToken(@NonNull String s) {
        refreshToken(s);
    }

    private void refreshToken(String newToken) {
        SetRepository setRepository = new SetRepositoryImpl(getApplicationContext());
        setRepository.setStudent(newToken);
    }
}
