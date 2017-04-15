package com.eric.airwick.marvel.api;

import com.eric.airwick.marvel.api.Models.Characters;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by airwick on 15/04/2017.
 */

public interface IMarvelService {

    //interface for endpoints
    @GET("/v1/public/characters")
    Observable<List<Characters>> getCharacterList();

}
