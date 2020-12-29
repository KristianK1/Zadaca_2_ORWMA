package com.example.poksuaj_lv6_201226_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameButtonClick{
    private RecyclerView recycler;
    private RecyclerAdapter Adapter;

    private EditText newNameText;
    private Button newNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();

        this.newNameText=(EditText)findViewById(R.id.etNewName);
        this.newNameButton=(Button)findViewById(R.id.bNewName);
    }
    private void setupRecycler(){
        recycler=findViewById(R.id.rvLista);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adapter= new RecyclerAdapter(this);
        recycler.setAdapter(Adapter);
    }

    private void setupRecyclerData(){
        List<String> data = new ArrayList<>();
        data.add("Kristian");
        data.add("Kristian1");
        data.add("Kristian2");
        data.add("Kristian3");
        data.add("Kristian4");
        data.add("Kristian5");
        data.add("Kristian6");
        data.add("Kristian7");
        data.add("Kristian8");
        data.add("Kristian9");
        data.add("Kristian10");
        data.add("Kristian11");
        data.add("Kristian12");
        data.add("Kristian13");

        Adapter.addData(data);
    }

    public void addCell(View view){
        Adapter.addNewCell(newNameText.getText().toString(), this.Adapter.getItemCount());
    }

    public void removeCell(int position) {
        Adapter.removeCell(position);
    }


    @Override
    public void onNameClick(int position){
        //Toast.makeText(this, "pozicija"+position, Toast.LENGTH_SHORT).show();
        removeCell(position);
    }
}