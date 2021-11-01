package com.example.myapplication.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Contract.MyInterface
import com.example.myapplication.Model.DataModel
import com.example.myapplication.R
import kotlinx.android.synthetic.main.single_layout.view.*

class MyAdapter(private var value: ArrayList<DataModel>, private var selectListen1: MyInterface.SelectListen):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var selectListen:MyInterface.SelectListen?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.single_layout,parent,false)
        return MyViewHolder(v)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        //got the array from the client class
        //will pass the holder and position and initialize it in another method
        initialization(holder,position)

        //to get the item selected when the client class select any item in the recyclerView
        selectItem(holder,position)


    }

    override fun getItemCount(): Int
    {
        return value.size
    }

    //viewHolder innerClass
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        /*
        or
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var userId=itemView.userId as TextView
        var title =itemView.title as TextView
        var postId=itemView.postId as TextView
    }
        */
        var userId:TextView = itemView.userId as TextView
        var body:TextView = itemView.title as TextView
        var postId:TextView = itemView.postId as TextView

    }

    //function to initialize holder views based on data in the array passed from client code
    private fun initialization(holder:MyViewHolder,position: Int)
    {
        holder.userId.text= value[position].userId
        holder.body.text= value[position].body
        holder.postId.text= value[position].id
        /*
        or
        holder.userId.text=value.get(position).userId
        holder.title.text=value.get(position).title
        holder.postId.text=value.get(position).id
        */
    }
    //method to select the item when clicking on button by client code
    private fun selectItem(holder:MyViewHolder,position: Int)
    {
        //assigning the data in the data class that got from certain position of array list value that is inflated in the recyclerview
        //holder has 3 parameters title , description , image  equalize them with their views in the layout that is got by using itemView
        selectListen=selectListen1
        holder.itemView.setOnClickListener {
            //Toast.makeText(holder.itemView.context, ""+position, Toast.LENGTH_SHORT).show()
            selectListen?.getArrayPosition(position) }
    }
}

