package me.urbanowicz.samuel.flowerminder.data;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.table.Flower;
import me.urbanowicz.samuel.flowerminder.data.table.Flower_Table;
import me.urbanowicz.samuel.flowerminder.domain.entity.FlowerEntity;


public class FlowerDataSource implements EntityDataSource<FlowerEntity> {

    @Override
    public void saveEntities(List<FlowerEntity> flowerEntities) {
        for (FlowerEntity flowerEntity : flowerEntities) {
            Flower flower = flowerEntityToFlowerRow(flowerEntity);
            flower.save();
        }
    }

    @Override
    public long saveEntity(FlowerEntity flowerEntity) {
        Flower flower = flowerEntityToFlowerRow(flowerEntity);
        flower.save();
        return flower.getId();
    }

    public void delete(FlowerEntity flowerEntity) {
        SQLite.delete()
                .from(Flower.class)
                .where(Flower_Table.id.eq(flowerEntity.getId())).queryClose(); // FIXME: 03.01.2016 deletion without result
    }

    @Override
    public List<FlowerEntity> getEntities() {
        List<Flower> flowerRows = SQLite.select()
                .from(Flower.class)
                .queryList();
        return flowerRowsToFlowerEntities(flowerRows);
    }

    private static List<FlowerEntity> flowerRowsToFlowerEntities(List<Flower> flowerRows) {
        List<FlowerEntity> flowerEntities = new ArrayList<>();
        for (Flower flowerRow : flowerRows) {
            flowerEntities.add(flowerRowToFlower(flowerRow));
        }
        return flowerEntities;
    }

    private static FlowerEntity flowerRowToFlower(Flower flower) {
        FlowerEntity flowerEntity = new FlowerEntity();
        flowerEntity.setId(flower.getId());
        flowerEntity.setColor(flower.getColor());
        flowerEntity.setName(flower.getName());
        flowerEntity.setPlannedDate(flower.getPlannedDate());
        return flowerEntity;
    }

    private static Flower flowerEntityToFlowerRow(FlowerEntity flowerEntity) {
        final Flower flower;
        List<Flower> flowers = SQLite.select()
                .from(Flower.class)
                .where(Flower_Table.id.eq(flowerEntity.getId()))
                .queryList();

        if (flowers.size() > 0) {
            flower = flowers.get(0);
        } else {
            flower = new Flower();
        }
        flower.setPlannedDate(flowerEntity.getPlannedDate());
        flower.setName(flowerEntity.getName());
        flower.setColor(flowerEntity.getColor());
        return flower;
    }
}
