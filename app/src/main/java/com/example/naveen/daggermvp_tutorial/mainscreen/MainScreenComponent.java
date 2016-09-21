package com.example.naveen.daggermvp_tutorial.mainscreen;

import com.example.naveen.daggermvp_tutorial.mainscreen.MainActivity;
import com.example.naveen.daggermvp_tutorial.data.component.NetComponent;
import com.example.naveen.daggermvp_tutorial.util.CustomScope;

import dagger.Component;

@CustomScope
@Component(dependencies = NetComponent.class, modules = {MainScreenModule.class})
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
