package DrinkStorePlus;

import java.util.Scanner;
import java.util.regex.Pattern;

/*  Store 總共 65 pt.  */
public class Store {
    // 5 個空位的購物車
    static Item[] cart = new Item[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        int cartSpace = cart.length; // 初始的購物車空間/容量，不可寫死 5

        while (true) {
            System.out.println("\n＊＊＊＊＊＊＊＊ 歡迎來到大台科飲料店 ＊＊＊＊＊＊＊＊");
            System.out.println("(1) 點餐\n(2) 查看購物車\n(0) 結帳並退出系統");
            System.out.print("請選擇功能 [0,1,2]：");

            String input = scanner.next();
            if (input.equals("0")) { break; }
            if (!isNumberOptionInRange(input, 0, 2)) continue;

            int selected = Integer.parseInt(input);
            switch (selected) {
                case 1:
                    // 如果購物車滿了就跳出去
                    if (cartSpace <= 0) {
                        System.out.println("\n購物車已滿，請先結帳！");
                        continue;
                    }

                    Item item = new Item();

                    // 1. 選擇飲料編號
                    showMenu();
                    System.out.print("請選擇飲料編號：");
                    input = scanner.next();
                    if (!isNumberOptionInRange(input, 1, Drink.values().length)) {
                        System.out.println("飲料編號輸入錯誤！");
                        continue;
                    }
                    item.setDrink(Drink.values()[Integer.parseInt(input) - 1]);

                    // 2. 選擇飲料冰塊
                    item.setIce(selectIce(scanner));

                    // 3. 選擇飲料甜度
                    item.setSugar(selectSugar(scanner));

                    // 4. 選擇飲料數量
                    while (true) {
                        System.out.print("\n請輸入數量：");
                        input = scanner.next();
                        if (!isNumberOptionInRange(input, 1)) {
                            System.out.println("數量必須大於 0！");
                            continue;
                        }
                        item.setQuantity(Integer.parseInt(input));
                        break;
                    }

                    // 把 item 物件存入 cart 陣列中
                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i] == null) {
                            cart[i] = item;
                            break;
                        }
                    }

                    System.out.printf("已將 %d 杯 %s 加入購物車\n", item.getQuantity(), item.getName());

                    // 計算目前購物車的總價格 (total)、適當調整 cartSpace 變數
                    total += item.getTotalPrice();
                    cartSpace--;
                    break;

                case 2:
                    showCart();
                    break;

                default:
                    System.out.println("無此選項！！\n");
                    scanner.nextLine();
            }
        }
        System.out.printf("\n\n謝謝光臨，一共是：%d 元\n", total);
    }

    private static void showMenu() {
        System.out.println("\n＊＊＊＊＊＊＊＊ 菜單 ＊＊＊＊＊＊＊＊");
        System.out.printf("%s\t\t%s\t\t%s\n", "編號", "品名", "價格");
        // 顯示菜單內容
        Drink[] drinks = Drink.values();
        for (int i = 0; i < drinks.length; i++) {
            System.out.printf("%d\t\t%s\t\t$%d\n", i + 1, drinks[i].getName(), drinks[i].getPrice());
        }
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
    }

    private static void showCart() {
        System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n", "品名", "冰量", "甜度", "數量", "單價", "總價");
        for (Item item : cart) {
            if (item != null) {
                System.out.print(item.toString());
            }
        }
    }

    private static Ice selectIce(Scanner input) {
        while (true) {
            System.out.println("\n(1)正常冰 (2)少冰 (3)微冰 (4)去冰");
            System.out.print("請選擇飲料冰量 [1,2,3,4]：");
            String choice = input.next();
            switch (choice) {
                case "1": return Ice.REGULAR;
                case "2": return Ice.LITTLE;
                case "3": return Ice.LESS;
                case "4": return Ice.FREE;
                default:
                    System.out.println("冰量選擇錯誤，請重新輸入！");
            }
        }
    }

    private static Sugar selectSugar(Scanner input) {
        while (true) {
            System.out.println("\n(1)正常糖 (2)少糖 (3)半糖 (4)微糖 (5)無糖");
            System.out.print("請選擇飲料甜度 [1,2,3,4,5]：");
            String choice = input.next();
            switch (choice) {
                case "1": return Sugar.REGULAR;
                case "2": return Sugar.LESS;
                case "3": return Sugar.HALF;
                case "4": return Sugar.QUARTER;
                case "5": return Sugar.FREE;
                default:
                    System.out.println("甜度選擇錯誤，請重新輸入！");
            }
        }
    }

    // 判斷輸入的文字是否在選項範圍內，有最大最小值
    public static boolean isNumberOptionInRange(String str, int min, int max) {
        boolean isNumber = Pattern.compile("^-?\\d*$").matcher(str).find();
        if (!isNumber) {
            System.out.println("僅限輸入數字！\n");
            return false;
        }
        if (Integer.parseInt(str) < min || Integer.parseInt(str) > max) {
            System.out.println("輸入錯誤！");
            return false;
        }
        return true;
    }

    // 判斷輸入的文字是否在選項範圍內，只限制最小值
    public static boolean isNumberOptionInRange(String str, int min) {
        boolean isNumber = Pattern.compile("^-?\\d*$").matcher(str).find();
        if (!isNumber) {
            System.out.println("僅限輸入數字！\n");
            return false;
        }
        if (Integer.parseInt(str) < min) {
            System.out.println("\n輸入錯誤！\n");
            return false;
        }
        return true;
    }
}
