package techkids.vn.freemusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import techkids.vn.freemusic.flagment.DownloadFragment;
import techkids.vn.freemusic.flagment.FavoriteFragment;
import techkids.vn.freemusic.flagment.MusicFragment;

/**
 * Created by ctrls on 15/10/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MusicFragment();
            case 1:
                return new FavoriteFragment();
            case 2:
                return new DownloadFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
