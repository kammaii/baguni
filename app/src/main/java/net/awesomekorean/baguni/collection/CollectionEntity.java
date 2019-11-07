package net.awesomekorean.baguni.collection;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "COLLECTION")
public class CollectionEntity {

    @PrimaryKey(autoGenerate = true)
    private int itemId;
    private int userId;
    private String guid;
    private String front;
    private String back;
    private String audio = "file path"; // 임의로 오디오 경로 설정
    private String dateNew;
    private String dateEdit;
    private int deleted = 0; // 0=false, 1=true

    @Ignore
    public CollectionEntity() {

    }

    public CollectionEntity(String front, String back) {

        this.front = front;
        this.back = back;

        // GUID 생성하기
        this.guid = UUID.randomUUID().toString();

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDateNew() {
        return dateNew;
    }

    public void setDateNew(String dateNew) {
        this.dateNew = dateNew;
    }

    public String getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(String dateEdit) {
        this.dateEdit = dateEdit;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
