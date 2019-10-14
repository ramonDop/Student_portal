package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a Portal"

        btnAddPortal.setOnClickListener{ view ->
            onSaveClick()
        }
    }

    private fun onSaveClick() {
        val portalTitle = etTitle.text.toString()
        val portalUrl = etUrl.text.toString()

        if (portalTitle.isNotBlank() && portalUrl.isNotBlank()) {
            val portal = Portal(portalTitle, portalUrl)
            etTitle.text?.clear()
            etUrl.text?.clear()
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Snackbar.make(btnAddPortal, "You must fill in all the input fields!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }




}
