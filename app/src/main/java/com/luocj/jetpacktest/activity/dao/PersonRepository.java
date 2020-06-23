package com.luocj.jetpacktest.activity.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.luocj.jetpacktest.model.Person;
import com.luocj.jetpacktest.model.PersonViewModel;

import java.util.List;

public class PersonRepository {
    private final PersonDao personDao;
    private LiveData<List<Person>> allPersonLive;
    private final PersonDatabase personDatabase;

    public PersonRepository(Context context) {
        personDatabase = PersonDatabase.getINSTANCE(context.getApplicationContext());
        personDao = personDatabase.getPersonDao();

        allPersonLive = personDao.getAllPerson();
    }

    public LiveData<List<Person>> getAllPersonLive() {
        return allPersonLive;
    }

    public void setAllPersonLive(LiveData<List<Person>> allPersonLive) {
        this.allPersonLive = allPersonLive;
    }

    public void insertPerson(Person... person) {
        new InsertAsyTask(personDao).execute(person);
    }

    public void clearAllPerson(Person... person) {
        new ClearAllAsyTask(personDao).execute(person);
    }

    public void updatePerson(Person... person) {
        new UpdateAsyTask(personDao).execute(person);
    }

    public void deletePerson(Person... person) {
        new DeleteAsyTask(personDao).execute(person);
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
