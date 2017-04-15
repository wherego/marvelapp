package com.eric.airwick.marvel.Home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.eric.airwick.marvel.CharacterCard.CharacterCardAdapter;
import com.eric.airwick.marvel.Home.dependencies.DaggerHomeComponent;
import com.eric.airwick.marvel.Home.dependencies.HomeComponent;
import com.eric.airwick.marvel.Home.dependencies.HomeModule;
import com.eric.airwick.marvel.R;
import com.eric.airwick.marvel.api.Models.Characters;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by airwick on 15/04/2017.
 */

public class HomeView extends FrameLayout implements HomeContract.View {

    @BindView(R.id.character_list)
    RecyclerView characterList;

    CharacterCardAdapter characterAdapter = new CharacterCardAdapter(null);

    @Inject
    HomeContract.Presenter presenter;

    public HomeView(Context context) {
        super(context);
    }

    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        HomeComponent homeComponent = DaggerHomeComponent.builder().homeModule(new HomeModule(this)).build();
        homeComponent.inject(this);
        ButterKnife.bind(this);

        characterList.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        characterList.setLayoutManager(mLayoutManager);

        presenter.getCharacters();
    }

    @Override
    public void refreshAdapter(Characters characters) {
        characterAdapter = null;
        characterAdapter = new CharacterCardAdapter(characters);
        characterList.setAdapter(characterAdapter);
    }
}
