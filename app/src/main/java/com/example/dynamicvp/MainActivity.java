package com.example.dynamicvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //TODO:인디케이터 추가해보기, 생각해본 예제 구현하기
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private ArrayList<String> tar;
    private TextAdapter adapter;
    private int pageLength=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit=findViewById(R.id.edit);
        findViewById(R.id.main_btn).setOnClickListener(v -> {
                pageLength=Integer.parseInt(edit.getText().toString());
            Log.e("pl",pageLength+"");
            tar=new ArrayList<>();
            for(int i=0;i<pageLength;){
                tar.add("Hello this page is "+(++i));
            }
            recyclerView=findViewById(R.id.main_rec);
            manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            adapter=new TextAdapter(tar,pageLength);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            SnapHelper helper = new PagerSnapHelper();
            helper.attachToRecyclerView(recyclerView);

        });

    }


}