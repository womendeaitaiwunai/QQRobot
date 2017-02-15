package example.lxl.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import example.lxl.myapplication.service.BaseAccessibilityService;

public class TestActivity extends Activity implements View.OnTouchListener,View.OnClickListener {

    private static final String TAG = "TestActivity";

    private Button mCreateWindowButton;

    private ImageView mImageView;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        BaseAccessibilityService.getInstance().init(TestActivity.this);
        initView();
    }

    private void initView() {
        mCreateWindowButton = (Button) findViewById(R.id.button1);
        mCreateWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
                //requestAlertWindowPermission();
                //checkPermission();
                onButtonClick(v);
            }
        });
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);


        findViewById(R.id.button2).setOnClickListener(this);
    }


    private void sendNotification() {

        Intent intent=new Intent();
        intent.setComponent(new ComponentName("example.lxl.myapplication", "example.lxl.myapplication.TestActivity"));

        PendingIntent mainPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                //设置小图标
        builder.setSmallIcon(R.mipmap.title);
                //设置通知标题
        builder.setContentTitle("点击这个到主页");
                //设置通知内容
        builder.setContentText("手机底部坏了，只能做个这样的");

        builder.setContentIntent(mainPendingIntent);
        //设置通知时间，默认为系统发出通知的时间，通常不用设置
        //.setWhen(System.currentTimeMillis());
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        Notification  notification=builder.build();
        notification.flags= Notification.FLAG_NO_CLEAR;
        notification.contentIntent=mainPendingIntent;
        notification.tickerText="哈哈";
        notifyManager.notify(1,notification);
    }

    private void checkPermission(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            //大于23版本的时候
            if (checkSelfPermission(Manifest.permission.SYSTEM_ALERT_WINDOW)!= PackageManager.PERMISSION_GRANTED){
                //requestPermissions(new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW},0x56);
                requestAlertWindowPermission();
            }else {
                onButtonClick(mCreateWindowButton);
            }
        }else {
            //低于23版本的时候
            if (ContextCompat.checkSelfPermission(TestActivity.this,Manifest.permission.SYSTEM_ALERT_WINDOW)
                    != PackageManager.PERMISSION_GRANTED){
            }else {

            }
        }
    }

    private static final int REQUEST_CODE = 1;
    private  void requestAlertWindowPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (Settings.canDrawOverlays(this)) {
                Log.i("TestActivity", "onActivityResult granted");
            }
        }
    }

    public void onButtonClick(View v) {

        if (v == mCreateWindowButton) {
            if (mImageView!=null){
                mWindowManager.removeView(mImageView);
            }
            mImageView = new ImageView(this);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(60,60);
            mImageView.setLayoutParams(params);
            mImageView.setBackgroundResource(R.mipmap.title);
            mLayoutParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0,
                    PixelFormat.TRANSPARENT);
            mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
            mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
            mLayoutParams.x = 100;
            mLayoutParams.y = 300;
            mImageView.setOnTouchListener(this);
            mImageView.setOnClickListener(this);
            try {
                mWindowManager.addView(mImageView, mLayoutParams);
            }catch (Exception e){
                requestAlertWindowPermission();
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==0x56&&permissions.length!=0){
            Toast.makeText(this, "获取到了权限", Toast.LENGTH_SHORT).show();
            onButtonClick(mCreateWindowButton);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN: {
            break;
        }
        case MotionEvent.ACTION_MOVE: {
            Log.d(TAG, "onTouch: rawX " + rawX);
            Log.d(TAG, "onTouch: rawY " + rawY);
            mLayoutParams.x = rawX;
            mLayoutParams.y = rawY;
            mWindowManager.updateViewLayout(mImageView, mLayoutParams);
            break;
        }
        case MotionEvent.ACTION_UP: {
            break;
        }
        default:
            break;
        }
        return false;
    }

//    @Override
//    protected void onDestroy() {
//        try {
//            mWindowManager.removeView(mImageView);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//        super.onDestroy();
//    }

    @Override
    public void onClick(View v) {
        if (v==mImageView){
            //Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(Intent.ACTION_MAIN);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addCategory(Intent.CATEGORY_HOME);
            startActivity(i);
        }else {
            BaseAccessibilityService.getInstance().goAccess();
        }

    }
}