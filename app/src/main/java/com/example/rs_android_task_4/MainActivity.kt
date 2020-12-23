package com.example.rs_android_task_4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.rs_android_task_4.Activity.AddHorseActivity
import com.example.rs_android_task_4.adapter.HorseAdapter
import com.example.rs_android_task_4.data.Horse
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm
    private  var horselist = ArrayList<Horse>()
    private lateinit var fab_add: FloatingActionButton



    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init realm
        realm = Realm.getDefaultInstance()


        //init views
        val  recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        fab_add = findViewById(R.id.fab_add)

//        // layout manager
//        todoRV.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayout.VERTICAL, false
//        )

        recyclerView.layoutManager = LinearLayoutManager( this, LinearLayout.VERTICAL, false)


        fab_add.setOnClickListener {

            startActivity(Intent(this, AddHorseActivity::class.java))
        }

        getAllTodo()

        fab_add.setOnLongClickListener {



            realm.beginTransaction()
            realm.deleteAll()
            realm.commitTransaction()

            getAllTodo()

            return@setOnLongClickListener true

        }


    }


    private fun getAllTodo() {


        horselist = ArrayList()

        val results: RealmResults<Horse> = realm.where<Horse>(
            Horse::class.java
        ).findAll()


        recyclerView.adapter = HorseAdapter(this, results)





    }

}
