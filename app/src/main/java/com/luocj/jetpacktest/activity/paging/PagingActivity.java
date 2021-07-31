package com.luocj.jetpacktest.activity.paging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luocj.jetpacktest.R;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class PagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final PagingAdapter adapter = new PagingAdapter();
        rv.setAdapter(adapter);

    }



    private class PagingAdapter extends PagedListAdapter<Student, PagingAdapter.Hodler> {
        protected PagingAdapter() {
            super(new DiffUtil.ItemCallback<Student>() {
                @Override
                public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                    return oldItem.hashCode() == newItem.hashCode();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                    return oldItem.getName().equals(newItem.getName());
                }
            });
        }

        @NonNull
        @Override
        public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell, parent, false);
            return new Hodler(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull Hodler holder, int position) {
            Student item = getItem(position);
            holder.name.setText(item.getName());
            holder.age.setText(item.getAge());
        }

        public class Hodler extends RecyclerView.ViewHolder {
            TextView name;
            TextView age;

            public Hodler(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                age = itemView.findViewById(R.id.age);
            }
        }
    }
}