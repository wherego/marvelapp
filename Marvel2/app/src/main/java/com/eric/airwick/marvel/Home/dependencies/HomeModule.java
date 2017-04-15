package com.eric.airwick.marvel.Home.dependencies;

import com.eric.airwick.marvel.Home.HomeContract;
import com.eric.airwick.marvel.Home.HomePresenter;
import com.eric.airwick.marvel.api.MarvelService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by airwick on 15/04/2017.
 */
@Module
public class HomeModule {

    public HomeContract.View view;

    public HomeModule (HomeContract.View view) {
        this.view = view;
    }

    @Provides
    public HomeContract.Presenter provideHomePresenter(MarvelService marvelService) {

        return new HomePresenter(marvelService, view);
    };

}
