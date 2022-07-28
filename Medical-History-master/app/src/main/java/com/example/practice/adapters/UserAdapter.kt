package com.example.practice.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import com.example.practice.databinding.RecyclerListLayoutBinding
import com.example.practice.models.User
import com.example.practice.ui.home.HomeFragmentDirections

class UserAdapter : ListAdapter<User,
        UserAdapter.ViewHolder>(UserDiffCallback()) {

    override fun onBindViewHolder(
        holder: ViewHolder, position: Int) {
        val item = getItem(position)
        bind(holder, item)}

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)}

    class ViewHolder private constructor(
        val binding: RecyclerListLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: User){
            binding.user = item
            binding.executePendingBindings()}

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater
                    .from(parent.context)
                val binding = RecyclerListLayoutBinding
                    .inflate(layoutInflater, parent,false)
                return ViewHolder(binding)
            }
        }
    }

    private fun bind(holder: ViewHolder, item: User) {

        //needed to display data
        holder.binding.itemDate.text = item.date_tv
        holder.binding.itemWeight.text = item.weight_tv
        holder.binding.itemHours.text = item.hour_tv
        holder.binding.itemColon.text = item.colon_tv
        holder.binding.itemMinutes.text = item.minutes_tv
        holder.binding.itemBg.text = item.bg_tv
        holder.binding.itemSystolic.text = item.systolic_tv
        holder.binding.itemSlash.text = item.slash_tv
        holder.binding.itemDiastolic.text = item.diastolic_tv
        holder.binding.itemMed1.text = item.med1_tv
        holder.binding.itemMed2.text = item.med2_tv
        holder.binding.itemMed3.text = item.med3_tv
        holder.binding.itemMed4.text = item.med4_tv
        holder.binding.itemMed5.text = item.med5_tv
        holder.binding.itemMed6.text = item.med6_tv
        holder.binding.itemMed7.text = item.med7_tv
        holder.binding.itemMed8.text = item.med8_tv
        holder.binding.itemMed9.text = item.med9_tv
        holder.binding.itemMed10.text = item.med10_tv
        holder.binding.itemComment.text = item.comment_tv

        //prints text in red when systolic is high
        try {
            val b: Int = holder.binding.itemSystolic.text.toString().toInt()
            if (b > 120) {holder.binding.itemSystolic.setTextColor(Color.RED)}
        } catch (nfe: NumberFormatException) {println("Could not parse $nfe")}

        //prints text in red when bg is high
        try {
            val b: Int = holder.binding.itemBg.text.toString().toInt()
            if (b > 120) {holder.binding.itemBg.setTextColor(Color.RED)}
        } catch (nfe: NumberFormatException) {println("Could not parse $nfe")}

        //prints text in red when diastolic is high
        try {
            val b: Int = holder.binding.itemDiastolic.text.toString().toInt()
            if (b > 80) {holder.binding.itemDiastolic.setTextColor(Color.RED)}
        } catch (nfe: NumberFormatException) {println("Could not parse $nfe")}

        //invisibles colon when itemMinutes is blank
        if (holder.binding.itemMinutes.text.isBlank()) {
            holder.binding.itemColon.visibility = View.INVISIBLE}

        //invisibles slash when itemDiastolic is blank
        if (holder.binding.itemDiastolic.text.isBlank()) {
            holder.binding.itemSlash.visibility = View.INVISIBLE}

        //gones itemMed# when empty
        if (holder.binding.itemMed1.text.isEmpty()) {
            holder.binding.itemMed1.visibility = View.GONE}
        if (holder.binding.itemMed2.text.isEmpty()) {
            holder.binding.itemMed2.visibility = View.GONE}
        if (holder.binding.itemMed3.text.isEmpty()) {
            holder.binding.itemMed3.visibility = View.GONE}
        if (holder.binding.itemMed4.text.isEmpty()) {
            holder.binding.itemMed4.visibility = View.GONE}
        if (holder.binding.itemMed5.text.isEmpty()) {
            holder.binding.itemMed5.visibility = View.GONE}
        if (holder.binding.itemMed6.text.isEmpty()) {
            holder.binding.itemMed6.visibility = View.GONE}
        if (holder.binding.itemMed7.text.isEmpty()) {
            holder.binding.itemMed7.visibility = View.GONE}
        if (holder.binding.itemMed8.text.isEmpty()) {
            holder.binding.itemMed8.visibility = View.GONE}
        if (holder.binding.itemMed9.text.isEmpty()) {
            holder.binding.itemMed9.visibility = View.GONE}
        if (holder.binding.itemMed10.text.isEmpty()) {
            holder.binding.itemMed10.visibility = View.GONE}

        holder.itemView.findViewById<LinearLayout>(R.id.visible_full_row)
            .setOnClickListener {
                val action = HomeFragmentDirections.homeFragmentToEditFragment(item)
                holder.itemView.findNavController().navigate(action)
            }
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areContentsTheSame(
        oldItem: User, newItem: User): Boolean {
        return oldItem == newItem}

    override fun areItemsTheSame(
        oldItem: User, newItem: User): Boolean {
        return oldItem.stat_id == newItem.stat_id}
}