package com.cristian.pam1.feed.models

import com.cristian.pam1.R
import java.net.URL
import java.util.*

object ChildDataFactory{

    private val random = Random()

    private val titles =  arrayListOf( "Yagami Light", "Ryzaki", "Ryuk")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomImage() : Int{
        return R.drawable.l
    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(null, randomTitle())
            children.add(child)
        }
        return children
    }


}