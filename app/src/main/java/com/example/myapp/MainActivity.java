package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    List<String> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            getSupportActionBar().setTitle("Welcome");
            getSupportActionBar().setSubtitle("Online");
        }
        moviesList= new ArrayList<>();
        recyclerView= findViewById(R.id.recycle_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new RecyclerAdapter(moviesList);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        moviesList.add("Avengers Assemble");
        moviesList.add("Avengers Age of Ultaron");
        moviesList.add("Avengers Infinity War");
        moviesList.add("Avengers Endgame");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if(itemId == R.id.new_folder) {
            Toast.makeText(this, "New Folder Created", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.open_opt) {
            Toast.makeText(this, "File Opened", Toast.LENGTH_SHORT).show();
        } else if(itemId == R.id.save_opt) {
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        } else {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}