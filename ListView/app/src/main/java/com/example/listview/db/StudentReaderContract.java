package com.example.listview.db;

import android.provider.BaseColumns;

public class StudentReaderContract {

    private StudentReaderContract(){}

    public static class StudentEntry implements BaseColumns{
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_GR = "gr";
        public static final String COLUMN_SCORE = "score";
    }

}

