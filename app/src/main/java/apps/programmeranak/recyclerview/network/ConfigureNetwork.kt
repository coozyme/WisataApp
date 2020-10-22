package apps.programmeranak.recyclerview.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConfigureNetwork {

         val retrofit = Retrofit.Builder()
            .baseUrl("http://udacoding.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WisataService::class.java)



}