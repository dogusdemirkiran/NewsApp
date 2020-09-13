package com.program.restapikotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.program.restapikotlin.data.RetrofitProvider
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            val response = RetrofitProvider.newsApi.getTopHeadLines("tr", "0ae8b1c38e6d4c2fb309f9d46f7415d6")
            recyclerViewArticles.adapter = NewsAdapter(response.articles.orEmpty().toMutableList()){
                val direction = NewsFragmentDirections.actionNewsFragmentToArticleFragment(it)
                findNavController().navigate(direction)
            }
        }
    }
}