package net.awesomekorean.podo.lesson;

import com.google.android.gms.tasks.OnSuccessListener;

import net.awesomekorean.podo.LoadingPage;

import java.util.ArrayList;

public class OnSuccessListenerIntermediate implements OnSuccessListener<byte[]> {

    private Integer index;
    private IntermediateFrame lessonFrame;
    private String lessonId;

    OnSuccessListenerIntermediate(Integer index, IntermediateFrame lessonFrame, String lessonId) {
        this.index = index;
        this.lessonFrame = lessonFrame;
        this.lessonId = lessonId;
    }

    @Override
    public void onSuccess(byte[] bytes) {
        System.out.println("오디오를 로드했습니다.");
        lessonFrame.audiosDialog.put(index, bytes);
        LoadingPage loadingPage = (LoadingPage)LoadingPage.activity;
        lessonFrame.loadingProgress++;
        loadingPage.setTextLoading(lessonFrame.loadingProgress, lessonFrame.dialogLength);

        if(lessonFrame.loadingProgress >= lessonFrame.dialogLength && LoadingPage.activity != null) {
            loadingPage.finish();
            lessonFrame.recyclerView.setEnabled(true);

            lessonFrame.list = new ArrayList<>();
            lessonFrame.adapter = new IntermediateAdapter(lessonFrame.getApplicationContext(), lessonFrame.list, lessonId, lessonFrame.audiosDialog);
            lessonFrame.recyclerView.setAdapter(lessonFrame.adapter);

            lessonFrame.addDialog();
        }
    }
}
