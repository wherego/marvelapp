package com.eric.airwick.marvel.CharacterCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eric.airwick.marvel.R;
import com.eric.airwick.marvel.api.Models.Characters;

/**
 * Created by airwick on 15/04/2017.
 */

public class CharacterCardAdapter extends RecyclerView.Adapter<CharacterCardAdapter.ViewHolder> {

    private Characters characters;

    public CharacterCardAdapter(Characters characters) {
        this.characters = characters;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CharacterCard v = (CharacterCard) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_character, parent, false);
        ViewHolder viewholder = new ViewHolder(v);

        return  viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(characters, position);
    }

    @Override
    public int getItemCount() {
        return characters.data.results.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CharacterCard card;

        public ViewHolder(View itemView) {
            super(itemView);
            card = (CharacterCard) itemView;
        }

        public void bind(Characters characters, int position) {
          //  characters.data.results[position]
            Characters.Data.Result character = characters.data.results[position];
            card.setName(character.name);
            card.setImage(character.thumbnail.path + "." + character.thumbnail.extension);
        }
    }
}
