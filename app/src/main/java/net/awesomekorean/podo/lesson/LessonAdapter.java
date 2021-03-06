package net.awesomekorean.podo.lesson;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import net.awesomekorean.podo.GetRandomPoint;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UnlockActivity;
import net.awesomekorean.podo.UserInformation;
import net.awesomekorean.podo.lesson.lessonHangul.LessonHangulMenu;
import net.awesomekorean.podo.lesson.lessonNumber.LessonNumberMenu;
import net.awesomekorean.podo.lesson.lessonVideo.LessonVideoMenu;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LessonItem> list;
    private Intent intent;
    int isChallenger;

    public LessonAdapter(Context context, ArrayList<LessonItem> list) {
        this.context = context;
        this.list = list;
        isChallenger = SharedPreferencesInfo.getUserInfo(context).getIsChallenger();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ConstraintLayout layout;
        ConstraintLayout layoutItem;
        ConstraintLayout layoutItemLeft;
        ConstraintLayout layoutItemRight;
        ImageView currentItem;
        TextView tvItemNo;
        TextView tvItemTitle;
        TextView tvItemSubTitle;
        ImageView lineLeftTop;
        ImageView lineLeftBottom;
        ImageView lineRightTop;
        ImageView lineRightBottom;
        LinearLayout layoutProgress;
        TextView tvProgress;


        ViewHolder(final View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.layout);
            layoutItem = itemView.findViewById(R.id.layoutItem);
            layoutItemLeft = itemView.findViewById(R.id.layoutItemLeft);
            layoutItemRight = itemView.findViewById(R.id.layoutItemRight);
            currentItem = itemView.findViewById(R.id.currentItem);
            tvItemNo = itemView.findViewById(R.id.tvItemNo);
            tvItemTitle = itemView.findViewById(R.id.tvItemTitle);
            tvItemSubTitle = itemView.findViewById(R.id.tvItemSubTitle);
            lineLeftTop = itemView.findViewById(R.id.lineLeftTop);
            lineLeftBottom = itemView.findViewById(R.id.lineLeftBottom);
            lineRightTop = itemView.findViewById(R.id.lineRightTop);
            lineRightBottom = itemView.findViewById(R.id.lineRightBottom);
            layoutProgress = itemView.findViewById(R.id.layoutProgress);
            tvProgress = itemView.findViewById(R.id.tvProgress);

            layoutItem.setOnClickListener(this);
            layoutItemLeft.setOnClickListener(this);
            layoutItemRight.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            LessonItem item = list.get(position);

            switch (v.getId()) {

                // 레슨/리뷰/리워드 클릭 이벤트
                case R.id.layoutItem :

                    SharedPreferencesInfo.setLastClickLevel(context, 0);
                    String lessonId = item.getLessonId();
                    String type = item.getLessonId().split("_")[0];

                    if(item.getIsActive() || isChallenger > 0) {

                        if (!item.getIsLocked()) {

                            switch (lessonId) {
                                case "H_hangul":
                                    setCompleteForHangulNumber(lessonId);
                                    intent = new Intent(context, LessonHangulMenu.class);
                                    context.startActivity(intent);
                                    break;

                                case "N_number":
                                    setCompleteForHangulNumber(lessonId);
                                    intent = new Intent(context, LessonNumberMenu.class);
                                    context.startActivity(intent);
                                    break;

                                default:
                                    if (type.equals("LR")) {
                                        intent = new Intent(context, LessonReviewFrame.class);

                                    } else if (type.equals("RW")) {
                                        if(item.getIsCompleted()) {
                                            Toast.makeText(context, context.getString(R.string.ALREADY_REWARDED), Toast.LENGTH_LONG).show();
                                            break;

                                        } else {
                                            intent = new Intent(context, GetRandomPoint.class);
                                        }

                                    } else if (type.equals("L")){
                                        intent = new Intent(context, LessonFrame.class);

                                    } else if (type.equals("IL")) {
                                        //todo: 중급레슨 프레임
                                        SharedPreferencesInfo.setLastClickLevel(context, 1);
                                        intent = new Intent(context, IntermediateFrame.class);

                                    } else if (type.equals("AL")) {
                                        //todo: 고급레슨 프레임
                                    }

                                    intent.putExtra(context.getResources().getString(R.string.LESSON), (Serializable) item);
                                    context.startActivity(intent);
                                    break;

                            }

                        // 포인트 사용 확인창 띄우기
                        } else {
                            intent = new Intent(context, UnlockActivity.class);
                            intent.putExtra(context.getResources().getString(R.string.EXTRA_ID), type);
                            intent.putExtra(context.getResources().getString(R.string.LESSON_ID), item.getLessonId());
                            intent.putExtra(context.getResources().getString(R.string.LESSON), (Serializable) item);
                            intent.putExtra(context.getResources().getString(R.string.EXTRA_ISACTIVE), true);
                            context.startActivity(intent);
                        }
                        SharedPreferencesInfo.setLastClickItem(context, true, position);

                    // 활성화되지 않은 레슨을 클릭했을 때
                    } else {
                        if (!type.equals("RW") && !type.equals("LR")) {
                            intent = new Intent(context, UnlockActivity.class);
                            intent.putExtra(context.getResources().getString(R.string.EXTRA_ID), type);
                            intent.putExtra(context.getResources().getString(R.string.LESSON_ID), item.getLessonId());
                            intent.putExtra(context.getResources().getString(R.string.LESSON), (Serializable) item);
                            intent.putExtra(context.getResources().getString(R.string.EXTRA_ISACTIVE), false);
                            context.startActivity(intent);

                        } else {
                            Toast.makeText(context, context.getString(R.string.PLEASE_COMPLETE_PREVIOUS_LESSON), Toast.LENGTH_LONG).show();
                        }
                    }
                    break;

                // 스페셜레슨 클릭 이벤트
                default:
                    if(item.getSLesson().getIsActive()) {
                        if (!item.getSLesson().getIsLocked()) {
                            intent = new Intent(context, LessonSpecialFrame.class);

                            // 포인트 사용 확인창 띄우기
                        } else {
                            intent = new Intent(context, UnlockActivity.class);
                            intent.putExtra(context.getResources().getString(R.string.EXTRA_ID), context.getResources().getString(R.string.SPECIAL_LESSON));
                            intent.putExtra(context.getResources().getString(R.string.LESSON_ID), item.getSLesson().getLessonId());
                        }
                        intent.putExtra(context.getResources().getString(R.string.LESSON), (Serializable) item.getSLesson());
                        context.startActivity(intent);

                        // 활성화되지 않은 스페셜레슨을 클릭했을 때
                    } else {
                        Toast.makeText(context, context.getString(R.string.PLEASE_COMPLETE_PREVIOUS_LESSON), Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }


    private void setCompleteForHangulNumber(String lessonId) {
        UserInformation userInformation = SharedPreferencesInfo.getUserInfo(context);
        List<String> lessonComplete = userInformation.getLessonComplete();

        if (!lessonComplete.contains(lessonId)) {
            userInformation.updateCompleteList(context, lessonId, false);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.main_lesson_item, parent, false);
        LessonAdapter.ViewHolder holder = new LessonAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LessonItem item = list.get(position);
        holder.tvItemNo.setText(String.valueOf(position));

        if(!item.getIsLocked()) {
            if(item.getLessonSubTitle().length() < 7) {
                holder.tvItemSubTitle.setMaxLines(1);
            } else {
                holder.tvItemSubTitle.setMaxLines(2);
            }
            holder.tvItemSubTitle.setText(item.getLessonSubTitle());
        } else {
            holder.tvItemSubTitle.setText("");
        }

        if(isChallenger == 1) {
            if (item.getDayCount() != null) {
                holder.layoutProgress.setVisibility(View.VISIBLE);
                holder.tvProgress.setText(String.valueOf(item.getDayCount()));
            } else {
                holder.layoutProgress.setVisibility(View.GONE);
            }
        }

        holder.tvItemTitle.setText(item.getLessonTitle());
        holder.layoutItemLeft.setVisibility(View.GONE);
        holder.layoutItemRight.setVisibility(View.GONE);

        if(item.getSLesson() != null) {
            setItemBackground(holder, item.getSLesson(), position);
        }

        if(item.getHasVideo()) {
            setVideoLessonBackground(holder, item);
        }

        setLines(holder, position);
        setItemBackground(holder, item, position);
    }


    // 비디오 레슨 세팅
    private void setVideoLessonBackground(ViewHolder holder, LessonItem item) {
        final String HANGUL = "H_hangul";
        String itemId = item.getLessonId();
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.circle_video_purple);
        holder.layoutItemLeft.getChildAt(1).setBackground(drawable);
        holder.layoutItemRight.getChildAt(1).setBackground(drawable);
        ((TextView)((ConstraintLayout)holder.layoutItemLeft.getChildAt(1)).getChildAt(0)).setText("");
        ((TextView)((ConstraintLayout)holder.layoutItemRight.getChildAt(1)).getChildAt(0)).setText("");
        ((TextView) holder.layoutItemLeft.getChildAt(2)).setText("video");
        ((TextView) holder.layoutItemRight.getChildAt(2)).setText("video");

        intent = new Intent(context, LessonVideoMenu.class);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent);
            }
        };

        holder.layoutItemLeft.setOnClickListener(onClickListener);
        holder.layoutItemRight.setOnClickListener(onClickListener);

        switch (itemId) {
            case HANGUL :
                holder.layoutItemLeft.setVisibility(View.VISIBLE);
                intent.putExtra(context.getResources().getString(R.string.LESSON), HANGUL);
                break;
        }
    }


    // 아이템 라인 세팅
    private void setLines(ViewHolder holder, int position) {
        int leftTop = View.GONE;
        int rightTop = View.GONE;
        int leftBottom = View.GONE;
        int rightBottom = View.GONE;

        if(position == 0) {     // 첫 번째 아이템
            rightBottom = View.VISIBLE;
        } else if(position == list.size() - 1 && position%2 == 1) {   // 마지막 + 홀수 아이템
            rightTop = View.VISIBLE;
        } else if(position == list.size() - 1 && position%2 == 0) {   // 마지막 + 짝수 아이템
            leftTop = View.VISIBLE;
        } else if(position%2 == 1) {    // 홀수 아이템
            rightTop = View.VISIBLE;
            leftBottom = View.VISIBLE;
        } else if(position%2 == 0) {    // 짝수 아이템
            leftTop = View.VISIBLE;
            rightBottom = View.VISIBLE;
        }

        holder.lineLeftTop.setVisibility(leftTop);
        holder.lineRightTop.setVisibility(rightTop);
        holder.lineLeftBottom.setVisibility(leftBottom);
        holder.lineRightBottom.setVisibility(rightBottom);
    }


    // 아이템 백그라운드 세팅
    private void setItemBackground(ViewHolder holder, LessonItem item, int position) {
        String type = item.getLessonId().split("_")[0];
        Drawable drawable = null;

        if(type.equals("RW")) {     // 리워드
            holder.tvItemSubTitle.setText(R.string.REWARDS);
            holder.tvItemSubTitle.setMaxLines(1);
            if(item.getIsCompleted()) {
                drawable = ContextCompat.getDrawable(context, R.drawable.reward_active_purple);

            } else {
                drawable = ContextCompat.getDrawable(context, R.drawable.reward_inactive_purple);
            }

        } else {      // 레슨 & 리뷰 & 스페셜레슨

            if(type.equals("LR")) {     // 리뷰
                holder.tvItemSubTitle.setText(R.string.REVIEW);
                holder.tvItemSubTitle.setMaxLines(1);
            }

            if(type.equals("IL")) {     // 중급레슨
                if (item.getIsLocked()) {
                    drawable = ContextCompat.getDrawable(context, R.drawable.locked_blue);

                } else if (item.getIsCompleted()) {
                    drawable = ContextCompat.getDrawable(context, R.drawable.lesson_active_blue);

                } else {
                    drawable = ContextCompat.getDrawable(context, R.drawable.lesson_inactive_blue);
                }
                holder.tvItemTitle.setTextColor(ContextCompat.getColor(context, R.color.BLUE));
                holder.currentItem.setImageResource(R.drawable.circle_pink);

            } else {
                if (item.getIsLocked()) {
                    drawable = ContextCompat.getDrawable(context, R.drawable.locked_purple);

                } else if (item.getIsCompleted()) {
                    drawable = ContextCompat.getDrawable(context, R.drawable.lesson_active_purple);

                } else {
                    drawable = ContextCompat.getDrawable(context, R.drawable.lesson_inactive_purple);
                }
            }
            holder.tvItemTitle.setTextColor(ContextCompat.getColor(context, R.color.PURPLE));
            holder.currentItem.setImageResource(R.drawable.circle_light_blue);
        }


        if(type.equals("SL")) {
            TextView title;
            TextView subTitle;

            // 짝수번째 스페셜레슨 오른쪽에
            if(position % 2 == 0) {
                holder.layoutItemRight.getChildAt(1).setBackground(drawable);
                title = (TextView)((ConstraintLayout)holder.layoutItemRight.getChildAt(1)).getChildAt(0);
                subTitle = (TextView) holder.layoutItemRight.getChildAt(2);
                subTitle.setText(item.getLessonSubTitle());

                if(!item.getLessonTitle().contains(" ")) {
                    title.setMaxLines(1);
                } else {
                    title.setMaxLines(2);
                }

                if (item.getIsLocked()) {
                    title.setText("");
                } else {
                    title.setText(item.getLessonTitle());
                }

                holder.layoutItemRight.setVisibility(View.VISIBLE);

            // 홀수번째 스페셜레슨 왼쪽에
            } else {
                holder.layoutItemLeft.getChildAt(1).setBackground(drawable);
                title = (TextView)((ConstraintLayout)holder.layoutItemLeft.getChildAt(1)).getChildAt(0);
                subTitle = (TextView) holder.layoutItemLeft.getChildAt(2);
                subTitle.setText(item.getLessonSubTitle());

                if(!item.getLessonTitle().contains(" ")) {
                    title.setMaxLines(1);
                } else {
                    title.setMaxLines(2);
                }

                if (item.getIsLocked()) {
                    title.setText("");
                } else {
                    title.setText(item.getLessonTitle());
                }
                holder.layoutItemLeft.setVisibility(View.VISIBLE);
            }

        } else {
            holder.layoutItem.setBackground(drawable);
        }

        if(item.getIsCurrent()) {
            holder.currentItem.setVisibility(View.VISIBLE);
        } else {
            holder.currentItem.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
