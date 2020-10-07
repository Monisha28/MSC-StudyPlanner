package com.example.studyplanner;

public class DataHolder {
    private static DataHolder dataHolder = null;

    private DataHolder() {
    }

    public static DataHolder getInstance() {
        if (dataHolder == null) {
            dataHolder = new DataHolder();
        }
        return dataHolder;
    }

    private String item;

    public void setItem(String item) {

    }

    public String getItem() {
        return item;
    }

}