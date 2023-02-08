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
import pl.altkom.destinator.domain.usecase.GetValidDestinations

class MainActivity : AppCompatActivity() {

    private val viewModel: DestinationsViewModel = DestinationsViewModel(GetValidDestinations())
    private val destinationsAdapter = DestinationAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Data binding
        binding.listContent = viewModel.getDestinationsOverview()

        //View binding
        binding.labelka.setOnClickListener {
            Toast.makeText(it.context, "${binding.labelka.text.length}", Toast.LENGTH_LONG).show()
        }

        //Recycler View
        binding.recyclerView.adapter = destinationsAdapter
        destinationsAdapter.submitList(viewModel.getDestinations())
    }
}