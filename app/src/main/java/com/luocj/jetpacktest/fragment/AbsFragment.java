package com.luocj.jetpacktest.fragment;

import androidx.fragment.app.Fragment;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.luocj.jetpacktest.ui.AbsModelView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

public abstract class AbsFragment<T, M extends AbsModelView<T>>
        extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {

}
