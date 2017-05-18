package com.example.digdig.listviewmultipleexcomputersell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digdig.listviewmultipleexcomputersell.model.Computer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ListComputerActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
ListView listViewComputer;
Button btnBest;
ImageView imageViewpc;
TextView textdetails;

    ArrayList<Computer> listOfComputer;
    ArrayAdapter<Computer> adpaterComputer;
    int pcPicture[]={R.drawable.pc1,R.drawable.pc2,R.drawable.pc3,R.drawable.pc4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_listcomputer);
        initialize();
    }

    private void initialize() {
        listViewComputer = (ListView) findViewById(R.id.listSelected);
        listViewComputer.setOnItemClickListener(this);
        textdetails = (TextView) findViewById(R.id.textView);
        btnBest = (Button) findViewById(R.id.btnDetalis);
        btnBest.setOnClickListener(this);
       imageViewpc = (ImageView) findViewById(R.id.imageView2);

        Serializable serializable = getIntent().getSerializableExtra("Computer");
        listOfComputer =  (ArrayList<Computer>)serializable;
        adpaterComputer = new ArrayAdapter<Computer>(this,android.R.layout.simple_list_item_1,listOfComputer);
        listViewComputer.setAdapter(adpaterComputer);



    }

    @Override
    public void onClick(View v) {



        Collections.sort(listOfComputer);
        Toast.makeText(this,listOfComputer.get(0).toString(),Toast.LENGTH_LONG).show();


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long lg) {

// imageViewpc.setImageResource(pcPicture[listOfComputer.get(position).getPicture()]);
        imageViewpc.setImageResource(pcPicture[listOfComputer.get(position).getPicture()]);

      String mark = listOfComputer.get(position).getMark();
      String micro = listOfComputer.get(position).getMicroporcessor();
      String ram = listOfComputer.get(position).getRam();
      String hd = listOfComputer.get(position).getHd();
      float price = listOfComputer.get(position).getPrice();

        textdetails.setText(mark+"\n"+micro+"\n"+ram+"\n"+hd+"\n"+price);

    }



}
