package com.eric.airwick.marvel.Home;

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

    private class MarvelCharactersSubscriber extends Subscriber<List<Characters>> {

        List<Characters> characters;
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<Characters> characters) {

        }
    }
}
