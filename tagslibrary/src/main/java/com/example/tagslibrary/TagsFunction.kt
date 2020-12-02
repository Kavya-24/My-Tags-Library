package com.example.tagslibrary

import android.content.Context
import android.view.LayoutInflater
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TagsFunction private constructor(builder: Builder) {

    private val mLayoutInflater: LayoutInflater
    private val context: Context
    private val parentView: LinearLayout
    private val wantVertical: Boolean
    private val wantMultiLine: Boolean


    // We will initialize these
    private var adapterTagsAdded: TagsAdapter = TagsAdapter()
    private var mutableList: MutableList<String> = mutableListOf()

    //We will take reference from the object for the following
    private val rv: RecyclerView
    private val etTag: AutoCompleteTextView
    private val btnCheck: Button


    fun onCheck() {
        //This is triggered when we check the tag
        if (etTag.text.isNotEmpty()) {
            mutableList.add(etTag.text.toString())
            setInTagRv()
            etTag.text = null
        }
    }

    //The cross is internally managed


    fun getTheList(): MutableList<String> {
        return mutableList
    }


    private fun setInTagRv() {


        adapterTagsAdded.tagAdded = mutableList
        val l1 = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val l2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv.layoutManager = if (wantVertical) l1 else l2
        rv.adapter = adapterTagsAdded


    }


    //This class will have the Builder methods
    class Builder(
        val context: Context,
        tagsMainClass: TagsMainClass
    ) {

        val parentView: LinearLayout
        val rv: RecyclerView
        val etTag: AutoCompleteTextView
        val btnCheck: Button

        fun build(): TagsFunction {
            return TagsFunction(this)
        }

        //Add the builder methods

        //The layoutManager is Horizontal by default.
        var isVerticalLayout = false
        var isMultiLine = false

        fun makeTheRecyclerViewVertical(isVertical: Boolean): Builder {
            this.isVerticalLayout = isVertical
            return this
        }

        //Singular Line and Multi Line Recycler View
        fun makeMultiLine(isMLine: Boolean): Builder {
            this.isMultiLine = isMLine
            return this
        }


        init {
            parentView = tagsMainClass
            rv = tagsMainClass.rv
            etTag = tagsMainClass.etTag
            btnCheck = tagsMainClass.btnCheck

        }
    }


    //Builder Init
    init {

        //Main Init
        context = builder.context
        parentView = builder.parentView
        wantMultiLine = builder.isMultiLine
        wantVertical = builder.isVerticalLayout
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rv = builder.rv
        etTag = builder.etTag
        btnCheck = builder.btnCheck


    }


}