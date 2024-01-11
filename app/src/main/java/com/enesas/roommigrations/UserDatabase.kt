package com.enesas.roommigrations

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [User::class, School::class],
    version = 4, // Burdaki versiyon eğer bizim room scheme'de bir değişiklik varsa algılıyor ve arttırmamızı istiyor.

    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec =  UserDatabase.Migration2To3::class)
    ]
)
abstract class UserDatabase : RoomDatabase() {

    abstract val dao : UserDao

    @RenameColumn("User","yeninesne1","yeninesne2")
    class Migration2To3 : AutoMigrationSpec

// AUTO MIGRATION YALNIZVA BİR NOKTAYA KADAR İŞE YARIYOR. YANİ MESELA DATABASE'E YENİ BİR ENTITY EKLEMEK YANİ YENİ BİR TABLO EKLEMEK İSTERSEK MESELA MANUEL MIGRATION GEREK.
// YANİ DAHA KARMAŞIK İŞLEMLER İÇİN MANUEL GEREKLİ. YANİ BURDAN SONRASI ARTIK manuel migration.

    companion object{
        val migration3To4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS school (name CHAR NOT NULL PRIMARY KEY)") // Yeni entity'mizi database'e ekliyoruz.
            }

        }
    }


}


