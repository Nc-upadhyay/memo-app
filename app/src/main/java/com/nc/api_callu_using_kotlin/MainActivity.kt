package com.nc.api_callu_using_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import com.nc.api_callu_using_kotlin.API.API_Interface
import com.nc.api_callu_using_kotlin.Model.Pojo
import com.nc.api_callu_using_kotlin.Response.Respons
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.zip.CheckedOutputStream

class MainActivity : AppCompatActivity() {
     var count:Int=-1;
    lateinit var retrofit: Retrofit
    lateinit var list: MutableList<String>
    lateinit var image:ImageView
    lateinit var prev:Button
    lateinit var next:Button
    var url = "https://meme-api.herokuapp.com/";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList<String>()
        image=findViewById(R.id.imageView2)
        prev=findViewById(R.id.button4)
        next=findViewById(R.id.button)


        next.setOnClickListener {
            getUrl();
//            count++;
//            if(count==4)
//                count=0;
//            if(count>= 0 && count<4)
//            {
//                var url=list[count];
//                showImage(url)
//            }


        }
        prev.setOnClickListener {
            getUrl();
//            count--;
//            if(count==-1)
//                count=3;
//            if(count>= 0 && count<4) {
//                var url=list[count];
//


        }
    }
    fun showImage(url :String)
    {
            Glide.with(this).load(url).into(image)
    }
    fun getUrl()
    {
        var gson = GsonBuilder().create();
        var okhttp = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        retrofit.create(API_Interface::class.java).getData().enqueue(object : Callback<Respons> {

            override fun onResponse(call: Call<Respons>, response: Response<Respons>) {
                Log.d("nc", "error is============================= data is commint")
                println(response.code())
                if (response.code() == 200)  //code 200=>ok
                {
                    list = response.body()!!.data
                    showImage(list[1])
                } else {
                    Log.d("nc", "body is empty")
                }
            }

            override fun onFailure(call: Call<Respons>, t: Throwable) {
                Log.d("nc", "error is============================= ${t.localizedMessage}")
            }
        })
    }

}