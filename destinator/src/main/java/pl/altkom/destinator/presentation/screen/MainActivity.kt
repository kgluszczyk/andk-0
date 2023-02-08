package pl.altkom.destinator.presentation.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pl.altkom.destinator.data.DestinationsStaticDataSource
import pl.altkom.destinator.data.datasource.DestinationsStaticDataSourceImpl
import pl.altkom.destinator.data.repository.DestinationsRepositoryImpl
import pl.altkom.destinator.databinding.ActivityMainBinding
import pl.altkom.destinator.domain.DestinationsRepository
import pl.altkom.destinator.domain.usecase.GetValidDestinations
import pl.altkom.destinator.presentation.DestinationAdapter
import pl.altkom.destinator.presentation.viewmodel.DestinationsViewModel

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