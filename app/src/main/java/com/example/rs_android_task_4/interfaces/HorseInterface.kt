package com.example.rs_android_task_4.interfaces


import com.example.rs_android_task_4.data.Horse
import io.realm.Realm
import io.realm.RealmResults


interface HorseInterface {

    fun addHorse(realm: Realm, horse: Horse):Boolean
    fun deleteHorse(realm: Realm,id: Int):Boolean
    fun updateHorse(realm: Realm, horse: Horse):Boolean


}