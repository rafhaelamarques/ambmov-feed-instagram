package br.com.cotemig.instagram.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.instagram.R
import br.com.cotemig.instagram.models.Post
import coil.load

class FeedAdapter(var context: Context, var list: List<Post>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_feed, null)

        var user = view.findViewById<TextView>(R.id.userText)
        var picture = view.findViewById<ImageView>(R.id.image)
        var desc = view.findViewById<TextView>(R.id.descText)

        user.text = (list[position].user)
        picture.load(list[position].image)
        desc.text = (list[position].description)

        return view
    }
}