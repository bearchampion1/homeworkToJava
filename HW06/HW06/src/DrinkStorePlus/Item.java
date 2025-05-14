package DrinkStorePlus;

/*  Item 總共 20 pt.  */
public class Item {
    private Drink drink;
    private int quantity;
    private Ice ice;
    private Sugar sugar;

    public Item(Drink drink, int quantity, Ice ice, Sugar sugar) {
        this.drink = drink;
        this.quantity = quantity;
        this.ice = ice;
        this.sugar = sugar;
    }

    public Item() { }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIce(Ice ice) {
        this.ice = ice;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    /*  5pt.  */
    public String getName() {
        /*  取得品名 (5pt.)  */
        return drink.getName();
    }
    public int getQuantity() {
        return quantity;
    }
    /*  5pt.  */
    public int getPrice() {
        /*  取得此品項的單價 (5pt.)  */
        return drink.getPrice();
        }
    /*  5pt.  */
    public int getTotalPrice() {
        /*  取得此品項的總價 (5pt.)  */
        return quantity*drink.getPrice();
        }

    /*  5pt.  */
    @Override
    public String toString() {
        return String.format("%-4s\t\t%-3s\t\t%-3s\t\t%-2s\t\t$%2s\t\t$%2s\n",getName() , ice.getDescription() , sugar.getDescription(),quantity , getPrice()  , getTotalPrice() /* 顯示商品資訊 (5pt.) */);
    }
}
