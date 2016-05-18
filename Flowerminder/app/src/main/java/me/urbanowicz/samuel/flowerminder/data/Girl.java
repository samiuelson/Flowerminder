package me.urbanowicz.samuel.flowerminder.data;

import java.util.Date;
import java.util.Map;

public class Girl {

    private String name;
    private int desiredFlowersPerMonth;
    private int eyesColor;
    private int hairColor;
    /**
     * Map storing important anniversaries.
     * Item key String refers to anniversary name, value is Date of the aniversary.
     */
    private Map<String, Date> importantAnniversariesDates;

}
