package com.example.project1.retrofit

import com.example.project1.modelclass.Quote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://gorest.co.in/public/v2/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()




interface QuoteApiService{

        @GET("posts")
        suspend fun getQuotes() : List<Quote>
    }

    object QuoteApi{
        val retrofitService: QuoteApiService by lazy { retrofit.create(QuoteApiService::class.java) }

    }

