package com.example.a541k.Adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a541k.Models.Room
import com.example.a541k.R
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class RoomAdapter( var items: ArrayList<Room>) :
    RecyclerView.Adapter<RoomAdapter.Vh>() {

    inner class Vh(var view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(room: Room, position: Int) {

            view.findViewById<ShapeableImageView>(R.id.iv_profile).setImageResource(room.profile)

            if (position == 0) {
                view.findViewById<TextView>(R.id.tv_count).visibility = View.GONE
            } else {
                view.findViewById<TextView>(R.id.fullname).text = room.fullname
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_room_view, parent, false
        )

        return Vh(view)

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

