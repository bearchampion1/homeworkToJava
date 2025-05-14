package lesson4;

ublic class Book {

    public enum BOOK_CLASS {LITERATURE, MAGAZINE, COMIC_BOOK, COOKBOOK, OTHER}

    private String name;
    private String author;
    private BOOK_CLASS bookClass;
    private int pageNumber;
    private int price; // 必填

    // 只輸入 name, author, price
    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.bookClass = BOOK_CLASS.OTHER;
        this.pageNumber = 0;
        this.price = price;
    }

    // 只輸入 name, author, bookClass, price
    public Book(String name, String author, BOOK_CLASS bookClass, int price) {
        this.name = name;
        this.author = author;
        this.bookClass = bookClass;
        this.pageNumber = 0;
        this.price = price;
    }
}
