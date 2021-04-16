package com.example.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.ViewHolder> {
    private List<BoardGame> mLiu;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView id;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.boardgame_image1);
            name=itemView.findViewById(R.id.boardgame_name1);
        }
    }
    //构造
    public PuAdapter(List<BoardGame> boardGameList){
        mLiu=boardGameList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pu_recyclerview,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BoardGame boardGame=mLiu.get(position);
        holder.id.setImageResource(boardGame.getImageId());
        holder.name.setText(boardGame.getName());

    }

    @Override
    public int getItemCount() {
        return mLiu.size();
    }

}
