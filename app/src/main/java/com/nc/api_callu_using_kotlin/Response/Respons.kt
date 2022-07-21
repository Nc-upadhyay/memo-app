package com.nc.api_callu_using_kotlin.Response

import com.google.gson.annotations.SerializedName
import com.nc.api_callu_using_kotlin.Model.Pojo

class Respons(

    @SerializedName("postLink")   var postLink: String,
    @SerializedName("subreddit")   var subreddit: String,
    @SerializedName("title")  var  title: String,
    @SerializedName("url")  var  url: String,
    @SerializedName("nsfw")   var nsfw: Boolean,
    @SerializedName("spoiler")   var spoiler: Boolean,
    @SerializedName("author")   var author: String,
    @SerializedName("ups")  var ups: Int,
    @SerializedName("preview"   ) var data:ArrayList<String>

    )
{
}