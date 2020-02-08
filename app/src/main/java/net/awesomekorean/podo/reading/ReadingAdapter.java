package net.awesomekorean.podo.reading;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.collection.LLRBBlackValueNode;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.LessonFrame;

import java.util.ArrayList;

public class ReadingAdapter extends RecyclerView.Adapter<ReadingAdapter.ViewHolder> {

    // 아이템 클릭 이벤트를 MainLesson 에서 처리하기 위한 인터페이스
    public interface OnItemClickListener {
        void onItemClick(View v, int pos);
    }

    private OnItemClickListener listener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    Context context;

    private ArrayList<Reading> list;

    public ReadingAdapter(Context context, ArrayList<Reading> list) {
        this.context = context;
        this.list = list;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView readingImage;
        ImageView iconLock;
        LinearLayout levelRocket1;
        LinearLayout levelRocket2;
        LinearLayout levelRocket3;
        LinearLayout layoutCompleted;

        ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            readingImage = itemView.findViewById(R.id.readingImage);
            iconLock = itemView.findViewById(R.id.iconLock);
            levelRocket1 = itemView.findViewById(R.id.levelRocket1);
            levelRocket2 = itemView.findViewById(R.id.levelRocket2);
            levelRocket3 = itemView.findViewById(R.id.levelRocket3);
            layoutCompleted = itemView.findViewById(R.id.layoutCompleted);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        Reading item = list.get(position);

                        // 아이템 클릭 이벤트
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

        View view = inflater.inflate(R.layout.main_reading_item, parent, false);
        ReadingAdapter.ViewHolder holder = new ReadingAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Reading items = list.get(position);

        holder.title.setText(items.getTitle());
        holder.readingImage.setImageResource(items.getReadingImage());
        if (items.getIsCompleted()) {
            holder.layoutCompleted.setVisibility(View.VISIBLE);
        } else {
            holder.layoutCompleted.setVisibility(View.INVISIBLE);
        }
        if (items.getIsLock()) {
            holder.iconLock.setVisibility(View.VISIBLE);
        } else {
            holder.iconLock.setVisibility(View.INVISIBLE);
        }

        int readingLevel = items.getReadingLevel();
        if(readingLevel == 1) {
            setLevel(View.VISIBLE, View.GONE, View.GONE, holder);
        } else if(readingLevel == 2) {
            setLevel(View.GONE, View.VISIBLE, View.GONE, holder);
        } else if(readingLevel == 3) {
            setLevel(View.GONE, View.GONE, View.VISIBLE, holder);
        }
    }

    private void setLevel(int rocket1, int rocket2, int rocket3, ViewHolder holder) {
        holder.levelRocket1.setVisibility(rocket1);
        holder.levelRocket2.setVisibility(rocket2);
        holder.levelRocket3.setVisibility(rocket3);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
