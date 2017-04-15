package com.eric.airwick.marvel.Home.dependencies;

import com.eric.airwick.marvel.Home.HomeView;
import com.eric.airwick.marvel.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by airwick on 15/04/2017.
 */
@Singleton
@Component(modules = {HomeModule.class, ApiModule.class})
public interface HomeComponent {

    void inject(HomeView homeView);
}
