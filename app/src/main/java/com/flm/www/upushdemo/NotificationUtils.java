package com.flm.www.upushdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;

/**
 * @author swt
 * @time 2016/10/20 9:29
 */
public class NotificationUtils {
    //可当作发送通知栏消息模版使用
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void sendNotification(Context context, int notification_ID, String title, String content) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification myNotify = new Notification();
        myNotify.icon = R.mipmap.icon;
        myNotify.tickerText = "您有新短消息，请注意查收！";
        myNotify.when = System.currentTimeMillis();
        myNotify.flags = Notification.FLAG_AUTO_CANCEL;// 能够自动清除
        RemoteViews rv = new RemoteViews(context.getPackageName(),R.layout.notification_view);
        rv.setTextViewText(R.id.notification_title, title);
        rv.setTextViewText(R.id.notification_text, content);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.mipmap.icon);
        rv.setImageViewBitmap(R.id.notification_large_icon, bitmap);
        myNotify.contentView = rv;
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, ActionConfig.REQUEST_CODE,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        myNotify.contentIntent = contentIntent;
        notificationManager.notify(notification_ID, myNotify);

    }

    //可当作清除通知栏消息模版使用
    public static void deleteNotification(Context context, int id) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(id);
    }
}

