package com.luocj.jetpacktest.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.luocj.jetpacktest.activity.dao.PersonRepository;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {

    private PersonRepository repository;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonRepository(application);
    }

    public LiveData<List<Person>> getAllLiveData() {
        return repository.getAllPersonLive();
    }


    public void insertPerson(Person... person) {
        repository.insertPerson(person);
    }

    public void clearAllPerson(Person... person) {
        repository.clearAllPerson(person);
    }

    public void updatePerson(Person... person) {
        repository.updatePerson(person);
    }

    public void deletePerson(Person... person) {
        repository.deletePerson(person);
    }


}
