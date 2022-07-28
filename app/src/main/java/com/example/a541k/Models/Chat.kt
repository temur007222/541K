package com.example.a541k.Models

class Chat {
    var message: Message? = null
    var room: ArrayList<Room> = ArrayList()

    constructor(message: Message){
        this.message = message
    }

    constructor(room: ArrayList<Room>){
        this.room = room
    }
}