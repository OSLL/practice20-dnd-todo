package com.makentoshe.androidgithubcitemplate

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import java.io.FileReader
import java.io.InputStream

class State (
    val msg: String = "",
    val monster: Boolean = false,
    val itemDrop: Boolean = false
) {
    var words: List<String>? = null
    var cur = 0
    val maxOffset = 270

    private fun getWords(){
        words = msg.split(".")
    }

    fun getText() : String {
        if (this.words == null) getWords()

        var ans: String = ""
        var offset = 0
        while (cur < this.words!!.size && offset + this.words?.get(cur)!!.length + 1 < maxOffset){
            if (ans != "") ans += " "
            ans += this.words!![cur]
            ans += "."
            offset += 2 + this.words!![cur].length
            cur++
        }
        return ans
    }

    fun isActive(): Boolean {
        if (this.words == null) getWords()

        if (cur > this.words!!.lastIndex) return false
        return true
    }

    fun getItem(): Item {
        return Item(drawableId = R.drawable.chest2, typeOfItem = "chest", armor = 4)
    }

    fun getMonster(): Monster {
        return Monster(10, 5)
    }
}


public fun readData(context: Context, fileName: String = "data.json"): List<State> {
    var json: String = ""
    try {
        val  inputStream: InputStream = context.assets.open(fileName)
        json = inputStream.bufferedReader().use{it.readText()}
        Log.d("JSON", json)
    } catch (ex: Exception) {
        Log.d("EX", "sad")
        ex.printStackTrace()
        return emptyList()
    }
    Log.d("DATA GOT FROM JSON", json)
    val jsonArray = Gson().fromJson(json, JsonArray::class.java)
    return jsonArray.map { it.asString }.map { Gson().fromJson(it, State::class.java) }
}