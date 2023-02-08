package pl.altkom.destinator.presentation.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import pl.altkom.destinator.data.datasource.DestinationsStaticDataSourceImpl
import pl.altkom.destinator.data.repository.DestinationsRepositoryImpl
import pl.altkom.destinator.databinding.ActivityMainBinding
import pl.altkom.destinator.domain.usecase.GetValidDestinations
import pl.altkom.destinator.presentation.DestinationAdapter
import pl.altkom.destinator.presentation.viewmodel.DestinationsViewModel
import pl.altkom.destinator.presentation.viewmodel.ScreenState

class MainActivity : AppCompatActivity() {

    private val viewModel: DestinationsViewModel =
        DestinationsViewModel(
            GetValidDestinations(
                DestinationsRepositoryImpl(
                    DestinationsStaticDataSourceImpl()
                )
            )
        )
    private val destinationsAdapter = DestinationAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View binding
        binding.labelka.setOnClickListener {
            Toast.makeText(it.context, "${binding.labelka.text.length}", Toast.LENGTH_LONG).show()
        }

        //Recycler View
        binding.recyclerView.adapter = destinationsAdapter

        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.screenState.collect { screenState ->
                    when (screenState) {
                        is ScreenState.Content -> {
                            destinationsAdapter.submitList(screenState.destinations)
                            binding.listContent = screenState.overview
                        }
                        is ScreenState.Error -> Toast.makeText(
                            this@MainActivity,
                            "Error!",
                            Toast.LENGTH_LONG
                        ).show()
                        ScreenState.Loading -> Toast.makeText(
                            this@MainActivity,
                            "Loading",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}