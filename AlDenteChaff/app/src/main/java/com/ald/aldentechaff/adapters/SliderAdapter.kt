package com.ald.aldentechaff.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ald.aldentechaff.R
import com.ald.aldentechaff.model.SliderModel
import com.ald.aldentechaff.view.CategoriesActivity

class SliderAdapter(
    private var list:ArrayList<SliderModel>,
    private var context: Context
    ) :RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val sliderImage:ImageView= itemView.findViewById(R.id.slider_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.slider_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // slider Id
        val currentItem = list[position]
        holder.sliderImage.setImageResource(currentItem.sliderImage)
        // id to set fun
        val currentInfo = list[position]
        holder.sliderImage.setImageResource(currentInfo.sliderImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CategoriesActivity::class.java)
            intent.putExtra("categoryId",currentItem.sliderId)
            //
            intent.putExtra("infoExtra",currentInfo.sliderId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}