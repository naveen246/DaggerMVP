package com.example.naveen.daggermvp_tutorial.data.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Provides @Singleton
    Application provideApplication() {
        return mApplication;
    }
}
