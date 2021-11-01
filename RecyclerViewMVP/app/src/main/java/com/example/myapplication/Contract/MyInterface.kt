package com.example.myapplication.Contract

import com.example.myapplication.Model.DataModel

interface MyInterface {
    //interface of the View
    interface DataView{
        fun initView()
        fun getDataFromPresenter(value:ArrayList<DataModel>) //presenter will use it to take the array value from the view
    }
    //interface for the presenter
    interface Presenter{
        fun addNewValue()
        fun removeData()
        fun removeOneData(position: Int)
        fun getUpdatedData(value:ArrayList<DataModel>)
    }
    //interface for the model
    interface ModelInterface{
        fun addValue() //presenter will use it to add a new value to the array list then to the recyclerView
        fun getValue()//presenter will use it to return the value of list in the class DataModel after adding new data
        fun removeData()
        fun removeDataFromList(position: Int)
        fun updateList()
    }
    interface SelectListen
    {
        fun getArrayPosition(position:Int)
    }
}