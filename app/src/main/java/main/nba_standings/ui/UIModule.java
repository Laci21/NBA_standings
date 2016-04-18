package main.nba_standings.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import main.nba_standings.ui.favourite.FavouritePresenter;
import main.nba_standings.ui.favourite_details.FavouriteDetailsPresenter;
import main.nba_standings.ui.standings.StandingsPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public StandingsPresenter provideStandingsPresenter() {
        return new StandingsPresenter();
    }

    @Provides
    @Singleton
    public FavouritePresenter provideFavouritePresenter() {
        return new FavouritePresenter();
    }

    @Provides
    @Singleton
    public FavouriteDetailsPresenter provideFavouriteDetailsPresenter() {
        return new FavouriteDetailsPresenter();
    }
}