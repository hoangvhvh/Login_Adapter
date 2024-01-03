package org.coolstyles.demologin;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;

public class AlertDialogExample {

    public static void showAlertDialog(final Activity activity, final Intent intent) {
        final Drawable negativeIcon = activity.getResources().getDrawable(R.drawable.icon_negative);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Tran Duc Hoang CNTT K19");

        final String[] technologies = {"Java", "PHP", "HTML", "SwingMVC", "C#", "Bootstrap", "Javascript"};
        builder.setItems(technologies, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedTechnology = technologies[which];

                dialog.dismiss();

                Toast.makeText(activity, "Đã chọn: " + selectedTechnology, Toast.LENGTH_SHORT).show();

                if (intent != null) {
                    intent.putExtra("selectedTechnology", selectedTechnology);
                    activity.startActivity(intent);

                    // Add notification
                    showNotification(activity, selectedTechnology);
                }
            }
        });

        builder.setCancelable(true);
        builder.setIcon(R.drawable.icon_title);

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(activity, "You choose No button", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        builder.setNegativeButtonIcon(negativeIcon);

        AlertDialog alert = builder.create();
        alert.show();
    }

    private static void showNotification(Activity activity, String selectedTechnology) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Hiển thị Notification")
                .setContentText("Bạn đã chọn công nghệ: " + selectedTechnology)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent notificationIntent = new Intent(activity, YourMainActivity.class); // Replace YourMainActivity with the actual main activity class
        PendingIntent contentIntent = PendingIntent.getActivity(activity, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(activity.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(1, builder.build());
    }
}
