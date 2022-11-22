package com.eaglewarrior.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.eaglewarrior.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("John Wick", "Boogie Man")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.doneBtn.setOnClickListener{addNickname(it)}

        // Adds functionality to done_btn once clicked
//        findViewById<Button>(R.id.done_btn).setOnClickListener{
//            // Runs following code once button is clicked
//            addNickname(it)
//        }
    }

    // Adds name after Done Btn is clicked
    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = nicknameEt.text.toString()
            invalidateAll()
            binding.nicknameEt.visibility = View.GONE
            binding.doneBtn.visibility = View.GONE
            binding.nicknameTv.visibility = View.VISIBLE
        }
        // Hides the Keyboard
        val hideKeyboardAfterInput = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboardAfterInput.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
