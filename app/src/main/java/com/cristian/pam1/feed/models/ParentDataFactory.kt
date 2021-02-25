package com.cristian.pam1.feed.models

import java.util.*

object ParentDataFactory{
    private val random = Random()

    private val titles =  arrayListOf( "Isekai", "Ecchi", "Harem", "Yaoi", "Yuri", "Lolicon", "Adventure")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomChildren() : List<ChildModel>{
        return ChildDataFactory.getChildren(20)
    }

    fun getParents(count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel(randomTitle(), randomChildren())
            parents.add(parent)
        }
        return parents
    }
}