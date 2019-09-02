package abdul.hafiidh.oratashop.ui.Home

import abdul.hafiidh.oratashop.R
import abdul.hafiidh.oratashop.data.ModelProduct
import abdul.hafiidh.oratashop.data.SourceData
import abdul.hafiidh.oratashop.ui.About.AboutActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    private var list: ArrayList<ModelProduct> = arrayListOf()
    lateinit var rvProduct : RecyclerView
    lateinit var svProduct : NestedScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "OrataShop"
        supportActionBar?.elevation = 0F

        svProduct = findViewById(R.id.scrollview)
        svProduct.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if(scrollY > 0){
                supportActionBar?.elevation = 3F
            }else{
                supportActionBar?.elevation = 0F
            }
        }

        rvProduct = findViewById(R.id.rvProduct)
        rvProduct.setHasFixedSize(true)

        list.addAll(SourceData.listData)

        rvProduct.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterMain(list)
        rvProduct.adapter = adapter
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
