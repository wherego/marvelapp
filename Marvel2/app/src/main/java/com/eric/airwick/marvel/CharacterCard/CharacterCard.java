package com.eric.airwick.marvel.CharacterCard;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.eric.airwick.marvel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by airwick on 15/04/2017.
 */

public class CharacterCard extends CardView {

    @BindView(R.id.card_character_name)
    TextView characterName;

    @BindView(R.id.card_character_image)
    NetworkImageView characterImage;

    public CharacterCard(Context context) {
        super(context);
    }

    public CharacterCard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CharacterCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this);
    }

    public void setName(String name) {
        characterName.setText(name);
    }

    public void setImage(String url) {
        characterImage.setImage(url);
    }
}
