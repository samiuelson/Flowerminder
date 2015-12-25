package me.urbanowicz.samuel.flowerminder.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import me.urbanowicz.samuel.flowerminder.data.FlowerminderDatabase;

@Table(database = FlowerminderDatabase.class)
public class Flower extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

    @Column
    int color;

    @Column
    long plannedDate;

    @ForeignKey(saveForeignKeyModel = false)
    ForeignKeyContainer<Girl> girlForeignKeyContainer;


    /**
     * Attach the Flower to the girl
     * @param girl loved one
     * @param date planned handing plannedDate
     */
    public void giveToGirl(Girl girl, long date) {
        girlForeignKeyContainer =
                FlowManager.getContainerAdapter(Girl.class).toForeignKeyContainer(girl);
        this.plannedDate = date;

    }
}
