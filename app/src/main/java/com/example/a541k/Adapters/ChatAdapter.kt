package com.example.a541k.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a541k.Models.Chat
import com.example.a541k.Models.Room
import com.example.a541k.R
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(var context: Context, var  items: ArrayList<Chat>):
RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]

        if (feed.room.size > 0)
            return TYPE_ITEM_ROOM
            return TYPE_ITEM_MESSAGE
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       if (viewType == TYPE_ITEM_ROOM){
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
           return RoomViewHolder(context, view)
       }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MesageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if (holder is RoomViewHolder){
            val recyclerView = holder.recyclerView
            refreshAdapter(message.room, recyclerView)
        }

        val chat = items[position]

        if (holder is MesageViewHolder){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname
            val is_online = holder.is_online

            iv_profile.setImageResource(chat.message!!.profile)
            tv_fullname.text = chat.message!!.fullname
            if (chat.message!!.isOnline){
                is_online.visibility = View.VISIBLE
            }else{
                is_online.visibility = View.GONE
            }
        }
    }

    private fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView){
        val adapter = RoomAdapter( rooms)
        recyclerView.adapter = adapter
    }

    class RoomViewHolder(context: Context, view: View): RecyclerView.ViewHolder(view){
         var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.rv)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }
    }

    class  MesageViewHolder( view: View): RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView
        var is_online: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.fullname)
            is_online = view.findViewById(R.id.tv_count)
        }
    }
}