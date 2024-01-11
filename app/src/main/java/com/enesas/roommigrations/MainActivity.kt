package com.enesas.roommigrations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.enesas.roommigrations.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(applicationContext,
            UserDatabase::class.java,
            "usersdatabase"
        ).addMigrations(UserDatabase.migration3To4).build()

        lifecycleScope.launch {
            db.dao.getSchools().forEach {
                println(it)
            }
        }


/*
        (1..10).forEach {
            lifecycleScope.launch {
                db.dao.insertSchool(
                    School(
                        name = "test$it"
                    )
                )
            }
        }

 */



        /* BURASI AUTOMIGRATION KISMI İÇİNDİ
                lifecycleScope.launch { // Sonra burada bastırdık.
                    db.dao.getUsers().forEach {
                        println(it)
                    }
                }


                (1..10).forEach {
                    lifecycleScope.launch {// Coroutine ike çalışmalıyız ki threading'te sıkıntı olmasın.
                        db.dao.insertUser(
                            User(
                                email = "test@test$it.com", // basitçe tablomuzdaki email ve username columnlarına 1 den 10' kadar bu değerleri ekledik. Sonra yorum satırına aldık.
                                username = "test$it"
                            )
                        )
                    }
                }

         */
    }
}