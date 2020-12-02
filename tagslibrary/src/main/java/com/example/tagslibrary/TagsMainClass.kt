package com.example.tagslibrary

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
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


        //Init
        rv = RecyclerView(context)
        rv.id = R.id.rv_layout_tags

        btnCheck = Button(context)
        btnCheck.id = R.id.iv_check

        etTag = AutoCompleteTextView(context)
        etTag.id = R.id.acv_layout_tags

        //There will be external parameters defined
        val featureRV = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )


        val featureACTV = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        featureACTV.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        featureACTV.addRule(RelativeLayout.ALIGN_PARENT_START);


        val featureCheck = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        featureCheck.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        featureCheck.addRule(RelativeLayout.ALIGN_PARENT_END);




        print("In init of class")
        Log.e("IN CLASS", featureRV.toString())

        //Add view to parent
        addView(rv, featureRV)
        addView(etTag, featureACTV)
        addView(btnCheck, featureCheck)


    }


}