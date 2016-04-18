package main.nba_standings.ui.favourite_details;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.R;
import main.nba_standings.model.FavouriteTeamData;

public class FavouriteDetailsFragment extends Fragment implements FavouriteDetailsScreen {
    private View rootView = null;

    @Inject
    FavouriteDetailsPresenter favouriteDetailsPresenter;

    public FavouriteDetailsFragment() {
        NbaStandingsApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        favouriteDetailsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        favouriteDetailsPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_favourite_details, container, false);

        refreshTeamData();

        Button deleteButton = (Button) rootView.findViewById(R.id.DeleteFavouriteTeamButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouriteDetailsPresenter.deleteFavouriteTeam();
            }
        });

        return rootView;
    }

    @Override
    public void showTeamData(FavouriteTeamData favouriteTeamData) {
        TableLayout favouriteTeamDataTable = (TableLayout) rootView.findViewById(R.id.teamDataTable);
        favouriteTeamDataTable.removeAllViews();

        TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);

        addOneRow("TEAM NAME", favouriteTeamData.getTeamName(), favouriteTeamDataTable, params, favouriteTeamData);
        addOneRow("CONFERENCE", favouriteTeamData.getConference(), favouriteTeamDataTable, params, favouriteTeamData);

    }

    private void addOneRow(String left, String right, TableLayout favouriteTeamDataTable, TableRow.LayoutParams params, FavouriteTeamData favouriteTeamData) {
        TableRow row = new TableRow(getActivity());
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        row.setGravity(Gravity.CENTER);
        row.setWeightSum(2);

        TextView leftText = new TextView(getActivity());
        leftText.setText(left);
        leftText.setLayoutParams(params);
        leftText.setGravity(Gravity.CENTER);

        TextView rightText = new TextView(getActivity());
        rightText.setText(right);
        rightText.setLayoutParams(params);
        rightText.setGravity(Gravity.CENTER);

        row.addView(leftText);
        row.addView(rightText);

        favouriteTeamDataTable.addView(row, new TableLayout.LayoutParams());
    }

    @Override
    public void showFavouriteFragment() {
        refreshTeamData();
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.container);
        viewPager.setCurrentItem(1);
    }

    @Override
    public void refreshTeamData(){
        favouriteDetailsPresenter.showTeamData();

        Button deleteButton = (Button) rootView.findViewById(R.id.DeleteFavouriteTeamButton);
        if (FavouriteDetailsPresenter.FAVOURITE_TEAM_NAME == null) {
            deleteButton.setEnabled(false);
        } else {
            deleteButton.setEnabled(true);
        }
    }
}