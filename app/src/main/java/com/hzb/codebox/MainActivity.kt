package com.hzb.codebox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra("title","我的")
            startActivity(intent)
        }
        view.setOnClickListener {  }
    }


}
