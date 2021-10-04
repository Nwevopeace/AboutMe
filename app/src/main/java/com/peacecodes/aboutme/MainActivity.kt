package com.peacecodes.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val TAG = "MainActivity"
const val SHOW_NICKNAME = "show_nickname"
const val ADD_NICKNAME = "add_nickname"

class MainActivity : AppCompatActivity() {

    private var showNickname = ""
    private var addNickname = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // you can set the onClick listener in another way
        findViewById<TextView>(R.id.showNickname).setOnClickListener {
            updateNickname(it)
        }

        val button = findViewById<Button>(R.id.doneButton)
        button.setOnClickListener {
            addNickname(it)
        }
    }

    fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editNickname)
        val textView = findViewById<TextView>(R.id.showNickname)
        // connecting the edit text to the textView to show what the user types in.
        textView.text = editText.text

        // Hide the editText view when the button is clicked
        editText.visibility = View.GONE

        //Hide the button
        view.visibility = View.GONE

        // make the textView visible
        textView.visibility = View.VISIBLE

        // Hiding the Keyboard after the user finishes typing
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editNickname)
        val button = findViewById<Button>(R.id.doneButton)

        // show the editText
        editText.visibility = View.VISIBLE

        // show the button
        view.visibility = View.GONE

        //hide the textView
        button.visibility = View.VISIBLE

        // set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called")
        outState.putString(SHOW_NICKNAME, showNickname)
        outState.putString(ADD_NICKNAME, addNickname)
    }

}
