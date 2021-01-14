package net.awesomekorean.podo.lesson.lessonVideo;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.reading.Reading;

import java.util.ArrayList;

public class LessonVideoAdapter extends RecyclerView.Adapter<LessonVideoAdapter.ViewHolder> {

    Context context;

    private Video lessonVideo;

    public LessonVideoAdapter(Context context, Video lessonVideo) {
        this.context = context;
        this.lessonVideo = lessonVideo;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView videoTitle;
        ImageView videoImage;
        TextView videoNo;
        ImageView iconLock;
        int isChallenger;


        ViewHolder(View itemView) {
            super(itemView);

            videoTitle = itemView.findViewById(R.id.videoTitle);
            videoImage = itemView.findViewById(R.id.videoImage);
            videoNo = itemView.findViewById(R.id.videoNo);
            iconLock = itemView.findViewById(R.id.iconLock);
            isChallenger = SharedPreferencesInfo.getUserInfo(context).getIsChallenger();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(position != RecyclerView.NO_POSITION) {

                        if(position == 0) {
                            //todo: 샘플 동영상 재생

                        } else if(isChallenger == 0) {
                            //todo: 챌린저 권유창 띄우기

                        } else {
                            //todo : 클릭한 동영상 재생
                        }
                    }
                }
            });
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_lesson_video_item, parent, false);
        LessonVideoAdapter.ViewHolder holder = new LessonVideoAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.videoTitle.setText(lessonVideo.getVideoTitle()[position]);
        holder.videoImage.setImageResource(lessonVideo.getVideoImage()[position]);
        holder.videoNo.setText(position);


        if (position == 0) {
            holder.iconLock.setVisibility(View.GONE);

        } else {
            if (holder.isChallenger == 0) {
                holder.iconLock.setVisibility(View.VISIBLE);

            } else {
                holder.iconLock.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public int getItemCount() {
        return lessonVideo.getVideoTitle().length;
    }
}
