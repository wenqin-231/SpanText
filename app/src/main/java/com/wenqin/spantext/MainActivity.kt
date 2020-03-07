package com.wenqin.spantext

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.wenqin.lib.setSpanText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvContent.setSpanText {
            append("张三") {
                textSize = 16
                textColor = ContextCompat.getColor(this@MainActivity, R.color.colorPrimary)
                bold = true
            }
            append("\n")
            append("最爱在星空下做") {
                textSize = 12
                textColor = Color.GRAY
            }
            append("黄粱美梦") {
                textSize = 12
                textColor = Color.GRAY
                underline = true
                clickListener = {
                    Toast.makeText(this@MainActivity, "暴富啦！", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
