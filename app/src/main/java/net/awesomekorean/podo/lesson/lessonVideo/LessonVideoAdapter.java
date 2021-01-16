package net.awesomekorean.podo.lesson.lessonVideo;

import android.content.Context;
import android.content.Intent;
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

import net.awesomekorean.podo.DialogueActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.lesson.LessonDialogAdapter;
import net.awesomekorean.podo.reading.Reading;

import java.util.ArrayList;

public class LessonVideoAdapter extends RecyclerView.Adapter<LessonVideoAdapter.ViewHolder> {

    // 아이템 클릭 이벤트를 MainLesson 에서 처리하기 위한 인터페이스
    public interface OnItemClickListener {
        void onItemClick(View v, int pos);
    }

    private LessonVideoAdapter.OnItemClickListener listener = null;

    public void setOnItemClickListener(LessonVideoAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

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
                        System.out.println("CLICKED : " + position);

                        if(listener != null) {
                            listener.onItemClick(view, position);
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
        holder.videoNo.setText(String.valueOf(position));

        if (holder.isChallenger == 0) {
            holder.iconLock.setVisibility(View.VISIBLE);

        } else {
            holder.iconLock.setVisibility(View.GONE);
        }

        if (position == 0) {
            holder.iconLock.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return lessonVideo.getVideoTitle().length;
    }
}
