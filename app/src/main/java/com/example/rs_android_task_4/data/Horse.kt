package com.example.rs_android_task_4.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Horse(

    @PrimaryKey
    var id:Int?=null,
    var name: String?= null,
    var age: String?= null,
    var breed: String?= null
) : RealmObject()