package com.g00fy2.constraintlayoutbug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.g00fy2.constraintlayoutbug.databinding.ActivityMainBinding
import com.g00fy2.constraintlayoutbug.databinding.TestViewItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MinimalAdapter()
    }

    inner class MinimalAdapter : RecyclerView.Adapter<MinimalAdapter.ItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(
                TestViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    .apply {
                        root.setOnClickListener { this@MinimalAdapter.notifyDataSetChanged() }
                    }
            )
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            // issue does not happen without updating this textview
            if (!binding.disableUpdateTextSwitch.isChecked) {
                holder.binding.testView.setTextBelow()
            }
            holder.binding.testView.setMainText(
                "inner textview",
                binding.forceLayoutSwitch.isChecked
            )
        }

        override fun getItemCount() = 1

        inner class ItemViewHolder(val binding: TestViewItemBinding) :
            RecyclerView.ViewHolder(binding.root)
    }
}