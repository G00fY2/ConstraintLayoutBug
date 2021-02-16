package com.g00fy2.constraintlayoutbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.g00fy2.constraintlayoutbug.databinding.ActivityMainBinding
import com.g00fy2.constraintlayoutbug.databinding.TestViewItemBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MinimalAdapter()
    }

    class MinimalAdapter : RecyclerView.Adapter<MinimalAdapter.ItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(
                TestViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    .apply {
                        root.setOnClickListener { this@MinimalAdapter.notifyDataSetChanged() }
                    }
            )
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.binding.testView.setTextBelow() // issue does not happen without updating this textview
            holder.binding.testView.setMainText(
                Random.nextLong(100000000000, 999999999999).toString()
            )
        }

        override fun getItemCount() = 1

        class ItemViewHolder(val binding: TestViewItemBinding) :
            RecyclerView.ViewHolder(binding.root)
    }
}