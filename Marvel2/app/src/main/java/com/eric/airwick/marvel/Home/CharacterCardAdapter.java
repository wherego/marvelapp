package com.eric.airwick.marvel.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return characters.data.results.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
