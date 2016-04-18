package main.nba_standings;

import android.app.Application;

import main.nba_standings.ui.UIModule;

public class NbaStandingsApplication extends Application {

    public static NbaStandingsApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerNbaStandingsApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}