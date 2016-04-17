package main.nba_standings;

import android.app.Application;

import main.nba_standings.ui.UIModule;

public class NbaStandingsDemoApplication extends Application {

    public static NbaStandingsDemoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerNbaStandingsDemoApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
