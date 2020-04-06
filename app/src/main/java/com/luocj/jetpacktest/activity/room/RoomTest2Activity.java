package com.luocj.jetpacktest.activity.room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.activity.dao.PersonDao;
import com.luocj.jetpacktest.activity.dao.PersonDatabase;
import com.luocj.jetpacktest.model.Person;
import com.luocj.jetpacktest.model.PersonViewModel;

import java.util.List;

//room 增删改查基本使用
public class RoomTest2Activity extends AppCompatActivity {
    private TextView textView;
    private Button btnInsert, btnClear, btnUpdate, btnDelete;
    private List<Person> list;
    private PersonDatabase personDatabase;
    private PersonDao personDao;
    private PersonViewModel personViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_test2);
        textView = findViewById(R.id.textView9);
        btnInsert = findViewById(R.id.button12);
        btnClear = findViewById(R.id.button13);
        btnUpdate = findViewById(R.id.button14);
        btnDelete = findViewById(R.id.button15);

        personViewModel = new ViewModelProvider(this).get(PersonViewModel.class);

//        personDatabase = PersonDatabase.getINSTANCE(this);
//        personDao = personDatabase.getPersonDao();
//        LiveData<List<Person>> allWordsLive = personDao.getAllPerson();
        personViewModel.getAllLiveData().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < people.size(); i++) {
                    Person person = people.get(i);
                    str.append(person.getId()).append("姓名 :").append(person.getName()).append(",年龄 :").append(person.getAge()).append("\n");
                }
                textView.setText(str.toString());
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person zs = new Person("zhangsan", "12");
                Person ls = new Person("lisi", "123");

                personViewModel.insertPerson(zs, ls);
//                new InsertAsyTask(personDao).execute(zs, ls);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new ClearAllAsyTask(personDao).execute();
                personViewModel.clearAllPerson();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person("王五", "12");
                person.setId(6);
//                new UpdateAsyTask(personDao).execute(person);
                personViewModel.updatePerson(person);
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person("", "");
                person.setId(16);
//                new DeleteAsyTask(personDao).execute(person);
                personViewModel.deletePerson(person);
            }
        });
    }


}
