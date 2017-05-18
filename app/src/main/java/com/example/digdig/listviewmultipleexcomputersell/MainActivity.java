package com.example.digdig.listviewmultipleexcomputersell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.digdig.listviewmultipleexcomputersell.model.Computer;
import com.example.digdig.listviewmultipleexcomputersell.model.FileComputerManagement;

import java.util.ArrayList;
import java.util.logging.FileHandler;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{
ListView listViewComputer;
Button btnAddList;
ArrayList<Computer> listOfComputer;
ArrayList<Computer> listOfComputerSelected;

ArrayAdapter<Computer> adapterComputer;    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        listViewComputer = (ListView) findViewById(R.id.listViewComputer);
        btnAddList = (Button) findViewById(R.id.button);
        btnAddList.setOnClickListener(this);
        listOfComputer = FileComputerManagement.readFile(this,"computer.txt");
        adapterComputer = new ArrayAdapter<Computer>(this,android.R.layout.simple_list_item_checked,listOfComputer);
        listViewComputer.setAdapter(adapterComputer);

    }

    @Override
    public void onClick(View v) {
        SparseBooleanArray checked = listViewComputer.getCheckedItemPositions();
        StringBuilder sb =  new StringBuilder("");
       listOfComputerSelected = new ArrayList<>();
        // ArrayList<String> list = new ArrayList<String>();

        // i is the position in the cheked map
        for (int i = 0; i<checked.size();i++)
        {
            int key = checked.keyAt(i);
            if (checked.valueAt(i))
            {
                //String elements = listOfComputer.get(key).toString();
                //sb.append(elements+","+key+","+i+"\n");
              //  list.add(elements);
                listOfComputerSelected.add(listOfComputer.get(key));

            }
        }


        Intent i = new Intent(this,ListComputerActivity.class);
        i.putExtra("Computer",listOfComputerSelected);
        startActivity(i);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
