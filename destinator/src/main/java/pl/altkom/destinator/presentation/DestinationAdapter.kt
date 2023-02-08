package pl.altkom.destinator.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pl.altkom.destinator.R
import pl.altkom.destinator.domain.entity.Destination

class DestinationAdapter :
    androidx.recyclerview.widget.ListAdapter<Destination, DestinationViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        holder.bind(currentList[position])
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

val diffCallback = object : DiffUtil.ItemCallback<Destination>(){
    override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean {
        return oldItem == newItem
    }

}