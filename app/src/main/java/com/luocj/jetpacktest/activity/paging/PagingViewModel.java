package com.luocj.jetpacktest.activity.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.List;

public class PagingViewModel extends ViewModel {
    private static final String TAG = PagingViewModel.class.getSimpleName();

    private LiveData<PagedList<Student>> student = null;
    private StudentSource mDataSource;
    //是否有数据
    private MutableLiveData<Boolean> boundaryPageData = new MutableLiveData<>();

    public LiveData<PagedList<Student>> getArticleLiveData() {
        if (student == null) {
            PagedList.Config config = new PagedList.Config.Builder()
                    .setPageSize(2)
                    .setInitialLoadSizeHint(22)
                    .build();
            student = new LivePagedListBuilder<Integer, Student>(mFactory, config)
//                    .setBoundaryCallback(mBoundaryCallback)
                    .build();
        }
        return student;
    }

    private DataSource.Factory<Integer, Student> mFactory = new DataSource.Factory<Integer, Student>() {
        @NonNull
        @Override
        public DataSource<Integer, Student> create() {
            if (mDataSource == null || mDataSource.isInvalid()) {
                mDataSource = new StudentSource();
            }
            return mDataSource;
        }
    };

    //监听数据边界
    private PagedList.BoundaryCallback<Student> mBoundaryCallback = new PagedList.BoundaryCallback<Student>() {
        @Override
        public void onZeroItemsLoaded() {
            super.onZeroItemsLoaded();
            //初始化数据
            boundaryPageData.postValue(false);
        }

        @Override
        public void onItemAtFrontLoaded(@NonNull Student itemAtFront) {
            super.onItemAtFrontLoaded(itemAtFront);
            //正在添加数据
            boundaryPageData.postValue(true);
        }

        @Override
        public void onItemAtEndLoaded(@NonNull Student itemAtEnd) {
            super.onItemAtEndLoaded(itemAtEnd);
            //没有数据加载了
            boundaryPageData.postValue(false);
        }
    };

    public StudentSource getDataSource() {
        return mDataSource;
    }

    public MutableLiveData<Boolean> getBoundaryPageData() {
        return boundaryPageData;
    }

    public void loadData(int currentPage, PageKeyedDataSource.LoadInitialCallback<Integer, Student> initialCallback
            , PageKeyedDataSource.LoadCallback<Integer, Student> callback) {

        Log.i(TAG, "loadData:  " + currentPage);
        if (initialCallback != null) {
            initialCallback.onResult(getListData(), -1, 0);
        } else {
            callback.onResult(getListData(), currentPage);
        }
//        String url = "https://www.wanandroid.com/article/list/" + currentPage + "/json";
//        OkGo.<String>get(url)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        Gson gson = new Gson();
//                        Student articleResponse = gson.fromJson(response.body(), Student.class);
//                        if (initialCallback != null) {
//                            initialCallback.onResult(articleResponse.getData().getDatas(), -1, 0);
//                        } else {
//                            callback.onResult(articleResponse.getData().getDatas(), currentPage);
//                        }
//                        boundaryPageData.postValue(articleResponse.getData().getDatas().size() <= 0);
//                    }
//                });
    }

    private List<Student> getListData() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            students.add(new Student("name:" + (10000 + i), "age:" + i));
        }
        return students;
    }

    public class StudentSource extends PageKeyedDataSource<Integer, Student> {
        @Override
        public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Student> callback) {
            //开始加载数据
            loadData(0, callback, null);
            Log.d(TAG, "loadInitial");
        }

        @Override
        public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Student> callback) {
            //往前加载数据
            Log.i(TAG, "loadBefore: ");
        }

        @Override
        public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Student> callback) {
            //往后加载数据
            loadData(params.key + 1, null, callback);
            Log.d(TAG, "loadAfter");
        }
    }
}
