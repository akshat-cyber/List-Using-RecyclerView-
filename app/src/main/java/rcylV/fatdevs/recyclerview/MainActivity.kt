package rcylV.fatdevs.recyclerview
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var itemList : ArrayList<itemDataClass> = generateList(522)
    private var adapter = adapter(itemList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rcy : RecyclerView = findViewById(R.id.recycler)
        rcy.adapter = adapter
        rcy.layoutManager = LinearLayoutManager(this)
        rcy.setHasFixedSize(true) // for optimization
        val insButton : Button = findViewById(R.id.insert)
        val delButton : Button = findViewById(R.id.delete)
        insButton.setOnClickListener {
            insert()
        }
        delButton.setOnClickListener {
            delete()
        }
    }
    private fun insert(){
        val num = Random.nextInt(8)
        itemList.add(itemDataClass(R.drawable.ic_launcher_background, "Index=$num", "Sub:=$num"))// add to list
       adapter.notifyItemInserted(num)
    }
    private fun delete() {
        val num = Random.nextInt(8)
        itemList.removeAt(num)
        adapter.notifyItemRemoved(num)
    }
    private fun generateList(size: Int) : ArrayList<itemDataClass> {
        val customList = ArrayList<itemDataClass>()
        for (i in 0 until size){
           val resImage : Int = when(i % 3){
               0 -> R.drawable.ic_baseline_apartment_24
               1 -> R.drawable.ic_launcher_background
               else -> R.drawable.ic_launcher_foreground
           }
          customList.add(itemDataClass(resImage, "This is the res = $i", "This is the sub text = $i"))
        }
        return customList
    }
}