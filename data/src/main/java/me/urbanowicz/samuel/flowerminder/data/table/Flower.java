package me.urbanowicz.samuel.flowerminder.data.table;

import android.support.annotation.ColorInt;

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
    @ColorInt
    int color;

    @Column
    long plannedDate;

    @ForeignKey(saveForeignKeyModel = false)
    ForeignKeyContainer<Girl> girlForeignKeyContainer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @ColorInt  int getColor() {
        return color;
    }

    public void setColor(@ColorInt int color) {
        this.color = color;
    }

    public long getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(long plannedDate) {
        this.plannedDate = plannedDate;
    }

    /**
     * Attach the FlowerEntity row to the girl
     * @param girl loved one
     * @param date planned handing plannedDate
     */
    public void giveToGirl(Girl girl, long date) {
        girlForeignKeyContainer =
                FlowManager.getContainerAdapter(Girl.class).toForeignKeyContainer(girl);
        this.plannedDate = date;
    }
}
