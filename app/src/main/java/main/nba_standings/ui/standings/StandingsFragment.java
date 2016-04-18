package main.nba_standings.ui.standings;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.R;
import main.nba_standings.model.TeamStanding;

public class StandingsFragment extends Fragment implements StandingsScreen {
    private View rootView = null;

    @Inject
    StandingsPresenter standingsPresenter;

    public StandingsFragment() {
        NbaStandingsApplication.injector.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_standings, container, false);

        standingsPresenter.showStandings();

        return rootView;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        standingsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        standingsPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void showStandings(ArrayList<TeamStanding> teamStandingList) {
        TableLayout standingsTableLayout = (TableLayout) rootView.findViewById(R.id.standingsTableLayout);

        for (TeamStanding teamStanding : teamStandingList) {
            TableRow row = new TableRow(getActivity());
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            row.setGravity(Gravity.CENTER);
            row.setWeightSum(4);

            TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);

            TextView rank = new TextView(getActivity());
            rank.setText(String.valueOf(teamStanding.getRank()));
            rank.setLayoutParams(params);
            rank.setGravity(Gravity.CENTER);

            TextView team = new TextView(getActivity());
            team.setText(teamStanding.getTeamName());
            team.setLayoutParams(params);
            team.setGravity(Gravity.CENTER);

            TextView win = new TextView(getActivity());
            win.setText(String.valueOf(teamStanding.getWins()));
            win.setLayoutParams(params);
            win.setGravity(Gravity.CENTER);

            TextView loss = new TextView(getActivity());
            loss.setText(String.valueOf(teamStanding.getLosses()));
            loss.setLayoutParams(params);
            loss.setGravity(Gravity.CENTER);

            row.addView(rank);
            row.addView(team);
            row.addView(win);
            row.addView(loss);

            standingsTableLayout.addView(row, new TableLayout.LayoutParams());
        }
    }
}