package abdul.hafiidh.oratashop.ui.Detail

import abdul.hafiidh.oratashop.R
import abdul.hafiidh.oratashop.ui.About.AboutActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    lateinit var photo: ImageView
    lateinit var name: TextView
    lateinit var price: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        photo = findViewById(R.id.product_photo)
        name = findViewById(R.id.product_name)
        price = findViewById(R.id.product_price)
        button = findViewById(R.id.btnBuy)

        name.text = intent.getStringExtra("name")
        price.text = intent.getIntExtra("price", 0).toString()

        Glide.with(this)
            .load(intent.getIntExtra("photo", 0))
            .into(photo)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Berhasil Menyukai Produk", Snackbar.LENGTH_LONG).show()
        }

        button.setOnClickListener{ view ->
            Snackbar.make(view, "Berhasil memasukan "+intent.getStringExtra("name")+" ke Keranjang", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflate = menuInflater
        menuInflate.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        intent = Intent(applicationContext, AboutActivity::class.java)
        when(item.getItemId()){
            R.id.action_about -> {
                startActivity(intent)
            }
            R.id.action_cart -> {
                Toast.makeText(applicationContext, "Feature is locked", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
