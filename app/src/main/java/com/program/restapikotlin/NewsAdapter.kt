package com.program.restapikotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.program.restapikotlin.data.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class NewsAdapter(private val articleList: MutableList<Article>, val onClick: (Article) -> Unit): RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val note = articleList[position]
        holder.bind(note, onClick)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}

class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(article: Article, onClick: (Article) -> Unit) {
        itemView.imageView.load(article.urlToImage)
        itemView.textViewTitle.text = article.title

        itemView.setOnClickListener {
            onClick(article)
        }
    }
}