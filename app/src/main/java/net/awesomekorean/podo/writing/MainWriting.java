package net.awesomekorean.podo.writing;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UserInformation;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class MainWriting extends Fragment implements View.OnClickListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    View view;

    ListView listView;
    ArrayList<WritingEntity> list = new ArrayList<>(); // 리스트뷰에 표시될 아이템들 10 개씩 끊음
    ArrayList<WritingEntity> listAllData;
    WritingAdapter adapter;

    WritingRepository repository;
    Observer<List<WritingEntity>> observer;

    ProgressBar progressBar;

    LinearLayout msgNoWriting; // 아직 작성한 글이 없습니다.

    ImageButton btnAddWriting; // 플로팅 버튼

    public static LinearLayout msgDelete; // 삭제 확인 메시지 창
    Button btnYes;
    Button btnNo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.main_writing, container, false);

        msgNoWriting = view.findViewById(R.id.msgNoWriting);
        btnAddWriting = view.findViewById(R.id.btnAddWriting);
        listView = view.findViewById(R.id.listViewWriting);
        msgDelete = view.findViewById(R.id.msgDelete);
        btnYes = view.findViewById(R.id.btnYes);
        btnNo = view.findViewById(R.id.btnNo);
        btnAddWriting.setOnClickListener(this);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);


        setListViewFooter();

        repository = new WritingRepository(getContext());

        // 리스트에 변화가 생기면 작동
        observer = new Observer<List<WritingEntity>>() {
            @Override
            public void onChanged(@Nullable List<WritingEntity> entities) {
                listAllData = new ArrayList<>();

                if(entities.size() == 0) {
                    msgNoWriting.setVisibility(View.VISIBLE);
                }else{
                    msgNoWriting.setVisibility(View.GONE);
                }

                for(WritingEntity entity : entities) {
                    WritingEntity items = new WritingEntity();
                    items.setGuid(entity.getGuid());
                    items.setUserEmail(entity.getUserEmail());
                    items.setContents(entity.getContents());
                    items.setLetters(entity.getLetters());
                    items.setWritingDate(entity.getWritingDate());
                    items.setStatus(entity.getStatus());
                    items.setTeacherName(entity.getTeacherName());
                    items.setCorrection(entity.getCorrection());
                    items.setTeacherFeedback(entity.getTeacherFeedback());
                    items.setStudentFeedback(entity.getStudentFeedback());
                    listAllData.add(items);

                    // 교정 중인 writing 이 있으면, DB 접속
                    if (items.getStatus() == 1) {
                        DocumentReference docRef = db.collection(getString(R.string.DB_WRITINGS)).document(items.getGuid());
                        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                WritingEntity download = documentSnapshot.toObject(WritingEntity.class);

                                if (download != null && download.getStatus() > 1) {

                                    // 재작성 요청 시 포인트 반환
                                    if(download.getStatus() == 99) {
                                        System.out.println("컨텐츠 : " + download.getContents());
                                        int returnPoint = download.getLetters();
                                        UserInformation userInformation = SharedPreferencesInfo.getUserInfo(getContext());
                                        System.out.println("기존포인트 : " + userInformation.getPoints());

                                        userInformation.addRewardPoints(getContext(), returnPoint);
                                        System.out.println("포인트를 반환했습니다 : " + returnPoint);
                                    }

                                    System.out.println("글쓰기 교정이 완료되었습니다");
                                    WritingRepository repository = new WritingRepository(getContext());
                                    repository.update(download);
                                    repository.getAll().observe(getViewLifecycleOwner(), observer);
                                }
                            }
                        });
                    }
                }

                if(entities.size()>10) {
                    list = new ArrayList<>(listAllData.subList(0,10));
                }else {
                    list = new ArrayList<>();
                    list = listAllData;
                    progressBar.setVisibility(View.GONE);
                }

                adapter = new WritingAdapter(getContext(), list);
                listView.setAdapter(adapter);
            }
        };

        repository.getAll().observe(this, observer);


        // 리스트의 아이템 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WritingEntity item = (WritingEntity) adapterView.getItemAtPosition(i);

                // 교정완료 된 아이템
                if(item.getStatus() == 0) {
                    Intent intent = new Intent(getContext(), WritingFrame.class);
                    intent.putExtra(getString(R.string.EXTRA_ENTITY), item);
                    intent.putExtra(getString(R.string.REQUEST), getString(R.string.REQUEST_EDIT));
                    intent.putExtra(getString(R.string.STATUS), item.getStatus());
                    startActivityForResult(intent, getResources().getInteger(R.integer.REQUEST_CODE_EDIT));

                } else if (item.getStatus() == 99) {
                    Intent intent = new Intent(getContext(), WritingReturned.class);
                    intent.putExtra(getString(R.string.EXTRA_ENTITY), item);
                    startActivityForResult(intent, 300);

                } else {
                    Intent intent = new Intent(getContext(), WritingCorrected.class);
                    intent.putExtra(getString(R.string.EXTRA_ENTITY), item);
                    startActivityForResult(intent, 300);
                }
            }
        });


        // 리스트뷰 스크롤 이벤트
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {

                if(scrollState == SCROLL_STATE_IDLE && listView.getLastVisiblePosition() == list.size()) {
                    progressBar.setVisibility(View.VISIBLE);
                    loadMoreItems();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        return view;
    }


    // 리스트뷰 맨 마지막까지 스크롤 하면 아이템 더 불러옴
    public void loadMoreItems() {
        int size = list.size();

        for(int i=0;i<10;i++){
            if((size + i+1) <= listAllData.size()){
                list.add(listAllData.get(size + i));
            } else {
                break;
            }
        }
        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }


    // 리스트뷰 footer 로 progressbar 설정함
    public void setListViewFooter() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.main_footer, null);
        progressBar = view.findViewById(R.id.progressBar);
        listView.addFooterView(progressBar);
    }

    // 글쓰기 추가/수정 후 결과 받기
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK) {
            repository.getAll().observe(this, observer);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnAddWriting :
                Intent intent = new Intent(getContext(), WritingFrame.class);
                intent.putExtra(getString(R.string.REQUEST), getString(R.string.REQUEST_ADD));
                startActivityForResult(intent, getResources().getInteger(R.integer.REQUEST_CODE_ADD));
                break;

            case R.id.btnYes :
                String guid = WritingAdapter.guid;
                WritingRepository repository = new WritingRepository(getContext());
                repository.deleteByGuid(guid);
                repository.getAll();
                repository.getAll().observe(this, observer);
                msgDelete.setVisibility(View.GONE);
                break;

            case R.id.btnNo :
                msgDelete.setVisibility(View.GONE);
                break;
        }
    }
}