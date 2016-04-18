package main.nba_standings;

import android.app.Application;

import com.orm.SugarApp;

import main.nba_standings.ui.UIModule;

public class NbaStandingsApplication extends SugarApp {

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