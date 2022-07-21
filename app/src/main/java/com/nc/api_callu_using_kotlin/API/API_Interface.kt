package com.nc.api_callu_using_kotlin.API

import com.nc.api_callu_using_kotlin.Response.Respons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface API_Interface {

    @GET("gimme")
    fun getData(): Call<Respons>
}