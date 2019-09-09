package io.legado.app.ui.main.rss

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import io.legado.app.App
import io.legado.app.R
import io.legado.app.base.BaseFragment
import io.legado.app.lib.theme.ATH
import kotlinx.android.synthetic.main.fragment_rss.*

class RssFragment : BaseFragment(R.layout.fragment_rss),
    RssAdapter.CallBack {

    private lateinit var adapter: RssAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        initData()
    }

    private fun initRecyclerView() {
        ATH.applyEdgeEffectColor(recycler_view)
        adapter = RssAdapter(requireContext(), this)
        recycler_view.layoutManager = GridLayoutManager(requireContext(), 4)
        recycler_view.adapter = adapter
    }

    private fun initData() {
        App.db.rssSourceDao().liveEnabled().observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
    }

    override fun openRss() {

    }
}