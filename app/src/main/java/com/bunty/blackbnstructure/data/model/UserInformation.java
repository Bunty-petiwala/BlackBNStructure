package com.bunty.blackbnstructure.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user_information")
public class UserInformation {

    @PrimaryKey()
    @NonNull
    @Expose
    @SerializedName("user_id")
    @ColumnInfo(name = "user_id")
    private String userId;

    @SerializedName("user_first_name")
    @ColumnInfo(name = "user_first_name")
    @Expose
    private String userFirstName;

    @SerializedName("user_middle_name")
    @ColumnInfo(name = "user_middle_name")
    @Expose
    private String userMiddleName;

    @SerializedName("user_last_name")
    @ColumnInfo(name = "user_last_name")
    @Expose
    private String userLastName;


    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}
