package com.idn.farras.subkade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

//TODO 2. Menampilkan halaman detail ketika item dipilih.
class DetailActivity : AppCompatActivity() {

    // variable penampung
    private var club_name : String = ""
    private var club_image : Int = 0

    // deklarasi widget
    lateinit var tv_nama : TextView
    lateinit var img_club : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //TODO 4. Menerapkan Anko Layout
        verticalLayout {
            padding = dip(10)

            tv_nama = textView(){
                gravity = Gravity.CENTER
                topPadding = dip(15)
            }

            img_club = imageView()
        }

        // proses nampung
        club_name = intent.getStringExtra("nama")
        club_image = intent.getIntExtra("image", 0)

        // set isi widget
        tv_nama.text = club_name
        Picasso.get().load(club_image).into(img_club)

    }
}
