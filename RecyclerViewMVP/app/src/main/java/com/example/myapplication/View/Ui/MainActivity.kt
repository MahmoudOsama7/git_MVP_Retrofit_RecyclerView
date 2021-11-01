package com.example.myapplication.View.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.View.Adapter.MyAdapter
import com.example.myapplication.Contract.MyInterface
import com.example.myapplication.Model.DataModel
import com.example.myapplication.Presenter.Presenter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MyInterface.DataView,MyInterface.SelectListen{


    private var presenter:Presenter?=null
    private var myAdapter:MyAdapter?=null
    private var neededItem=0
    private var arrayList:ArrayList<DataModel>?=null



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= Presenter(this)

    }
    override fun initView()
    {
        rv.layoutManager = LinearLayoutManager(this)
        clear.setOnClickListener { presenter?.removeData() }
        remove.setOnClickListener{ presenter?.removeOneData(neededItem) }
    }

    override fun getDataFromPresenter(value: ArrayList<DataModel>)
    {
        arrayList=value
        myAdapter= MyAdapter(arrayList!!,this)
        rv.adapter=myAdapter

    }

    override fun getArrayPosition(position:Int)
    {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show()
        neededItem=position
    }
}