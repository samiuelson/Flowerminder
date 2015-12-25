package me.urbanowicz.samuel.flowerminder.data.table;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.FlowerminderDatabase;

@ModelContainer
@Table(database = FlowerminderDatabase.class)
public class Girl extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

    List<Flower> flowers;

    @OneToMany(methods = {OneToMany.Method.SAVE, OneToMany.Method.DELETE}, variableName = "flowers")
    public List<Flower> getMyFlowers() {
        if (flowers == null) {
            flowers = SQLite.select()
                    .from(Flower.class)
                    .where(Flower_Table.girlForeignKeyContainer_id.eq(id))
                    .queryList();
        }
        return flowers;
    }

}
