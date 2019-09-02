package abdul.hafiidh.oratashop.ui.About

import abdul.hafiidh.oratashop.R
import abdul.hafiidh.oratashop.data.ModelProduct
import abdul.hafiidh.oratashop.data.SourceData
import abdul.hafiidh.oratashop.ui.Home.AdapterMain
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    private var list: ArrayList<ModelProduct> = arrayListOf()
    lateinit var rvProduct : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dicoding.com/users/29295"))
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }

        rvProduct = findViewById(R.id.rvProduct)
        rvProduct.setHasFixedSize(true)

        list.addAll(SourceData.listData)

        rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = AdapterMain(list)
        rvProduct.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflate = menuInflater
        menuInflate.inflate(R.menu.menu_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.getItemId()){
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "Feature is locked", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
