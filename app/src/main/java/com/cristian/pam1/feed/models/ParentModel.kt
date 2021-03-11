package com.cristian.pam1.feed.models

data class ParentModel (
    val title : String = "",
    val children : List<ChildModel>
)