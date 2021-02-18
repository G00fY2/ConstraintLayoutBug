package com.g00fy2.constraintlayoutbug

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.g00fy2.constraintlayoutbug.databinding.LayoutTestViewBinding

class TestView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutTestViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        setBackgroundResource(R.color.bg_selector)
    }

    fun setTextBelow() {
        binding.textViewBelow.text = "bottom textview"
    }

    fun setMainText(input: String, forceLayout: Boolean) {
        binding.includedView.includedTextview.text = input
        // workaround is to call forceLayout
        if (forceLayout) binding.includedView.includedTextview.forceLayout()
    }
}