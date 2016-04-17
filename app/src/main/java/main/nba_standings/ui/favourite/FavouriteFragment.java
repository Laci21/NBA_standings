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

import java.util.ArrayList;

import main.nba_standings.R;
import main.nba_standings.ui.favourite_details.FavouriteDetailsPresenter;

public class FavouriteFragment extends Fragment implements FavouriteScreen {
    private View rootView = null;

    public FavouriteFragment() {
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        FavouritePresenter.getInstance().attachScreen(this);
    }

    @Override
    public void onDetach() {
        FavouritePresenter.getInstance().detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_favourite, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.favourite));

        final ListView listView = (ListView) rootView.findViewById(R.id.favourites_text_view);

        FavouritePresenter.getInstance().showTeamNames();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String teamName = (String) parent.getItemAtPosition(position);

                FavouriteDetailsPresenter.FAVOURITE_TEAM_NAME = teamName;

                FavouriteDetailsPresenter.getInstance().refreshTeamData();

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