package me.urbanowicz.samuel.flowerminder.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import me.urbanowicz.samuel.flowerminder.data.FlowerminderDatabase;

@Table(database = FlowerminderDatabase.class)
public class User extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Girl girl;

}
