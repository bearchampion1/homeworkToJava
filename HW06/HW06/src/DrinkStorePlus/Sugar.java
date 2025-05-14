package DrinkStorePlus;

/*  Sugar 類別 5 pt.  */
public enum Sugar {
    REGULAR(10, "正常甜"),
    LESS(7, "少糖"),
    HALF(5, "半糖"),
    QUARTER(3, "微糖"),
    FREE(0, "無糖");

    private final int level;
    private final String description;
    /* 建構子 Start (5pt., 3) */
    Sugar(int level, String description) {
        this.level = level;
        this.description = description;
    }
    /* 建構子 End (5pt.) */

    public String getDescription() {
        return description;
    }

}