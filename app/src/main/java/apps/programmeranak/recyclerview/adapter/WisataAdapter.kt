package apps.programmeranak.recyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.programmeranak.recyclerview.DetailActivity
import apps.programmeranak.recyclerview.R
import apps.programmeranak.recyclerview.model.Wisata
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataAdapter(val dataWisata : List<Wisata>?) : RecyclerView.Adapter<WisataAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambar = itemView.iv_gambar
        val namaLokasi = itemView.tv_namaLokasi
        val namaTempat = itemView.tv_namaTempat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wisata,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namaLokasi.text = dataWisata?.get(position)?.lokasi
        holder.namaTempat.text = dataWisata?.get(position)?.nama_tempat
        Glide.with(holder.itemView.context)
            .load(dataWisata?.get(position)?.gambar)
            .into(holder.gambar)

        holder.itemView.setOnClickListener {


        val intent = Intent(holder.itemView.context,DetailActivity::class.java)
        intent.putExtra("jdl",dataWisata?.get(position)?.nama_tempat)
        intent.putExtra("lks",dataWisata?.get(position)?.lokasi)
        intent.putExtra("desk",dataWisata?.get(position)?.deskripsi)
        intent.putExtra("gmb", dataWisata?.get(position)?.gambar)

        holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = dataWisata?.size ?: 0


}