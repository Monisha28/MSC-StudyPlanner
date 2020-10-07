package com.example.studyplanner.ui.dashboard;
import com.google.firebase.database.IgnoreExtraProperties;
public class Student {

        private String subName;
        private int progress;
        private String unit;
        private String test;
        private String date;
        public Student() {
        }
        public Student(String subName, String unit,String test, String date, int progress) {
            this.subName = subName;
            this.unit = unit;
            this.test = test;
            this.date = date;
            this.progress = progress;
        }

//        public void changeText1(String text) {
//            SubName = text;
//        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUnit() { return unit; }

        public int getProgress() {
        return progress;
    }
    }
