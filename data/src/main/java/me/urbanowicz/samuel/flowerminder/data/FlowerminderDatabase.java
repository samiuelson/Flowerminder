package me.urbanowicz.samuel.flowerminder.data;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = FlowerminderDatabase.NAME, version = FlowerminderDatabase.VERSION)
public class FlowerminderDatabase {
    public final static String NAME = "flowerminder_db";
    public final static int VERSION = 1;
}
