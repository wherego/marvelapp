package com.eric.airwick.marvel.api;

import com.eric.airwick.marvel.api.Models.Characters;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by airwick on 15/04/2017.
 */

public class MarvelService {
//implementation of service
private IMarvelService marvelService;

    public MarvelService (Retrofit retrofit) {
        marvelService = retrofit.create(IMarvelService.class);
    }

    public Observable<List<Characters>> getMarvelCharacters() {
       return marvelService.getCharacterList();
    }


}
