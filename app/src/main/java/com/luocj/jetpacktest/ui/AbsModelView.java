package com.luocj.jetpacktest.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public abstract class AbsModelView<T> extends ViewModel {

    private final PagedList.Config config;
    private DataSource dataSource;
    private LiveData<PagedList<T>> pageData;

    private MutableLiveData<Boolean> boundaryPageData = new MutableLiveData<>();

    public AbsModelView() {
        config = new PagedList.Config.Builder()
                .setPageSize(10)
                .setInitialLoadSizeHint(12)
//                .setMaxSize(100)
//                .setEnablePlaceholders(false)
//                .setPrefetchDistance()
                .build();


        pageData = new LivePagedListBuilder(factory, config)
                .setInitialLoadKey(0)
                //.setFetchExecutor()
                .setBoundaryCallback(callback)
                .build();
    }

    PagedList.BoundaryCallback<T> callback = new PagedList.BoundaryCallback<T>() {
        @Override
        public void onZeroItemsLoaded() {
            boundaryPageData.postValue(false);
        }

        @Override
        public void onItemAtFrontLoaded(@NonNull T itemAtFront) {
            //新提交的PagedList中第一条数据被加载到列表上
            boundaryPageData.postValue(true);
        }

        @Override
        public void onItemAtEndLoaded(@NonNull T itemAtEnd) {
            super.onItemAtEndLoaded(itemAtEnd);
        }
    };

    DataSource.Factory factory = new DataSource.Factory() {
        @NonNull
        @Override
        public DataSource create() {

            if (dataSource == null || dataSource.isInvalid()) {
                dataSource = creatDataSource();
            }
            return dataSource;
        }
    };

    protected abstract DataSource creatDataSource();

    //可以在这个方法里 做一些清理 的工作
    @Override
    protected void onCleared() {

    }
}
