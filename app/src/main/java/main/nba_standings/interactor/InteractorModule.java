package main.nba_standings.interactor;

import dagger.Module;
import dagger.Provides;
import main.nba_standings.interactor.favourite.FavouriteInteractor;
import main.nba_standings.interactor.favourite_details.FavouriteDetailsInteractor;
import main.nba_standings.interactor.standings.StandingsInteractor;

@Module
public class InteractorModule {
    @Provides
    public StandingsInteractor provideStandingsInteractor() {
        return new StandingsInteractor();
    }

    @Provides
    public FavouriteInteractor provideFavouriteInteractor() {
        return new FavouriteInteractor();
    }

    @Provides
    public FavouriteDetailsInteractor provideFavouriteDetailsInteractor() {
        return new FavouriteDetailsInteractor();
    }
}