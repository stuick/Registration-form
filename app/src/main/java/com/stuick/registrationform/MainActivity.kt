package com.stuick.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.button_preview
import kotlinx.android.synthetic.main.activity_main.spinner_Job_title
import kotlinx.android.synthetic.main.activity_main.text_input_email
import kotlinx.android.synthetic.main.activity_main.text_input_first_name
import kotlinx.android.synthetic.main.activity_main.text_input_last_name
import kotlinx.android.synthetic.main.activity_main.text_input_password
import kotlinx.android.synthetic.main.activity_main.text_input_phone_number
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerSetup()
        button_preview.setOnClickListener {
            onClickPreview()
        }

    }

    private fun spinnerSetup() {
        val spinnerValues: Array<String> = arrayOf(
            "Android Developer",
            "Android Engineer",
            "Java Developer"
        )
        val spinnerAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, spinnerValues
        )
        spinner_Job_title.adapter = spinnerAdapter
    }

    private fun onClickPreview() {
        val dataRegistration = DataRegistration(
            text_input_first_name.text.toString(),
            text_input_last_name.text.toString(),
            text_input_email.text.toString(),
            text_input_password.text.toString(),
            text_input_phone_number.text.toString(),
            spinner_Job_title.selectedItem.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("DataRegistration", dataRegistration)
        startActivity(previewActivityIntent)
    }

}