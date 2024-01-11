package com.enesas.roommigrations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School( // Bu yeni entity'i artık manuel migration öğrenmek için açtım.
    @PrimaryKey(autoGenerate = false)
    val name : String
)
