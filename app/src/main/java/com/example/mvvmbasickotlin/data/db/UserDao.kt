package com.example.mvvmbasickotlin.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmbasickotlin.data.db.entities.CURRENT_USER_ID
import com.example.mvvmbasickotlin.data.db.entities.User

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getuser() : LiveData<User>
}