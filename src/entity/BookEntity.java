package entity;

public class BookEntity {
    private int bid;
    private double price;
    private String title;
    private int aid;
    private int tid;
    private int pid;

    public BookEntity() {
    }

    public BookEntity(double price, String title, int aid, int tid, int pid) {
        this.price = price;
        this.title = title;
        this.aid = aid;
        this.tid = tid;
        this.pid = pid;
    }

    public BookEntity(int bid, double price, String title, int aid, int tid, int pid) {
        this.bid = bid;
        this.price = price;
        this.title = title;
        this.aid = aid;
        this.tid = tid;
        this.pid = pid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bid=" + bid +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", aid=" + aid +
                ", tid=" + tid +
                ", pid=" + pid +
                '}';
    }
}
