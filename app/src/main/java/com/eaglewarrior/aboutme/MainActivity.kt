package com.eaglewarrior.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Adds name after Done Btn is clicked
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_et)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_tv)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val hideKeyboardAfterInput = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboardAfterInput.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
