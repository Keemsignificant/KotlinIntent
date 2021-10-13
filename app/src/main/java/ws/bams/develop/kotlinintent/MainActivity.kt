package ws.bams.develop.kotlinintent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {


    private val TAG:String = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragmentFirst()


    }


    fun openFragmentFirst(){

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = MainFragment()


        //Send Value
        val mBundle = Bundle()
        //mBundle.putString("name_fr",edtName!!.text.toString())
        mFragment.arguments = mBundle
        //mFragmentTransaction.addToBackStack(null) //whenClickBack
        //mFragmentTransaction.add(R.id.main_content, mFragment).commit() //overlap
        mFragmentTransaction.replace(R.id.main_content, mFragment).commit() //replace
    }


    override fun onResume() {
        super.onResume()
    }
}