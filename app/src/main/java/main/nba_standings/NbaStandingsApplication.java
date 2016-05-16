package main.nba_standings;

import com.orm.SugarApp;
import com.orm.SugarContext;

import main.nba_standings.ui.UIModule;

public class NbaStandingsApplication extends SugarApp {

    public static NbaStandingsApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

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
}