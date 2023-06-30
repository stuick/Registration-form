package com.stuick.registrationform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.text_view_email
import kotlinx.android.synthetic.main.activity_preview.text_view_phone
import kotlinx.android.synthetic.main.activity_preview.text_view_preview_message

class PreviewActivity : AppCompatActivity() {
    private lateinit var information: DataRegistration
    private lateinit var dataPreview: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayPreview()


    }

    private fun displayPreview() {
        information = intent.getSerializableExtra("DataRegistration") as DataRegistration
        dataPreview = """
                First Name: ${information.firstName}
                
                Last Name: ${information.lastName}
                
                Job Title: ${information.jobTitle}
                
            """.trimIndent()

        text_view_preview_message.text = dataPreview
        text_view_phone.text = information.phoneNumber
        text_view_email.text = information.email

        text_view_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: ${information.email}")
            startActivity(intent)
        }
        text_view_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${information.phoneNumber}")
            }
            startActivity(intent)
        }
    }
}