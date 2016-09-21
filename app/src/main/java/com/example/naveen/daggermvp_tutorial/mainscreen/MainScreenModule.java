package com.example.naveen.daggermvp_tutorial.mainscreen;

import com.example.naveen.daggermvp_tutorial.util.CustomScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View view) {
        mView = view;
    }

    @Provides @CustomScope
    MainScreenContract.View provideMainScreenView() {
        return mView;
    }
}
