package com.ald.aldentechaff.model

data class SliderModel(
    var sliderId:String,
    var sliderImage:Int,
) {
    constructor():this(
        "",
        0
    )
}
