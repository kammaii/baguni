package net.awesomekorean.baguni.collection;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface CollectionDao {

    @Query("SELECT * FROM CollectionEntity ORDER BY id DESC")
    LiveData<List<CollectionEntity>> getAll();

    @Query("SELECT * FROM COLLECTIONENTITY WHERE id = :index")
    CollectionEntity getById(int index);

    @Query("SELECT * FROM COLLECTIONENTITY ORDER BY RANDOM() LIMIT 1")
    CollectionEntity getRandom();

    @Query("SELECT * FROM COLLECTIONENTITY ORDER BY id DESC LIMIT 1 OFFSET :index")
    CollectionEntity getDesc(int index);

    //@Query("SELECT * FROM COLLECTIONENTITY LIMIT 20 OFFSET 0")

    @Query("SELECT COUNT(*) FROM CollectionEntity")
    int getCount();


    @Insert
    void insert(CollectionEntity collectionEntity);

    @Update
    void update(CollectionEntity collectionEntity);

    @Delete
    void delete(CollectionEntity collectionEntity);
}
