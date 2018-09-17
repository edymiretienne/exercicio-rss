package br.ufpe.cin.if710.rss

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.itemlista.view.*

//new adapter
class Adapter (private val itens: List<ItemRSS>, private val c : Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun getItemCount(): Int = itens.size

    class ViewHolder (item : View) : RecyclerView.ViewHolder(item) {
        val titulo = item.item_titulo
        val datap = item.item_data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(c).inflate(R.layout.itemlista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val i = itens[position]
        holder.titulo.text = i.title
        holder.datap.text = i.pubDate
        holder.titulo.setOnClickListener {
            val uri = Uri.parse(i.link)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            c.startActivity(intent)
        }
    }


}