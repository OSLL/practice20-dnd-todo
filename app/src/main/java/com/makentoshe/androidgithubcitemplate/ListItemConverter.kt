package com.makentoshe.androidgithubcitemplate

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray

/*
object ListItemConverter {
    @TypeConverter
    @JvmStatic
    fun fromItems(items: ArrayList<Item>): String {
        var ans: String = ""
        for (i in items){
            //if (i == null) continue
            val res: String = "${i.iid}.${i.drawableId}.${i.typeOfItem}.${i.extendHp}.${i.equiped},"
            ans += res
        }
        return ans
    }

    @TypeConverter
    @JvmStatic
    fun toItems(data: String): ArrayList<Item> {
        var ans: ArrayList<Item> = arrayListOf()
        val items: List<String> = data.split(",")
        for (i in items){
            if (!i.isNotBlank()) continue
            val fields: List<String> = i.split(".")
            val cur: Item = Item()
            cur.iid = fields[0].toInt()
            cur.drawableId = fields[1].toInt()
            cur.typeOfItem = fields[2]
            cur.extendHp = fields[3].toInt()
            cur.equiped = fields[4].toBoolean()
            ans = ans.plus(cur) as ArrayList<Item>
        }
        return ans
    }
}
 */

object ListItemConverter {
    @TypeConverter
    @JvmStatic
    fun fromItems(items: List<Item>): String {
        val jsonArray = JsonArray()
        items.map { Gson().toJson(it) }.forEach(jsonArray::add)
        Log.d("SAVED JSON", jsonArray.toString())
        Log.d("SAVED JSON", items.size.toString())

        return jsonArray.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toItems(data: String): List<Item> {
        //var data2 = data.substring(1, data.lastIndex)
        Log.d("GOT JSON", data)
        //Log.d("GOT JSON 2", data2)
        val jsonArray = Gson().fromJson(data, JsonArray::class.java)
        Log.d("GOT JSON", jsonArray.size().toString())
        if (jsonArray.size() > 0) Log.d("GAVNO", jsonArray[0].toString())
        Log.d("KAVO", jsonArray.map { it.asString }.map { Gson().fromJson(it, Item::class.java) }.size.toString())
        return jsonArray.map { it.asString }.map { Gson().fromJson(it, Item::class.java) }
        //return emptyList()
        //Gson().fromJson(json, Hub::class.java)
    }
}