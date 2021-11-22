package com.example.introductiontofragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

var frag11: Fragment? = null
var frag12: Fragment? = null
var myTransaction: FragmentTransaction? = null



class MainActivity : AppCompatActivity(), Fragment1.OnSelectListener {

    private val TAG_F11 = "Fragment11"
    private val TAG_F12 = "Fragment12"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            frag11 = Fragment11()
            frag12 = Fragment12()

            myTransaction = supportFragmentManager.beginTransaction()
            myTransaction!!.add(R.id.frag_container_2, frag11!!, this.TAG_F11)
            myTransaction!!.detach(frag11!!)
            myTransaction!!.add(R.id.frag_container_2, frag12!!, this.TAG_F12)
            myTransaction!!.detach(frag12!!)
            myTransaction!!.commit()
        } else {
            frag11 = supportFragmentManager.findFragmentByTag(this.TAG_F11)
            frag12 = supportFragmentManager.findFragmentByTag(this.TAG_F12)
        }

        val button1: Button = findViewById(R.id.main_button_1)
        button1.setOnClickListener { _ ->
            val myIntent = Intent(this, TabsActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onSelect(option: Int) {
        myTransaction = supportFragmentManager.beginTransaction()
        when(option) {
            1 -> {
                myTransaction?.detach(frag12!!)
                myTransaction?.attach(frag11!!)
            }
            2 -> {
                myTransaction?.detach(frag11!!)
                myTransaction?.attach(frag12!!)
            }
        }
        myTransaction?.commit()
    }
}