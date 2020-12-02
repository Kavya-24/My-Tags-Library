package com.example.tagslibrary

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

//This is for when we will build the layout
//This will be called by the builder
class TagsMainClass : LinearLayout {


    lateinit var rv: RecyclerView
    lateinit var etTag: AutoCompleteTextView
    lateinit var btnCheck: Button

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init(attrs)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    @SuppressLint("Recycle")
    private fun init(@Nullable attrs: AttributeSet?) {
        //Setup image attributes


        rv = RecyclerView(context)
        rv.id = R.id.rv_layout_tags

        btnCheck = Button(context)
        btnCheck.id = R.id.iv_check

        etTag = AutoCompleteTextView(context)
        etTag.id = R.id.acv_layout_tags


    }


}