package main.nba_standings.ui.standings;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import main.nba_standings.R;

    public class StandingsFragment extends Fragment implements StandingsScreen {
        public StandingsFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_standings, container, false);

            StandingsPresenter.getInstance().showStandings();

            return rootView;
        }

        @Override
        public void onAttach(final Context context) {
            super.onAttach(context);

            StandingsPresenter.getInstance().attachScreen(this);
        }

        @Override
        public void onDetach() {
            StandingsPresenter.getInstance().detachScreen();
            super.onDetach();
        }

        @Override
        public void showStandings(String[][] standings) {
            //TODO: show standings on TableLayout
        }
    }