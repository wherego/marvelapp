package com.eric.airwick.marvel.Home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

import com.eric.airwick.marvel.Home.dependencies.DaggerHomeComponent;
import com.eric.airwick.marvel.Home.dependencies.HomeComponent;
import com.eric.airwick.marvel.Home.dependencies.HomeModule;
import com.eric.airwick.marvel.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by airwick on 15/04/2017.
 */

public class HomeView extends FrameLayout implements HomeContract.View {

    @BindView(R.id.home_request_characters)
    Button getCharactersButton;

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
    }

    @OnClick(R.id.home_request_characters)
    public void onCharactersButtonClick() {
        presenter.getCharacters();
    }


}
