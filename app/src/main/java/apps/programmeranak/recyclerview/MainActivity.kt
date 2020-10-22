package apps.programmeranak.recyclerview

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import apps.programmeranak.recyclerview.adapter.WisataAdapter
import apps.programmeranak.recyclerview.model.ResponseServer
import apps.programmeranak.recyclerview.network.ConfigureNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var adapter : WisataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isConnect()){

        ConfigureNetwork.service.getWisata().enqueue(object : Callback<ResponseServer> {
            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    progress.visibility = View.GONE
                    val data = responseBody?.data
                    Log.d("RESPONSE", "onResponse: $data")
                    adapter = WisataAdapter(data)
                    showRecyclerView()
                }

            }

            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                progress.visibility = View.GONE
            }

        })
        } else {
            Toast.makeText(this ,"Device tidak connect internet",Toast.LENGTH_SHORT).show()
        }


    }

    fun isConnect() : Boolean{
        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    private fun showRecyclerView() {

        rv_tampilData.adapter = adapter
        rv_tampilData.layoutManager = LinearLayoutManager(this)
    }
}