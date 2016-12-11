package com.flm.www.upushdemo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.umeng.message.UmengMessageService;
import com.umeng.message.entity.UMessage;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/**
 * Developer defined push intent service.
 * Remember to call {@link com.umeng.message.PushAgent#setPushIntentServiceClass(Class)}.
 *
 * @author lucas
 */
//完全自定义处理类
public class MyPushIntentService extends UmengMessageService {

    @Override
    public void onMessage(Context context, Intent intent) {
        try {
            //可以通过MESSAGE_BODY取得消息体
            String message = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
            UMessage msg = new UMessage(new JSONObject(message));
            Log.i("syso", "message=" + message);    //消息体
            Log.i("syso", "custom=" + msg.custom);    //自定义消息的内容
            Log.i("syso", "title=" + msg.title);    //通知标题
            Log.i("syso", "text=" + msg.text);    //通知内容
            NotificationUtils.sendNotification(context, ActionConfig.NOTIFICATION_ID, msg.title, msg.text);
        } catch (Exception e) {
            Log.i("syso", e.getMessage());
        }
    }
}
