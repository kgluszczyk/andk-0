package pl.altkom.destinator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import pl.altkom.destinator.data.DestinationsStaticDataSource
import pl.altkom.destinator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Data binding
        binding.listContent = DestinationsStaticDataSource.destinations
            .filter { it.id > 0 }
            .map {
                it.description
            }.joinToString { it }

        //View binding
        binding.labelka.setOnClickListener {
            Toast.makeText(it.context, "${binding.labelka.text.length}", Toast.LENGTH_LONG).show()
        }

        //Recycler View
        binding.recyclerView.adapter = DestinationAdapter(DestinationsStaticDataSource.destinations)
    }
}