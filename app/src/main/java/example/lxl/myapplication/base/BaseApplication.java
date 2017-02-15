package example.lxl.myapplication.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import example.lxl.myapplication.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by lxl on 2016/10/28.
 */

public class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks{
    List<Activity> activityLists=new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath( "fonts/Roboto-Black.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activityLists.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activityLists.remove(activity);
    }
    public List<Activity> getActivityLists(){
        return activityLists;
    }
}
