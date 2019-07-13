package net.awesomekorean.baguni.lesson;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.awesomekorean.baguni.R;
import java.util.Random;

public class LessonWordQuiz1 extends Fragment implements Button.OnClickListener{

    View view;
    String[] wordsForQuiz; // 레슨의 단어 묶음을 퀴즈용으로 사용하기 위해 복사함
    String word; // 퀴즈용 단어 묶음에 있는 각 단어
    String[] syllables; // wordInIndex의 단어를 각 음절로 나눔
    TextView wordQuiz1Answer; // 입력한 정답이 표시되는 텍스트뷰
    LinearLayout wordQuiz1Selector; // 정답을 입력하는 버튼이 들어가는 layout
    Button btnSelector; // 정답을 입력하기 위해 만들어진 한글 버튼
    Button btnReset;
    Button btnBackToWord;
    int quizNo = 0; // 단어퀴즈 순서
    View.OnClickListener selectorButtonClick; // 정답 입력 버튼 클릭 시 작동하는 함수
    ImageView correctImage; // 정답 시 나오는 이미지

    // fragment 간 전환을 위해 만듦
    public static LessonWordQuiz1 newInstance() {
        return new LessonWordQuiz1();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // wordInKorean의 length-1 만큼 랜덤 숫자 추출. 이 때 숫자 중복 되면 안됨.
        // 해당 index의 단어의 글자수를 파악
        // 파악된 글자수만큼 wordQuizAnswer에 textView생성. 각 textView에 숫자로 id 부여. text에는 _ 표시
        // 해당 단어의 글자를 분해해서 랜덤으로 버튼 만들기
        // 버튼 선택하면 해당 텍스트가 순서대로 wordQuizAnswer의 textView에 입력
        // reset 버튼 추가
        // 글자 완성되면 자동으로 정답/오답 표기 후 다음 문제로 넘어감. 오답 시 정답 알려줌.
        // 정답 시 progress bar 진행. 오답 시 wordQuiz 마지막에 다시 나옴. 맞출 때까지 나옴.
        // 모든 문제가 정답으로 표시되면 lessonSentence로 넘어감.

        view = inflater.inflate(R.layout.lesson_word_quiz1, container, false);

        wordsForQuiz = LessonWord.wordInKorean;

        wordQuiz1Answer = view.findViewById(R.id.wordQuiz1Answer);
        wordQuiz1Selector = view.findViewById(R.id.wordQuiz1Selector);

        correctImage = view.findViewById(R.id.correctImage);

        selectorButtonClick = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Button selectedBtn = (Button) view;
                String selectedButton = selectedBtn.getText().toString();
                wordQuiz1Answer.append(selectedButton);

                System.out.println("A : " + wordQuiz1Answer.getText());
                System.out.println("B : " + word);
                System.out.println("TRUE?? : " + wordQuiz1Answer.getText().toString().equals(word));



                if(wordQuiz1Answer.getText().length() == word.length()) {

                    if(wordQuiz1Answer.getText().toString().equals(word)) {
                        // 1. 정답소리 play 추가할 것
                        correctImage.setVisibility(View.VISIBLE);

                        // 1초 후에 정답 이미지 'GONE' 처리
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correctImage.setVisibility(View.GONE);
                            }
                        }, 1000);

                        wordQuiz1Selector.removeAllViews();
                        quizNo++;
                        // 1. quizNo == wordForQuiz.length 이면 Quiz2로 프레그먼트 전환
                        makeQuiz();
                    }

                    wordQuiz1Answer.setText("");
                }

            }
        };


        randomArray(wordsForQuiz);

        makeQuiz();

        btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(this);
        btnBackToWord = view.findViewById(R.id.btnBackToWord);
        btnBackToWord.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnReset :
                wordQuiz1Answer.setText("");
                break;

            case R.id.btnBackToWord :
                ((LessonFrame)getActivity()).replaceFragment(LessonWord.newInstance());
                break;

        }
    }



    // word의 단어를 음절로 나누고 램덤으로 섞어서 버튼으로 만들어 줌
    public void makeQuiz() {

        if(quizNo == wordsForQuiz.length) {

            // LessonWordQuiz2로 넘어감

        }

        word = wordsForQuiz[quizNo];

        syllables = new String[word.length()];

        for(int i=0; i<word.length(); i++) {
            syllables[i] = word.substring(i, i+1);
        }

        randomArray(syllables);

        for(int i=0; i<syllables.length; i++) {

            btnSelector = new Button(getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(dpToPx(50), dpToPx(50));
            btnSelector.setLayoutParams(params);
            btnSelector.setText(syllables[i]);
            btnSelector.setOnClickListener(selectorButtonClick);
            wordQuiz1Selector.addView(btnSelector);
        }
    }



    // 입력받은 array를 랜덤으로 섞어주는 함수
    public void randomArray(String[] strings) {

        for (int i = 0; i < strings.length; i++) {

            Random random = new Random();
            int rnum = random.nextInt(strings.length);

            String temp = strings[i];
            strings[i] = strings[rnum];
            strings[rnum] = temp;
        }

    }

    // dp 단위를 입력하면 pixel 단위로 변환해줌
    public int dpToPx(int dp) {

        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (dp * scale + 0.5f);
        return pixels;
    }


}