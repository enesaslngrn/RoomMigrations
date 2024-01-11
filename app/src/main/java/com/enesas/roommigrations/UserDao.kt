package com.enesas.roommigrations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Bu OnConflictStrategy.REPLACE şunun için: Eğer database'e hali hazırda var olan bir kullanıcı girmek isterse replace ediyor.
    suspend fun insertUser (user : User)

    @Query("SELECT * FROM user")
    suspend fun getUsers() : List<User>


    // Manuel migration için School class'ı oluşturduk şimdide burada fonksiyonlarını tanımlıyoruz.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool (school: School)

    @Query("SELECT * FROM school")
    suspend fun getSchools() : List<School>
}