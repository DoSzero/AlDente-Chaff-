package com.ald.aldentechaff.model

import com.ald.aldentechaff.model.InfoConstants.infoList

data class Info(
    //val ids: Int,
    var cover: Int,
    var subTitle: String,
    var title: String,
    var description: String,
    val id: Int? = infoList.size
)