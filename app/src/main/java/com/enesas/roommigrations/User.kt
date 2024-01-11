package com.enesas.roommigrations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val email : String,
    val username : String,
    // Diyelim ki daha sonra geldim buraya bir şey daha eklemek istedim. İşte bu durumda scheme değişiyor yani version = 1 değişmek zorunda yani migration gerekecek.
    // Şu hatayı verir eğer gerekli migration yapmazsan: Java.lang.IllegalStateException: Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.
    // https://www.youtube.com/watch?v=hrJZIF7qSSw&t=1290s Bu adamdan öğreniyorum room migration'ı
    @ColumnInfo("yeninesne1", defaultValue = "0")
    val yeninesne2 : Int // Peki ya bu yeninesne1'in ismini değiştirmek isteseydik ve yeninesne2 yapsaydık. O zamanda version 3'e geçecektik ve yeni scheme gelecekti.
)
