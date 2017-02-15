package example.lxl.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import example.lxl.myapplication.TextSurfActivity;

/**
 * 开机自启动
 */
public class BootupReceiver extends BroadcastReceiver {
 
 @Override
 public void onReceive(Context context, Intent intent) {
 
 //better delay some time.
 try {
 Thread.sleep(2000);
 } catch (InterruptedException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 Intent i = new Intent(context, TextSurfActivity.class);
 i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 context.startActivity(i);
 
 }
 
}
 