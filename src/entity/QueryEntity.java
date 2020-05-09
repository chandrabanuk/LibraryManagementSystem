package entity;

public class QueryEntity {

    private String bookId;
    private String title;
    private String author_name;
    private String publisherName;
    private String typeName;
    private String availability;
    private double price;

    public QueryEntity() {
    }

    public QueryEntity(String bookId, String title, String author_name, String publisherName, String availability) {
        this.bookId = bookId;
        this.title = title;
        this.author_name = author_name;
        this.publisherName = publisherName;
        this.availability = availability;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
