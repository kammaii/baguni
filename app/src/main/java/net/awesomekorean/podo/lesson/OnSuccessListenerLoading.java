package net.awesomekorean.podo.lesson;

import com.google.android.gms.tasks.OnSuccessListener;

import net.awesomekorean.podo.LoadingPage;

public class OnSuccessListenerLoading implements OnSuccessListener<byte[]> {

    private Integer index;
    private LessonFrame lessonFrame;
    private LessonWord lessonWord;

    OnSuccessListenerLoading(Integer index, LessonFrame lessonFrame, LessonWord lessonWord) {
        this.index = index;
        this.lessonFrame = lessonFrame;
        this.lessonWord = lessonWord;
    }

    @Override
    public void onSuccess(byte[] bytes) {
        System.out.println("오디오를 로드했습니다.");
        lessonFrame.wordAudioByte.put(index, bytes);
        if(index == 0 && LoadingPage.activity != null) {
            LoadingPage loadingPage = (LoadingPage)LoadingPage.activity;
            loadingPage.finish();

            lessonFrame.replaceFragment(lessonWord);
        }
    }
}
