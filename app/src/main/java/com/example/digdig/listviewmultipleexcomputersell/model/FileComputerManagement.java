package com.example.digdig.listviewmultipleexcomputersell.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by digdig on 17-05-17.
 */

public class FileComputerManagement {
    public static ArrayList<Computer> readFile(Context context, String fileName)
    {
        ArrayList<Computer> listOfComputer =  new ArrayList<Computer>();
        AssetManager assetManager = context.getResources().getAssets();
        try
        {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br =  new BufferedReader(isr);
            String online;
            while ((online=br.readLine())!=null)
            {
                StringTokenizer st =  new StringTokenizer(online,",");
                int pcpicture = Integer.valueOf(st.nextToken());
                String pcMark = st.nextToken();
                String pcProcess = st.nextToken();
                String pcRam = st.nextToken();
                String pcHD = st.nextToken();
                float pcPrice = Float.valueOf(st.nextToken());
                Computer computer = new Computer(pcpicture,pcMark,pcProcess,pcRam,pcHD,pcPrice);
                listOfComputer.add(computer);
            }
            br.close();
            isr.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();;
        }
        return listOfComputer;
    }

}
