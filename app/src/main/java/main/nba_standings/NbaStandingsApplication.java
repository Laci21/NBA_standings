package main.nba_standings;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarApp;
import com.orm.SugarContext;

import io.fabric.sdk.android.Fabric;
import main.nba_standings.ui.UIModule;

public class NbaStandingsApplication extends SugarApp {

    public static NbaStandingsApplicationComponent injector;
    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        SugarContext.init(this);

        injector =
                DaggerNbaStandingsApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        SugarContext.terminate();
    }

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}