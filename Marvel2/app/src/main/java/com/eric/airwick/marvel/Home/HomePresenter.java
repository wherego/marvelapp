package com.eric.airwick.marvel.Home;

import android.util.Log;

import com.eric.airwick.marvel.api.MarvelService;
import com.eric.airwick.marvel.api.Models.Characters;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by airwick on 15/04/2017.
 */

public class HomePresenter implements HomeContract.Presenter{

    private final MarvelService marvelService;
    private final HomeContract.View view;

    public HomePresenter(MarvelService marvelService, HomeContract.View view) {
        this.marvelService = marvelService;
        this.view = view;
    }
    @Override
    public void getCharacters() {

        marvelService.getMarvelCharacters().subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(new MarvelCharactersSubscriber());
    }

    private class MarvelCharactersSubscriber extends Subscriber<Characters> {

        Characters characters;
        @Override
        public void onCompleted() {
            view.refreshAdapter(characters);
        }

        @Override
        public void onError(Throwable e) {
//handle exceptions
        }

        @Override
        public void onNext(Characters characters) {
            this.characters = characters;
        }

    }
}
