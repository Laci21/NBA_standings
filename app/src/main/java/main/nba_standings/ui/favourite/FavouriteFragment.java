package main.nba_standings.ui.favourite;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;

import java.util.ArrayList;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.R;
import main.nba_standings.ui.favourite_details.FavouriteDetailsPresenter;
import main.nba_standings.ui.main_activity.StandingsActivity;

public class FavouriteFragment extends Fragment implements FavouriteScreen {
    private View rootView = null;

    @Inject
    FavouritePresenter favouritePresenter;

    @Inject
    FavouriteDetailsPresenter favouriteDetailsPresenter;

    public FavouriteFragment() {
        NbaStandingsApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        favouritePresenter.attachScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        StandingsActivity.mTracker.setScreenName("FavouriteFragment");
        StandingsActivity.mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onDetach() {
        favouritePresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_favourite, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.favourite));

        final ListView listView = (ListView) rootView.findViewById(R.id.favourites_text_view);

        favouritePresenter.showTeamNames();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String teamName = (String) parent.getItemAtPosition(position);

                favouriteDetailsPresenter.FAVOURITE_TEAM_NAME = teamName;

                favouriteDetailsPresenter.refreshTeamData();

                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.container);
                viewPager.setCurrentItem(2);
            }
        });

        return rootView;
    }

    @Override
    public void showTeamNames(ArrayList<String> teamNames) {
        final ListView listView = (ListView) rootView.findViewById(R.id.favourites_text_view);

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, teamNames);
        listView.setAdapter(adapter);
    }
}