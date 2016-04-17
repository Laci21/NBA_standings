package main.nba_standings.ui.favourite_details;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import main.nba_standings.R;

public class FavouriteDetailsFragment extends Fragment implements FavouriteDetailsScreen{
    public FavouriteDetailsFragment() {
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        FavouriteDetailsPresenter.getInstance().attachScreen(this);
    }

    @Override
    public void onDetach() {
        FavouriteDetailsPresenter.getInstance().detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourite_details, container, false);

        FavouriteDetailsPresenter.getInstance().showTeamData();

        Button deleteButton = (Button) rootView.findViewById(R.id.DeleteFavouriteTeamButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteDetailsPresenter.getInstance().deleteFavouriteTeam();
            }
        });

        return rootView;
    }

    @Override
    public void showTeamData(String[] teamData) {
        //TODO: show team data on TableLayout
    }

    @Override
    public void showFavouriteFragment() {
        //TODO: show favourite fragment
    }
}