package com.example.naveen.daggermvp_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.naveen.daggermvp_tutorial.data.Post;
import com.example.naveen.daggermvp_tutorial.mainscreen.MainScreenContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showPosts(List<Post> posts) {
        
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}
