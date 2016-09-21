package com.example.naveen.daggermvp_tutorial.mainscreen;

import com.example.naveen.daggermvp_tutorial.data.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainScreenPresenter implements MainScreenContract.Presenter {
    MainScreenContract.View mView;
    Retrofit mRetrofit;

    @Inject
    public MainScreenPresenter(MainScreenContract.View view, Retrofit retrofit) {
        this.mView = view;
        this.mRetrofit = retrofit;
    }

    @Override
    public void loadPost() {
        mRetrofit.create(PostService.class).getPosts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .subscribe(new Observer<List<Post>>() {
                @Override
                public void onCompleted() {
                    mView.showComplete();
                }

                @Override
                public void onError(Throwable e) {
                    mView.showError(e.getMessage());
                }

                @Override
                public void onNext(List<Post> posts) {
                    mView.showPosts(posts);
                }
            });
    }

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPosts();
    }
}
