package com.example.bookslisttask;

public class BooksModel {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookpath() {
        return Bookpath;
    }

    public void setBookpath(String bookpath) {
        Bookpath = bookpath;
    }

    public String getBooklink() {
        return booklink;
    }

    public void setBooklink(String booklink) {
        this.booklink = booklink;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    private String id="";
    private String Bookpath="";
    private String booklink="";
    private String booktitle="";
    private String bookauthor="";



    public BooksModel(String id, String Bookpath, String booklink, String booktitle, String bookauthor) {
        this.id = id;
        this.Bookpath = Bookpath;
        this.booklink = booklink;
        this.booktitle = booktitle;
        this.bookauthor = bookauthor;

    }


}
