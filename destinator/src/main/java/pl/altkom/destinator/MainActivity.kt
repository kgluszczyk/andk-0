package pl.altkom.destinator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.labelka)
        if(title is TextView){
            Toast.makeText(this, (title as TextView).text, Toast.LENGTH_LONG).show()
        }
        title.setOnClickListener {
            // TODO: Investingation needed!
            Toast.makeText(it.context, (it as TextView).text.length, Toast.LENGTH_LONG).show()
        }
    }
}