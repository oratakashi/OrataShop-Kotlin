package abdul.hafiidh.oratashop.ui.Home

import abdul.hafiidh.oratashop.R
import abdul.hafiidh.oratashop.data.ModelProduct
import abdul.hafiidh.oratashop.ui.Detail.DetailActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterMain (val listProduct : ArrayList<ModelProduct>) : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val (nama, price, photo) = listProduct[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.ivPhoto)

        holder.tvName.text = nama
        holder.tvPrice.text = price.toString()

        holder.cvProduct.setOnClickListener {
            var intent : Intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", nama)
            intent.putExtra("price", price)
            intent.putExtra("photo", photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.product_name)
        var tvPrice : TextView = itemView.findViewById(R.id.product_price)
        var ivPhoto : ImageView = itemView.findViewById(R.id.product_photo)
        var cvProduct : CardView = itemView.findViewById(R.id.cvProduct)
    }
}