package com.flm.www.upushdemo;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

/**
 * Created by Administrator on 2016/10/19.
 *   ApkzWrgft9y7goFeCor4X_79TiIrU8I_65fjsAOPTZPt
 *
 *
 *
 */
public class PushApplication extends Application{
    private PushAgent mPushAgent;
    @Override
    public void onCreate() {
        super.onCreate();
        mPushAgent = PushAgent.getInstance(this);
        //消息的处理
        mPushAgent.setPushIntentServiceClass(MyPushIntentService.class);
        mPushAgent.setDisplayNotificationNumber(5);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("syso","deviceToken="+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
