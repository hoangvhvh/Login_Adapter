package org.coolstyles.demologin;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class YourMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_main);

        handleNotificationClick();
    }

    private void handleNotificationClick() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("selectedTechnology")) {
            String selectedTechnology = extras.getString("selectedTechnology", "");

            Toast.makeText(this, "Notification Clicked! Selected Technology: " + selectedTechnology, Toast.LENGTH_SHORT).show();

            clearNotification();
        }
    }

    private void clearNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
    }
}
