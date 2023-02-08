package pl.altkom.destinator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val destinationAdapter = DestinationAdapter()
        binding.recyclerView.adapter = destinationAdapter
        Log.d("THREADING", Thread.currentThread().name)
        val runnable = Runnable {
            repeat(10) {
                Log.d("THREADING", "Thread: ${Thread.currentThread().name}")
                runOnUiThread {
                    Log.d("THREADING", "runOnUiThread: ${Thread.currentThread().name}")
                    destinationAdapter.setData(DestinationsStaticDataSource.destinations.shuffled())
                }
                Thread.sleep(1000L)
            }
        }
        val task = Thread(runnable)
        task.start()
    }
}