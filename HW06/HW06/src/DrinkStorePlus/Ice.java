package DrinkStorePlus;

/*  Ice 類別 5 pt.  */
public enum Ice {
    REGULAR(10, "正常冰"),
    LITTLE(7, "少冰"),
    LESS(3, "微冰"),
    FREE(0, "去冰");

    private int level;
    private String description;
    /* 建構子 Start (5pt.) */
    Ice(int level , String description){
    	this.level = level ;
    	this.description = description;
    }
    public int getLevel() {
        return level;
    }
    /* 建構子 End (5pt.) */

    public String getDescription() {
        return description;
    }

}
