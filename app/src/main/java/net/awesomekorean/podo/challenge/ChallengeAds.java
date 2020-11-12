package net.awesomekorean.podo.challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.awesomekorean.podo.R;

public class ChallengeAds extends Fragment {

    View view;

    public static ChallengeAds newInstance() {
        return new ChallengeAds();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_challenge_ads, container, false);
        return view;
    }
}
