package com.bunty.blackbnstructure.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bunty.blackbnstructure.data.model.UserInformation;

import java.util.List;

@Dao
public interface UserInformationDao {

    @Query("SELECT * FROM user_information")
    LiveData<List<UserInformation>> getAllLocalCriminalInformationData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserData(UserInformation userInformationEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsersData(List<UserInformation> userInformation);

    @Query("DELETE FROM user_information")
    void deleteAllRecord();
}
