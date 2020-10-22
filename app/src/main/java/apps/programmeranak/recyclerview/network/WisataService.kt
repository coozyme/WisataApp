package apps.programmeranak.recyclerview.network

import apps.programmeranak.recyclerview.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface WisataService {
    @GET("api/?action=findAll")
    fun getWisata() : Call<ResponseServer>

    @GET("sdafsfda")
    fun deleteWisata(): Call<ResponseServer>

}