package main.nba_standings;

import javax.inject.Singleton;

import dagger.Component;
import main.nba_standings.interactor.InteractorModule;
import main.nba_standings.interactor.dal.favourite.FavouriteInteractor;
import main.nba_standings.interactor.dal.favourite_details.FavouriteDetailsInteractor;
import main.nba_standings.interactor.dal.standings.StandingsInteractor;
import main.nba_standings.ui.UIModule;
import main.nba_standings.ui.favourite.FavouriteFragment;
import main.nba_standings.ui.favourite.FavouritePresenter;
import main.nba_standings.ui.favourite_details.FavouriteDetailsFragment;
import main.nba_standings.ui.favourite_details.FavouriteDetailsPresenter;
import main.nba_standings.ui.standings.StandingsFragment;
import main.nba_standings.ui.standings.StandingsPresenter;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})
public interface NbaStandingsApplicationComponent {
    void inject(StandingsFragment standingsFragment);

    void inject(FavouriteFragment favouriteFragment);

    void inject(FavouriteDetailsFragment favouriteDetailsFragment);

    void inject(StandingsPresenter standingsPresenter);

    void inject(FavouritePresenter favouritePresenter);

    void inject(FavouriteDetailsPresenter favouriteDetailsPresenter);

    void inject(StandingsInteractor standingsInteractor);

    void inject(FavouriteInteractor favouriteInteractor);

    void inject(FavouriteDetailsInteractor favouriteDetailsInteractor);
}