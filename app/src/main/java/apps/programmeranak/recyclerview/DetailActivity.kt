package apps.programmeranak.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val namaTempat = intent.getStringExtra("jdl")
        val namaLokasi = intent.getStringExtra("lks")
        val gambar = intent.getStringExtra("gmb")
        val desk = intent.getStringExtra("desk")

        tv_Judul.text = namaTempat
        tv_Lokasi.text = namaLokasi
        tv_deskrip.text = desk

        Glide.with(this).load(gambar).into(iv_Picture)



    }
}