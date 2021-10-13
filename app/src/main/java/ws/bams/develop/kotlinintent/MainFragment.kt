package ws.bams.develop.kotlinintent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var btnCallActivity: Button? = null
    var btnCallFragment: Button? = null
    var edtName: EditText? = null
    var layout_main:LinearLayout?= null

    val TAG:String = "MainFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)

        val view:View = inflater.inflate(R.layout.fragment_main, container, false)

        setView(view)
        return view
    }

    private fun setView(view: View){

        layout_main = view.findViewById(R.id.layout_main)

        //fincViewByID
        btnCallActivity = view.findViewById(R.id.btnCallActivity)
        btnCallFragment = view.findViewById(R.id.btnCallFragment)
        edtName = view.findViewById(R.id.edtName);


        btnCallActivity!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "ClickbtnCallActivity", Toast.LENGTH_SHORT).show()

            //callFunction
            openActivity()
        })


        btnCallFragment!!.setOnClickListener(View.OnClickListener {

            Toast.makeText(context, "ClickbtnCallFragment", Toast.LENGTH_SHORT).show()

            //callFunction
            openFragment()


        })
    }

    fun openActivity(){

        //userIntent
        val intent = Intent(context, ShowActivity::class.java)

        Log.d("TAG", "openActivity: ${edtName!!.text.toString()}")

        //sendValue via intent
        intent.putExtra("name_send", edtName!!.text.toString())
        startActivity(intent!!)

    }

    fun openFragment(){

        val mFragmentManager = getFragmentManager() //supportFragmentManager
        val mFragmentTransaction = mFragmentManager?.beginTransaction()
        val mFragment = ShowFragment()

        //Send Value
        val mBundle = Bundle()
        mBundle.putString("name_fr", edtName!!.text.toString())
        mFragment.arguments = mBundle
        mFragmentTransaction?.addToBackStack(null)
        //mFragmentTransaction?.add(R.id.main_content, mFragment)?.commit() //overlap
        mFragmentTransaction?.replace(R.id.main_content, mFragment)?.commit() //not overlap


        //layout not Overlap
        /*val mFragment2 = ShowFragment()

        val mBundle = Bundle()
        mBundle.putString("name_fr", edtName!!.text.toString())
        mFragment2.arguments = mBundle

        getFragmentManager()
            ?.beginTransaction()
            ?.addToBackStack(null)
            //?.add(R.id.main_content, /*ShowFragment()*/ mFragment2) //add = Overlap
            ?.replace(R.id.main_content, /*ShowFragment()*/ mFragment2)
            ?.commit()*/
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onResume() {
        super.onResume()
    }
}