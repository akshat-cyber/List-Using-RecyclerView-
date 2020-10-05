package rcylV.fatdevs.recyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class adapter(private val dataList : List<itemDataClass>) : RecyclerView.Adapter<adapter.viewHold>(){
    class viewHold(cardView: View): RecyclerView.ViewHolder(cardView), View.OnClickListener {
        val imageV : ImageView = cardView.image
        val textV : TextView = cardView.main_text
        val subTextV : TextView = cardView.sub_text
        init {
            imageV.setOnClickListener(this)
            
        }
        override fun onClick(v: View?) {
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHold {
       val cardView : View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
       return viewHold(cardView)
    }

    override fun onBindViewHolder(holder: viewHold, currentPosition: Int) {
        var value = dataList[currentPosition]
        holder.imageV.setImageResource(value.resourceImage)
        holder.textV.text = value.text
        holder.subTextV.text = value.subText
    }

    override fun getItemCount(): Int {
      return dataList.size
    }
}