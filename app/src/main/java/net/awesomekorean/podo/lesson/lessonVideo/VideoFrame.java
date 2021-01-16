package net.awesomekorean.podo.lesson.lessonVideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import net.awesomekorean.podo.R;

import kr.co.prnd.YouTubePlayerView;

public class VideoFrame extends AppCompatActivity {

    YouTubePlayerView videoView;
    final String VIDEO = "video";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_frame);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView = findViewById(R.id.videoView);

        String videoId = getIntent().getStringExtra(VIDEO);
        videoView.play(videoId, new YouTubePlayerView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}