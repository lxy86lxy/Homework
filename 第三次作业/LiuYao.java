package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LiuYao extends AppCompatActivity {
    private List<BoardGame> boardGameList=new ArrayList<>();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycle_liu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.pu:
                Toast.makeText(this,"瀑布式输出",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LiuYao.this,PuBuRecycler.class);
                item.setIntent(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liu_yao);
        fun();
        RecyclerView recyclerView=findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        LiuAdapter liuAdapter=new LiuAdapter(boardGameList);
        recyclerView.setAdapter(liuAdapter);

    }



    private void fun(){
        for (int i = 0; i < 2; i++) {
            BoardGame xiangQi=new BoardGame("吻文",R.drawable.w1);
            boardGameList.add(xiangQi);
            BoardGame weiQi=new BoardGame("小丸子",R.drawable.w2);
            boardGameList.add(weiQi);
            BoardGame douSouQi=new BoardGame("狼王",R.drawable.w3);
            boardGameList.add(douSouQi);
            BoardGame douSouQi1=new BoardGame("西南最帅初中生",R.drawable.w4);
            boardGameList.add(douSouQi1);
            BoardGame douSouQi2=new BoardGame("大帅哥",R.drawable.w5);
            boardGameList.add(douSouQi2);
            BoardGame douSouQi3=new BoardGame("刘耀文",R.drawable.w6);
            boardGameList.add(douSouQi3);
            BoardGame douSouQi4=new BoardGame("宝贝儿",R.drawable.w7);
            boardGameList.add(douSouQi4);
            BoardGame douSouQi5=new BoardGame("刘大帅哥",R.drawable.w8);
            boardGameList.add(douSouQi5);
            BoardGame douSouQi6=new BoardGame("最爱的崽儿",R.drawable.w9);
            boardGameList.add(douSouQi6);
            BoardGame douSouQi7=new BoardGame("帅气弟弟",R.drawable.w10);
            boardGameList.add(douSouQi7);
            BoardGame douSouQi8=new BoardGame("西南最帅小学生",R.drawable.w11);
            boardGameList.add(douSouQi8);
        }
    }
}