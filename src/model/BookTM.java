package model;

public class BookTM {

    private int bid;
    private String title;
    private String type;
    private String author;
    private String publisher;

    public BookTM(int bid, String title, String type, String author, String publisher) {
        this.bid = bid;
        this.title = title;
        this.type = type;
        this.author = author;
        this.publisher = publisher;
    }

    public BookTM() {

    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookTM{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
