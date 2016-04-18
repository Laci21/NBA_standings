package main.nba_standings.interactor;

import dagger.Module;
import dagger.Provides;
import main.nba_standings.interactor.dal.favourite.FavouriteInteractor;
import main.nba_standings.interactor.dal.favourite_details.FavouriteDetailsInteractor;
import main.nba_standings.interactor.dal.standings.StandingsInteractor;

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