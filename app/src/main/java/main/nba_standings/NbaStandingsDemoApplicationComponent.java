package main.nba_standings;

import javax.inject.Singleton;

import dagger.Component;
import main.nba_standings.ui.UIModule;
import main.nba_standings.ui.main_activity.StandingsActivity;
import main.nba_standings.ui.standings.StandingsFragment;
import main.nba_standings.ui.standings.StandingsPresenter;

@Singleton
@Component(modules = {UIModule.class})
public interface NbaStandingsDemoApplicationComponent {
    void inject(StandingsFragment standingsFragment);
}