package ws.bams.develop.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowActivity : AppCompatActivity() {


    //create variable
    var tvName:TextView? = null

    var name:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        //Receive Value
        name = intent.getStringExtra("name_send").toString()

        //findViewByID
        tvName = findViewById(R.id.tvName)
        tvName!!.text = name //setText

    }
}