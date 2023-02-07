package pl.altkom.destinator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import pl.altkom.destinator.data.StaticDataSource
import pl.altkom.destinator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = binding.labelka
        //View binding
      //  binding.content.text = "3"

        //Data binding
        binding.listContent = StaticDataSource.destinations.toString()
        Toast.makeText(this, title.text, Toast.LENGTH_LONG).show()
        title.setOnClickListener {
            Toast.makeText(it.context, "${title.text.length}", Toast.LENGTH_LONG).show()
        }
    }
}