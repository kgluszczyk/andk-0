package pl.altkom.destinator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.altkom.destinator.data.DestinationsStaticDataSource
import pl.altkom.destinator.databinding.ActivityMainBinding
import kotlin.concurrent.thread

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
        lifecycleScope.launch(Dispatchers.Default) {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                repeat(10) {
                    Log.d("THREADING", "Thread: ${Thread.currentThread().name}")
                    withContext(Dispatchers.Main) {
                        Log.d("THREADING", "runOnUiThread: ${Thread.currentThread().name}")
                        destinationAdapter.setData(DestinationsStaticDataSource.destinations.shuffled())
                    }
                    delay(1000)
                }
            }
        }
    }
}