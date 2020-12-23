package com.example.rs_android_task_4.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rs_android_task_4.R
import com.example.rs_android_task_4.data.Horse

import io.realm.RealmResults
import kotlinx.android.synthetic.main.recycler_item.view.*
/*
class HorseAdapter(val context: Context, val list: MutableList<Horse>): RecyclerView.Adapter<HorseViewHolder>() {

    private val items= mutableListOf<Horse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorseViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,null)
        return HorseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HorseViewHolder, position: Int) {

        val horseName=items[position].name ?: ""
        val horseAge=items[position].age ?: "0"
        val horseBreed=items[position].breed ?: ""
        holder.bind(horseName,horseAge,horseBreed)

    }

    fun addItems(newItems:List<Horse>){
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}

class HorseViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val textViewName=view.findViewById<TextView>(R.id.label_name)
    private val textViewAge=view.findViewById<TextView>(R.id.label_age)
    private val textViewBreed=view.findViewById<TextView>(R.id.label_breed)

    fun bind(horseName:String,horseAge:String,horseBreed:String) {
        textViewName.text = horseName
        textViewAge.text = horseAge
        textViewBreed.text = horseBreed


    }
}*/

class HorseAdapter(val context: Context?, private val list: RealmResults<Horse>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        holder.itemView.label_name.text = list[position]!!.name
        holder.itemView.label_age.text = list[position]!!.age
        holder.itemView.label_breed.text = list[position]!!.breed




    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return HorseViewHolder(v)


    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class HorseViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val textViewName=view.findViewById<TextView>(R.id.label_name)
    private val textViewAge=view.findViewById<TextView>(R.id.label_age)
    private val textViewBreed=view.findViewById<TextView>(R.id.label_breed)

    fun bind(horseName:String,horseAge:String,horseBreed:String) {
        textViewName.text = horseName
        textViewAge.text = horseAge
        textViewBreed.text = horseBreed


    }
}