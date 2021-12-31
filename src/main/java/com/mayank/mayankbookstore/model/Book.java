package com.mayank.mayankbookstore.model;

public class Book {
    public static final String TABLE_BOOK = "books";
    private String barcode;
    private String name;
    private String author;
    private int price;
    private int quantity;

    public static String COLUMN_NAME = "name";
    public static String COLUMN_BARCODE = "barcode";
    public static String COLUMN_AUTHOR = "author";
    public static String COLUMN_PRICE = "price";
    public static String COLUMN_QUANTITY = "quantity";

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "barcode=" + barcode +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
