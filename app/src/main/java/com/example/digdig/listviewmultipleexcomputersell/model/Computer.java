package com.example.digdig.listviewmultipleexcomputersell.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by digdig on 17-05-17.
 */

public class Computer implements Serializable,Comparable<Computer> {
    private int picture;
    private String mark;
    private String microporcessor;
    private String ram;
    private String hd;
    private float price;

    public Computer(int picture, String mark, String microporcessor, String ram, String hd, float price) {
        this.picture = picture;
        this.mark = mark;
        this.microporcessor = microporcessor;
        this.ram = ram;
        this.hd = hd;
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMicroporcessor() {
        return microporcessor;
    }

    public void setMicroporcessor(String microporcessor) {
        this.microporcessor = microporcessor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        //return "Mark: " + getMark()+"\nMicroprocessor " + getMicroporcessor() + "\nRam :"+getRam()+"\nHd :"+getHd()+ "\nPrice ;"+getPrice();
        return "Mark: " + getMark()+" ("+getPrice()+")";

    }



    @Override
    public int compareTo(@NonNull Computer o) {
        if (this.getPrice() > o.getPrice())
        {
            return 1;
        }
        else if (this.getPrice()<o.getPrice())
        {
            return  -1;
        } else
            return 0;

    }
}
