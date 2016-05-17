package me.urbanowicz.samuel.flowerminder.data;

public enum FlowerColor {
    RED(0xffaa3939),
    YELLOW(0xfffff26b),
    PURPLE(0xffbc53c3),
    PINK(0xffE05EA0),
    ORANGE(0xffFFB76B),
    WHITE(0xffffffff),
    BLUE(0xff5894C2)
    ;

    private final int color;

    FlowerColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
