package com.example.naveen.daggermvp_tutorial.mainscreen;

import com.example.naveen.daggermvp_tutorial.data.Post;

import java.util.List;

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);
        void showError(String message);
        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
