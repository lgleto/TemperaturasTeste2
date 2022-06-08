package ipca.example.temperaturas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TemperatureDetailActivity : AppCompatActivity() {

    var temperature : Temperature? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val uid = intent.getStringExtra(TEMPERATURE_ID)

        val editTextDetailName = findViewById<TextView>(R.id.editTextDetailLocal)
        val editTextDetailContact = findViewById<TextView>(R.id.editTextTemperature)
        val fabSave = findViewById<FloatingActionButton>(R.id.fabSave)
        val fabDelete = findViewById<FloatingActionButton>(R.id.fabDelete)

        editTextDetailName.text = uid

        fabSave.setOnClickListener {

        }

        fabDelete.setOnClickListener {

        }

    }

    companion object{
        const val TEMPERATURE_ID = "temperature_id"
    }
}