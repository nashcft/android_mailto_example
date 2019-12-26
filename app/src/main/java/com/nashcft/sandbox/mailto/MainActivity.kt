package com.nashcft.sandbox.mailto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nashcft.sandbox.mailto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  private val address = "example@example.com"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.apply {
      button1.setOnClickListener {
        startActivity(
          createSendToIntent(
            Uri.parse("mailto:$address"),
            address,
            "Subject",
            "text text text"
          )
        )
      }

      button2.setOnClickListener {
        startActivity(
          createSendToIntent(
            Uri.parse("mailto:"),
            address,
            "Subject",
            "text text"
          )
        )
      }

      button3.setOnClickListener {
        startActivity(
          createSendToIntent(
            Uri.parse("mailto:$address"),
            "",
            "Subject",
            "text text"
          )
        )
      }
    }
  }

  private fun createSendToIntent(
    uri: Uri,
    to: String,
    subject: String,
    text: String
  ): Intent {
    val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
      putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
      putExtra(Intent.EXTRA_SUBJECT, subject)
      putExtra(Intent.EXTRA_TEXT, text)
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    return Intent.createChooser(intent, "Select an application")
  }
}
