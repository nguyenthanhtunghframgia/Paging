package com.example.tung.paging;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
        initViews();
    }

    private void initViewModel() {
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    private void initViews() {
        final TextView textView = findViewById(R.id.text_user_name);

        final Observer<List<User>> nameObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> users) {
                textView.setText(users.get(0).getName());
            }
        };

        mUserViewModel.getUsers().observe(this, nameObserver);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> users = new ArrayList<>();
                users.add(new User(getResources().getString(R.string.new_string)));
                mUserViewModel.getUsers().setValue(users);
            }
        });
    }
}
