package com.example.naveen.daggermvp_tutorial.mainscreen;

import com.example.naveen.daggermvp_tutorial.data.component.NetComponent;

import dagger.Component;

@Component(dependencies = NetComponent.class, modules = {MainScreenModule.class})
public class MainScreenComponent {
}
