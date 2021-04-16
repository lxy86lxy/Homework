package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuBuRecycler extends AppCompatActivity {


    private List<BoardGame> boardGameList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_bu_recycler);
        fun();
        RecyclerView recyclerView=findViewById(R.id.recycle_view1);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        PuAdapter liuAdapter=new PuAdapter(boardGameList);
        recyclerView.setAdapter(liuAdapter);

    }



    private void fun(){
        for (int i = 0; i <3; i++) {
            BoardGame xiangQi=new BoardGame(fen("吻文"),R.drawable.w1);
            boardGameList.add(xiangQi);
            BoardGame weiQi=new BoardGame(fen("小丸子"),R.drawable.w2);
            boardGameList.add(weiQi);
            BoardGame douSouQi=new BoardGame(fen("狼王"),R.drawable.w3);
            boardGameList.add(douSouQi);
            BoardGame douSouQi1=new BoardGame(fen("西南最帅初中生"),R.drawable.w4);
            boardGameList.add(douSouQi1);
            BoardGame douSouQi2=new BoardGame(fen("大帅哥"),R.drawable.w5);
            boardGameList.add(douSouQi2);
            BoardGame douSouQi3=new BoardGame(fen("刘耀文"),R.drawable.w6);
            boardGameList.add(douSouQi3);
            BoardGame douSouQi4=new BoardGame(fen("宝贝儿"),R.drawable.w7);
            boardGameList.add(douSouQi4);
            BoardGame douSouQi5=new BoardGame(fen("刘大帅哥"),R.drawable.w8);
            boardGameList.add(douSouQi5);
            BoardGame douSouQi6=new BoardGame(fen("最爱的崽儿"),R.drawable.w9);
            boardGameList.add(douSouQi6);
            BoardGame douSouQi7=new BoardGame(fen("帅气弟弟"),R.drawable.w10);
            boardGameList.add(douSouQi7);
            BoardGame douSouQi8=new BoardGame(fen("西南最帅小学生"),R.drawable.w11);
            boardGameList.add(douSouQi8);
        }
    }
    private String fen(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

}