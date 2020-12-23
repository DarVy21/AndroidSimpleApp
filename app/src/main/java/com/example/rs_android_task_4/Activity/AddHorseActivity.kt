package com.example.rs_android_task_4.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rs_android_task_4.MainActivity

import com.example.rs_android_task_4.R
import com.example.rs_android_task_4.data.Horse
import com.example.rs_android_task_4.interfaces.HorseModel
import io.realm.Realm
import kotlinx.android.synthetic.main.add_item.*


class AddHorseActivity : AppCompatActivity() {

    private lateinit var nameET:EditText
    private lateinit var ageET:EditText
    private lateinit var breedET:EditText
    private lateinit var addAnimal_btn:Button
    private lateinit var realm: Realm
    private lateinit var helper: HorseModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item)


        realm = Realm.getDefaultInstance()

        //init views

        nameET = findViewById(R.id.addName)
        ageET = findViewById(R.id.addAge)
        breedET = findViewById(R.id.addBreed)
        addAnimal_btn = findViewById(R.id.addAnimal_btn)

        addAnimal_btn.setOnClickListener {

             saveData()
         }

    }

    private fun saveData() {

        try {


            helper = HorseModel()
            val horse = Horse()
            horse.name = addName.text.toString()
            horse.age = addAge.text.toString()
            horse.breed = addBreed.text.toString()

            //saving to Database
            helper.addHorse(realm,horse)
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, MainActivity::class.java))
            finish()



        } catch (e:Exception){

            Toast.makeText(this,"Failure",Toast.LENGTH_SHORT).show()

        }

    }
}