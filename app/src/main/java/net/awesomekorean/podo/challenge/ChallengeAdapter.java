package net.awesomekorean.podo.challenge;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ChallengeAdapter extends FragmentPagerAdapter {

    public ChallengeAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0 :
                return ChallengeAds.newInstance();

            case 1 :
                return ChallengeLessons.newInstance();

            case 2 :
                return ChallengeProgress.newInstance();

            case 3 :
                return ChallengePoints.newInstance();

            default:
                return null;
        }
    }
}
