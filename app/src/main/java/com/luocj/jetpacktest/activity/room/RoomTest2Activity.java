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
import androidx.room.Room;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.activity.dao.PersonDao;
import com.luocj.jetpacktest.activity.dao.PersonDatabase;
import com.luocj.jetpacktest.model.Person;
import com.luocj.jetpacktest.model.Word;

import java.util.List;

//room 增删改查基本使用
public class RoomTest2Activity extends AppCompatActivity {
    private TextView textView;
    private Button btnInsert, btnClear, btnUpdate, btnDelete;
    private List<Person> list;
    private PersonDatabase personDatabase;
    private PersonDao personDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_test2);
        textView = findViewById(R.id.textView9);
        btnInsert = findViewById(R.id.button12);
        btnClear = findViewById(R.id.button13);
        btnUpdate = findViewById(R.id.button14);
        btnDelete = findViewById(R.id.button15);


        personDatabase = PersonDatabase.getINSTANCE(this);
        personDao = personDatabase.getPersonDao();
        LiveData<List<Person>> allWordsLive = personDao.getAllWords();
        allWordsLive.observe(this, new Observer<List<Person>>() {
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
                new InsertAsyTask(personDao).execute(zs, ls);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ClearAllAsyTask(personDao).execute();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person("王五", "12");
                person.setId(6);
                new UpdateAsyTask(personDao).execute(person);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person("", "");
                person.setId(16);
                new DeleteAsyTask(personDao).execute(person);
            }
        });
    }


    static class InsertAsyTask extends AsyncTask<Person, Void, Void> {

        private final PersonDao personDao;

        public InsertAsyTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persions) {
            personDao.insertPersion(persions);
            return null;
        }
    }

    //删除所有数据
    static class ClearAllAsyTask extends AsyncTask<Person, Void, Void> {

        private final PersonDao personDao;

        public ClearAllAsyTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persions) {
            personDao.deleteAllWord();
            return null;
        }
    }


    //根据id更新数据
    static class UpdateAsyTask extends AsyncTask<Person, Void, Void> {

        private final PersonDao personDao;

        public UpdateAsyTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persions) {
            personDao.updatePersion(persions);
            return null;
        }
    }

    //删除
    static class DeleteAsyTask extends AsyncTask<Person, Void, Void> {

        private final PersonDao personDao;

        public DeleteAsyTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persions) {
            personDao.deletetPersion(persions);
            return null;
        }
    }
}
