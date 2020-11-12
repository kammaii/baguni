package net.awesomekorean.podo.challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.awesomekorean.podo.R;

public class ChallengeProgress extends Fragment {

    View view;

    public static ChallengeProgress newInstance() {
        return new ChallengeProgress();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_challenge_progress, container, false);
        return view;
    }
}
