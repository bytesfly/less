package com.github.itwild.less.base.jvm;

public class Book {

    public static Book INSTANCE = new Book();

    public static final String DEFAULT_BOOK_NAME = "123";

    public static Author DEFAULT_AUTHOR = new Author(1L, "金庸", 30);

    public String name;

    public Author author;

    public Book() {
        this.name = DEFAULT_BOOK_NAME;
        this.author = DEFAULT_AUTHOR;
    }

    public static void main(String[] args) {
        System.out.println(Book.INSTANCE.name);

        System.out.println(Book.INSTANCE.author);

        /*Book book = new Book();
        System.out.println(book.name);
        System.out.println(book.author);*/
    }
}
