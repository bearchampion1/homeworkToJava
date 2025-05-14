package lesson4;

public class BookTest {

	ublic static void main(String[] args) {
        System.out.println("-------- Book 1 --------");
        int pageNum = (int) (Math.random() * 500 + 100);
        Book book1 = new Book("可愛巧虎島", "王大智", Book.BOOK_CLASS.COMIC_BOOK, pageNum, 90);
        book1.show();

        System.out.println("-------- Book 2 --------");
        Book book2 = new Book("時尚人生", "李雅惠", Book.BOOK_CLASS.MAGAZINE, 380);
        book2.show();

        System.out.println("-------- Book 3 --------");
        pageNum = (int) (Math.random() * 500 + 100);
        Book book3 = new Book("統計學與世界觀", "羊為你", pageNum, 920);
        book3.show();

        System.out.println("-------- Book 4 --------");
        Book book4 = new Book("占卜人生", "崔老尼", 400);
        book4.show();
    }

}
