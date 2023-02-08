package pl.altkom.destinator.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.altkom.destinator.R
import pl.altkom.destinator.domain.entity.Destination

class DestinationAdapter(private var destinations: List<Destination> = emptyList()) :
    RecyclerView.Adapter<DestinationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return DestinationViewHolder(view)
    }

    override fun getItemCount() = destinations.size

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        holder.bind(destinations[position])
    }

    fun setData(newList: List<Destination>){
        destinations = newList
        notifyDataSetChanged()
    }

}

class DestinationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(destination: Destination) {
        with(destination) {
            itemView.findViewById<TextView>(R.id.id).text = id.toString()
            itemView.findViewById<TextView>(R.id.name).text = name
            itemView.findViewById<TextView>(R.id.description).text = description
        }
    }
}