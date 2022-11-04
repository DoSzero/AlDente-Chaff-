package com.ald.aldentechaff.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ald.aldentechaff.R
import com.ald.aldentechaff.databinding.SampleDesignLayoutBinding
import com.ald.aldentechaff.model.Info
import com.ald.aldentechaff.model.InfoConstants.INFO_ID_EXTRA
import com.ald.aldentechaff.model.InfoConstants.getQuestions
import com.ald.aldentechaff.model.InfoConstants.infoList

class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding: SampleDesignLayoutBinding
    private var mSetInfoList: ArrayList<Info>? = null
    private var mCurrentPosition: Int = 1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SampleDesignLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSetInfoList = getQuestions()

        // compere slider id
        val categoryId = intent.getStringExtra("categoryId").toString()
        val infoID = intent.getIntExtra(INFO_ID_EXTRA, 1)
        val infos = infoFromID(infoID)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        when (categoryId) {
            // 1
            "Фузилли" -> {
                binding.cover.setImageResource(R.drawable.dente1)
                binding.title.text = "Фузилли"
                binding.author.text = "Фузилли с грибами и сезонными овощами"
                binding.description.text = "Для приготовления 4 порций нужно:\n" +
                        "\n" +
                        "2 см свежего корня имбиря\n" +
                        "1 крупный сладкий перец\n" +
                        "1 средний кабачок\n" +
                        "2 красные луковицы\n" +
                        "300 г шампиньонов \n" +
                        "400 г фузилли\n" +
                        "200 г мелких помидоров черри\n" +
                        "1 ч. л. семян зиры\n" +
                        "оливковое масло «экстра вирджин»\n" +
                        "соль, свежемолотый чёрный перец"
            }

            //2
            "МорроСпагетти" -> {
                binding.cover.setImageResource(R.drawable.dente2)
                binding.title.text = "Морро Спагетти"
                binding.author.text = "Морро Спагетти из цельнозерновой муки с цукини, кальмаром"
                binding.description.text = "Для приготовления 4 порций нужно:\n" +
                        "\n" +
                        "200 г свежемороженого зелёного горошка\n" +
                        "2 средних кальмара\n" +
                        "1 средний цукини или молодой кабачок\n" +
                        "листики 5 веточек петрушки\n" +
                        "200 г жёлтых помидоров черри\n" +
                        "1 зубчик чеснока\n" +
                        "300 г спагетти из цельнозерновой муки\n" +
                        "оливковое масло «экстра вирджин»\n" +
                        "лимонный сок\n" +
                        "соль, свежемолотый чёрный перец"
            }

            // 3
            "Паппарделле" -> {
                binding.cover.setImageResource(R.drawable.dente3)
                binding.title.text = "Паппарделле"
                binding.author.text = "Паппарделле с зубаткой и голубым сыром"
                binding.description.text = "Для приготовления 4 порций нужно:\n" +
                        "\n" +
                        "300 г паппарделле или другой плоской широкой пасты\n" +
                        "3 л питьевой воды\n" +
                        "100 г сыра с голубой плесенью\n" +
                        "300 г филе зубатки\n" +
                        "2 зубчика чеснока\n" +
                        "100 г свежего шпината\n" +
                        "20 г сливочного масла\n" +
                        "200-250 мл сливок жирностью 22%\n" +
                        "соль, свежемолотый чёрный перец\n"
            }

            "Пенне" -> {
                binding.cover.setImageResource(R.drawable.dente4)
                binding.title.text = "Пенне"
                binding.author.text = "Пенне со сладким перцем"
                binding.description.text = "Для приготовления 4 порций нужно:\n" +
                        "\n" +
                        "1 большой сладкий перец или 2 половинки сладкого перца разных цветов\n" +
                        "2 ст. л. оливкового масла «экстра вирджин»\n" +
                        "4 мясистых помидора \n" +
                        "200 г моццареллы\n" +
                        "листики 1 веточки базилика \n" +
                        "30-40 г тёртого сыра пармезан\n" +
                        "500  г пасты пенне\n" +
                        "соль и свежемолотый чёрный перец"
            }

            "Тальятелле" -> {
                binding.cover.setImageResource(R.drawable.dente5)
                binding.title.text = "Тальятелле"
                binding.author.text = "Тальятелле с куриными потрошками"
                binding.description.text = "Для приготовления 6-8 порций порций нужно:\n" +
                        "\n" +
                        "800 г желудочков курицы, утки или индейки\n" +
                        "2 большие луковицы\n" +
                        "5-7 зубчиков чеснока\n" +
                        "1 средняя морковка\n" +
                        "4 черешка сельдерея\n" +
                        "оливковое масло «экстра вирджин»\n" +
                        "1 ст. л. молотой паприки\n" +
                        "600-700 грубленых помидоров в собственном соку\n" +
                        "500 г тальятелле\n" +
                        "пряная зелень для подачи\n" +
                        "соль, свежемолотый чёрный перец"
            }


            "Феттуччине" -> {
                binding.cover.setImageResource(R.drawable.dente6)
                binding.title.text = "Феттуччине"
                binding.author.text = "Феттуччине с колбасками, маслинами"
                binding.description.text = "Для приготовления 4 порций нужно:\n" +
                        "\n" +
                        "3 зубчика чеснока\n" +
                        "200 г помидоров черри\n" +
                        "1 банка (400 г) смеси оливок и маслин\n" +
                        "2 веточки розмарина\n" +
                        "2 веточки тимьяна\n" +
                        "100 г охотничьих колбасок\n" +
                        "70 г бекона\n" +
                        "3 л питьевой воды\n" +
                        "300 г феттуччине или паппарделле\n" +
                        "оливковое масло «экстра вирджин»\n" +
                        "пармезан по желанию\n" +
                        "соль, свежемолотый чёрный перец"
            }


            "СалатФарфале" -> {
                binding.cover.setImageResource(R.drawable.dente7)
                binding.title.text = "Салат Фарфалей"
                binding.author.text = "Салат с фарфалле и сёмгой"
                binding.description.text = "Для приготовления 4 порций нужно:\n" +
                        "\n" +
                        "300 г фарфалле\n" +
                        "1 ст. л. оливкового масла «экстра вирджин»\n" +
                        "1 зубчик чеснока\n" +
                        "2 ст. л. каперсов\n" +
                        "5 веточек укропа\n" +
                        "125 г маскарпоне\n" +
                        "1 ст. л. лимонного сока\n" +
                        "200 г филе сёмги или другой лососёвой рыбы холодного копчения\n" +
                        "1 длинный огурец\n" +
                        "100 г шпината\n" +
                        "соль и свежемолотый чёрный перец"
            }
        }
    }

//    @SuppressLint("SetTextI18n")
//    private fun setQuestion() {
//        val question = mSetInfoList!!.get(mCurrentPosition - 1)
//        binding.title.text = Info.subTitle.binding.cover.setImageResource()
//        binding.title.text = Info
//        binding.description.text = getQuestions().description
//        binding.author.text = getQuestions().subTitle
//    }
}

    private fun infoFromID(infoID: Int): Info? {
        for (info in infoList) {
            if (info.id == infoID)
                return info
        }
        return null
    }

