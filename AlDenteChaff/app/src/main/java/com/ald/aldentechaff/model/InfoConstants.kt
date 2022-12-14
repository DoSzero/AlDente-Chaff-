package com.ald.aldentechaff.model

import com.ald.aldentechaff.R


object InfoConstants {

    var infoList = mutableListOf<Info>()
    const val INFO_ID_EXTRA = "infoExtra"

    fun getQuestions(): ArrayList<Info> {
        val questionsList = ArrayList<Info>()
        val info1 = Info(
            R.drawable.dente1,
            "Бисквит",
            "Голубикой",
            "Культовая ягода, которую научились производить круглый год, в сочетании с рыхлым тестом — это абсолютно беспроигрышный вариант. Маффины с голубикой (да и не только с этой ягодой) стали популярным десертом в Англии и Америке, хотя происхождение их французское. Да и вообще эти маленькие сладкие кексы, какими мы их знаем сейчас, задумывались как обычный хлеб и на вкус были нейтральны. Сегодня существуют сотни рецептов этой выпечки: дрожжевые или с разрыхлителем, с использованием молока или сметаны, сладкие или соленые, с жидким центром или без. Этот ароматный хлеб хорош во всех своих проявлениях.\n" +
                    "\n" +
                    "- Мускатный орех по вкусу\n"
        )
        infoList.add(info1)

        val info2 = Info(
            R.drawable.dente2,
            "Бисквит",
            "Маффины ",
            "Абсолютно беспроигрышный вариант. Маффины с голубикой (да и не только с этой ягодой) стали популярным десертом в Англии и Америке, хотя происхождение их французское. Да и вообще эти маленькие сладкие кексы, какими мы их знаем сейчас, задумывались как обычный хлеб и на вкус были нейтральны. Сегодня существуют сотни рецептов этой выпечки: дрожжевые или с разрыхлителем, с использованием молока или сметаны, сладкие или соленые, с жидким центром или без. Этот ароматный хлеб хорош во всех своих проявлениях.\n" +
                    "\n" +
                    "- Мускатный орех по вкусу\n"
        )
       infoList.add(info2)

        val info3 = Info(
            R.drawable.dente3,
            "Бисквит",
            "Из клубники",
            "Культовая ягода, которую научились производить круглый год, в сочетании с рыхлым тестом — это абсолютно беспроигрышный вариант" +
                    "\n" +
                    "- Куриное яйцо ½ штуки\n"
        )
        infoList.add(info3)

        return questionsList
    }

}