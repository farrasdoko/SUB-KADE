package com.idn.farras.subkade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.idn.farras.subkade.R.array.club_image
import com.idn.farras.subkade.R.array.club_name
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Items> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 1. Menampilkan list data ke dalam RecyclerView.
        // Proses Data
        initData()

        //TODO 3. Menerapkan Kotlin Android Extensions.
        // Kebutuhan Default Recycler View
        list_team.layoutManager = LinearLayoutManager(this)
        list_team.adapter = RecyclerViewAdapter(this, items){
            // onClick Action
            val toast = Toast.makeText(this, it.name,
                    Toast.LENGTH_SHORT)
            toast.show()
            //TODO 5. Menerapkan Anko Commons.
            startActivity<DetailActivity>("nama" to it.name
                                                    ,"image" to it.image)
        }
    }

    //initData Method
    private fun initData() {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices){
            items.add(Items(name[i], image.getResourceId(i, 0)))
        }

        // looping data
        image.recycle()
    }
}
