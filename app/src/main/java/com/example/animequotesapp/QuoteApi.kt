package com.example.animequotesapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path  //Nice Work :)
import retrofit2.http.Query

interface QuoteApi {
    @GET("random")
    suspend fun getRandomQuote(): Response<QuoteResponse>

    @GET("random/anime")//fev minutes | ok bro
    suspend fun getQuoteByTitle(@Query("title") title:String): Response<QuoteResponse>





}