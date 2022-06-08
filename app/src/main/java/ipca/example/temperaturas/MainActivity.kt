package ipca.example.temperaturas

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ipca.example.temperaturas.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    var temperatures : MutableList<Temperature> = arrayListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, TemperatureDetailActivity::class.java)
            startActivity(intent)
        }

        val temperaturesAdapter = TemperaturesAdapter()
        binding.listViewTemperatures.adapter = temperaturesAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    inner class TemperaturesAdapter : BaseAdapter(){
        override fun getCount(): Int {
            return temperatures.size
        }

        override fun getItem(position: Int): Any {
            return temperatures[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.row_temperature,viewGroup,false)

            val textViewLocal = rootView.findViewById<TextView>(R.id.textViewLocal)
            val textViewDate = rootView.findViewById<TextView>(R.id.textViewDate)
            val textViewTemperature = rootView.findViewById<TextView>(R.id.textViewTemperature)

            textViewLocal.text = temperatures[position].local
            textViewDate.text = Date(temperatures[position].date?:0L).toString()
            textViewTemperature.text = temperatures[position].temperature.toString()

            rootView.setOnClickListener {
                val intent = Intent(this@MainActivity, TemperatureDetailActivity::class.java)
                intent.putExtra(TemperatureDetailActivity.TEMPERATURE_ID, temperatures[position].uid)
                startActivity(intent)
            }

            return rootView
        }
    }

}