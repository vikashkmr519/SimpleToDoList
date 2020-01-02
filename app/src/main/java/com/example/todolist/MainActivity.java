package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.LinearSystem;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etText;
    Button addButton;
    ListView lvItem;

    ArrayList<String> itemList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        addButton = findViewById(R.id.addButton);
        lvItem = findViewById(R.id.lvItem);
        lvItem.setAdapter(arrayAdapter);

        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String getInput = etText.getText().toString();
        if(itemList.contains(getInput)){
            Toast.makeText(this, "Item already Exists", Toast.LENGTH_SHORT).show();
        }else if(getInput == null || getInput.trim().equals("")){
            Toast.makeText(this, "Input Field is Empty", Toast.LENGTH_SHORT).show();
        }else{
            itemList.add(getInput);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemList);
            lvItem.setAdapter(adapter);
            ((EditText)findViewById(R.id.etText)).setText(" ");
        }

    }


}
