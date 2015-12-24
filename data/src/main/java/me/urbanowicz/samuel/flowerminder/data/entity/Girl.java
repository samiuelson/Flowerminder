package me.urbanowicz.samuel.flowerminder.data.entity;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import me.urbanowicz.samuel.flowerminder.data.FlowerminderDatabase;

@Table(database = FlowerminderDatabase.class)
public class Girl {
    @PrimaryKey(autoincrement = true)
    long id;
}
