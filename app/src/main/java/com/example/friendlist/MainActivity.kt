package com.example.friendlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    public val contextPassed = this;

    //setup main access
    private lateinit var mainEnv: ActivityMainBinding

    private var layoutManager: RecyclerView.LayoutManager? = null;
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind
        mainEnv = ActivityMainBinding.inflate(layoutInflater)

        //set env
        setContentView(mainEnv.root)

        //remove the title bar
        this.supportActionBar!!.hide()

        //make the recyclerview
        layoutManager = LinearLayoutManager(applicationContext);

        mainEnv.recyclerView.layoutManager = layoutManager;

        adapter = RecyclerAdapter()
        mainEnv.recyclerView.adapter = adapter;

    }
}