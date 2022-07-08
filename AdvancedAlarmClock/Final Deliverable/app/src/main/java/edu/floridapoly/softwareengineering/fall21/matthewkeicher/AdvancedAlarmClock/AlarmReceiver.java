package edu.floridapoly.softwareengineering.fall21.matthewkeicher.AdvancedAlarmClock;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Opens a new activity if the user presses the notification
        Intent i = new Intent(context, DestinationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);
        // Creates a notification to show the alarm has been set off
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "AdvancedAlarm")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Advanced Alarm")
                .setContentText("Advanced Alarm Clock App")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123, builder.build());
    }
}
