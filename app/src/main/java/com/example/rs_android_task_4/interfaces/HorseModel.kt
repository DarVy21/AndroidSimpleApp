package com.example.rs_android_task_4.interfaces


import com.example.rs_android_task_4.data.Horse
import io.realm.Realm

class HorseModel :HorseInterface{



    override fun addHorse(realm: Realm, horse: Horse): Boolean {

        return try {
            realm.beginTransaction()

            val currentIdNum: Number? = realm.where(Horse::class.java).max("id")

            val nextId: Int

            nextId = if (currentIdNum == null) {
                1
            } else {
                currentIdNum.toInt() + 1
            }

            horse.id = nextId

            realm.copyToRealmOrUpdate(horse)

            realm.commitTransaction()

            true
        } catch (e: Exception) {
            println(e)
            false
        }

    }

    override fun deleteHorse(realm: Realm, int: Int): Boolean {

        try {
            realm.beginTransaction()
            realm.where(Horse :: class.java).equalTo("id",int).findFirst()?.deleteFromRealm()
            realm.commitTransaction()
            return true
        } catch (e: Exception) {
            println(e)
            return false
        }
    }

    override fun updateHorse(realm: Realm, horse: Horse): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
