package com.example.myapplication.Model


import android.util.Log
import com.example.myapplication.Contract.MyInterface
import com.example.myapplication.Model.API.PostClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataModel(var userId: String, var id: String, var title: String, var body: String) : MyInterface.ModelInterface
{

    //Array List to be created as reference in this class to use it in all methods
    var arrayList: ArrayList<DataModel>? = null

    //reference of presenter in Data as to call the method in presenter
    var presenter: MyInterface.Presenter? = null

    //add value to retrofit
    override fun addValue()
    {
        //add the value of array list of data type of DataModel class and contain 3 paramters that are title , description , image
        //list.add(DataModel(id,userId,title,body))
    }
    //get the data from the retrofit
    override fun getValue()
    {
        PostClient.getPosts().enqueue(object : Callback<ArrayList<DataModel>> {
            override fun onResponse(
                call: Call<ArrayList<DataModel>>,
                response: Response<ArrayList<DataModel>>
            ) {
                arrayList = response.body()
                updateList()
            }

            override fun onFailure(call: Call<ArrayList<DataModel>>, t: Throwable) {
                Log.d("Error", "Not Connected")
            }
        })
    }
    //clear the list
    override fun removeData()
    {
        arrayList!!.clear()
        updateList()
    }

    //remove data at certain index
    override fun removeDataFromList(position: Int)
    {
        arrayList!!.removeAt(position)
        updateList()
    }

    //updating the Array List after each operation
    override fun updateList()
    {
        presenter?.getUpdatedData(arrayList!!)
    }

    //equalizing the reference of presenter passed from presenter class to the interface presenter created here
    fun initData(presenter: MyInterface.Presenter)
    {
        this.presenter = presenter
        getValue()
    }
}