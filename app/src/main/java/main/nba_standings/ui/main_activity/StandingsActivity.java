package main.nba_standings.ui.main_activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.R;
import main.nba_standings.interactor.dal.server.ServerInteractor;
import main.nba_standings.model.TeamDataTable;
import main.nba_standings.ui.favourite.FavouriteFragment;
import main.nba_standings.ui.favourite_details.FavouriteDetailsFragment;
import main.nba_standings.ui.standings.StandingsFragment;

public class StandingsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Inject
    ServerInteractor serverInteractor;

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        NbaStandingsApplication.injector.inject(this);

        saveTeams();
    }

    private void saveTeams() {
        serverInteractor.flushDB();

        serverInteractor.saveTeam(new TeamDataTable(1, "Golden State", 73, 9, "A", "A", "A", "A", "A", false));
        serverInteractor.saveTeam(new TeamDataTable(2, "San Antonio", 69, 13, "B", "B", "B", "B", "B", false));
        serverInteractor.saveTeam(new TeamDataTable(3, "Cleveland Cavaliers", 57, 25, "C", "C", "C", "C", "C", false));
        serverInteractor.saveTeam(new TeamDataTable(4, "Toronto Raptors", 56, 26, "D", "D", "D", "D", "D", false));
        serverInteractor.saveTeam(new TeamDataTable(5, "Oklahoma City", 55, 27, "E", "E", "E", "E", "E", false));
        serverInteractor.saveTeam(new TeamDataTable(6, "L.A. Clippers", 53, 29, "F", "F", "F", "F", "F", false));

        serverInteractor.findAllTeams();

        serverInteractor.findTeam("Golden State");
        serverInteractor.findTeam("Golden Statee");

        serverInteractor.updateTeam(new TeamDataTable(3, "Cleveland Cavaliers", 61, 19, "A", "A", "A", "A", "A", false));

        serverInteractor.deleteTeam("San Antonio");
        serverInteractor.saveTeam(new TeamDataTable(2, "San Antonio", 67, 15, "A", "A", "A", "A", "A", false));
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new StandingsFragment();
            } else if (position == 1) {
                return new FavouriteFragment();
            } else {
                return new FavouriteDetailsFragment();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
