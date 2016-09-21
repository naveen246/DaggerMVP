package com.example.naveen.daggermvp_tutorial;

import android.app.Application;

import com.example.naveen.daggermvp_tutorial.data.component.DaggerNetComponent;
import com.example.naveen.daggermvp_tutorial.data.component.NetComponent;
import com.example.naveen.daggermvp_tutorial.data.module.AppModule;
import com.example.naveen.daggermvp_tutorial.data.module.NetModule;

public class App extends Application {
    private NetComponent mNetComponent;
    private String mBaseUrl = "http://jsonplaceholder.typicode.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(mBaseUrl))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
