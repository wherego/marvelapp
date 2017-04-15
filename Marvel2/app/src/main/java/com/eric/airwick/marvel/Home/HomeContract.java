package com.eric.airwick.marvel.Home;

import com.eric.airwick.marvel.api.Models.Characters;

/**
 * Created by airwick on 15/04/2017.
 */

public class HomeContract {

    public interface View {
        void refreshAdapter(Characters characters);
    }

    public interface Presenter {

        void getCharacters();
    }
}
