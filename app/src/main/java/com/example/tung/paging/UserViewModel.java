package com.example.tung.paging;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private MutableLiveData<List<User>> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        List<User> user = new ArrayList<>();
        user.add(new User(getApplication().getResources().getString(R.string.app_name)));
        users.setValue(user);
    }
}
