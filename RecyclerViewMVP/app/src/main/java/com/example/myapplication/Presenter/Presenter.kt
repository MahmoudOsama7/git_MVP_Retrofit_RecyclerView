package com.example.myapplication.Presenter

import android.util.Log
import com.example.myapplication.Contract.MyInterface
import com.example.myapplication.Model.DataModel

class Presenter(_view:MyInterface.DataView):MyInterface.Presenter {
    //passing the interface from the ui to be used by the presenter as to state the ui interface
    private var view:MyInterface.DataView=_view
    //the list of that the user will update it here in the presenter that to be passed to the model to be added
    private var model:DataModel=DataModel("userId","id", "title","body")
    //Array List to be created as reference in this class to use it in all methods
    private var array:ArrayList<DataModel> ?=null


    init
    {
        //init view object
        view.initView()
        //referencing the object of presenter to be passed and acknowledged in data class to use it there
        model.initData(this)
    }

    //add new Data
    override fun addNewValue()
    {
        model.addValue()
    }
    //remove all Data
    override fun removeData()
    {
        model.removeData()
    }
    //remove one item
    override fun removeOneData(position: Int)
    {
        model.removeDataFromList(position)
    }
    //get Data after any update
    override fun getUpdatedData(value:ArrayList<DataModel>)
    {
        array=value
        view.getDataFromPresenter(array!!)
    }

}