package com.example.naveen.daggermvp_tutorial.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.naveen.daggermvp_tutorial.App;
import com.example.naveen.daggermvp_tutorial.R;
import com.example.naveen.daggermvp_tutorial.data.Post;
import com.example.naveen.daggermvp_tutorial.mainscreen.MainScreenContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Inject MainScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.my_list);
        list = new ArrayList<>();

        DaggerMainScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        presenter.loadPost();
    }

    @Override
    public void showPosts(List<Post> posts) {
        for(Post post : posts) {
            list.add(post.getTitle());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();
    }
}
