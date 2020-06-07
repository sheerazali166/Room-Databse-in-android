package com.example.roomdatabaseexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void AddUser(User user);

    @Query("select * from users")
    public List<User> GetAllUsers();

    @Delete
    public void DeleteUser(User user);

    @Update
    public void UpdateUser(User user);
}
