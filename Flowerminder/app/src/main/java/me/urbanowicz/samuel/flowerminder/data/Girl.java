package me.urbanowicz.samuel.flowerminder.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

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

    public Girl(String name, int desiredFlowersPerMonth, int eyesColor, int hairColor) {
        this.name = name;
        this.desiredFlowersPerMonth = desiredFlowersPerMonth;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.importantAnniversariesDates = new HashMap<>();
    }

    public Map<String, Date> getImportantAnniversariesDates() {
        checkNotNull(importantAnniversariesDates);
        return importantAnniversariesDates;
    }

    public int getHairColor() {
        return hairColor;
    }

    public int getEyesColor() {
        return eyesColor;
    }

    public int getDesiredFlowersPerMonth() {
        return desiredFlowersPerMonth;
    }

    public String getName() {
        return name;
    }


    public static class Builder {
        String name;
        int desiredFlowersPerMonth;
        int eyesColor;
        int hairColor;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDesiredFlowersPerMonth(int desiredFlowersPerMonth) {
            this.desiredFlowersPerMonth = desiredFlowersPerMonth;
            return this;
        }

        public Builder withEyesColor(int eyesColor) {
            this.eyesColor = eyesColor;
            return this;
        }

        public Builder withHairColor(int hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Girl build() {
            return new Girl(
                    name,
                    desiredFlowersPerMonth,
                    eyesColor,
                    hairColor
            );

        }
    }
}
