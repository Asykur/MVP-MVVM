package id.sekolahandroid.recyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.sekolahandroid.recyclerview.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnMVP.setOnClickListener {
            startActivity(Intent(this,MvpActivity::class.java))
        }

        btnNoPattern.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnMVVM.setOnClickListener {
            startActivity(Intent(this,MvvmActivity::class.java))
        }
    }
}
