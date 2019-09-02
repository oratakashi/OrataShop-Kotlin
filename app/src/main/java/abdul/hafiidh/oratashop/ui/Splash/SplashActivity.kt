package abdul.hafiidh.oratashop.ui.Splash

import abdul.hafiidh.oratashop.R
import abdul.hafiidh.oratashop.ui.Home.MainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlin.reflect.KClass

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        val intent = Intent(this, MainActivity::class.java)
        handler.postDelayed({
            startActivity(intent)
        }, 2000L)
    }


}
