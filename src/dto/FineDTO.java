package dto;

public class FineDTO {
    private int fid;
    private double amount;
    private int mid;
    private int lid;
    private String bookName;
    private int rid;

    public FineDTO(int fid, double amount, int mid, int lid, String bookName, int rid) {
        this.fid = fid;
        this.amount = amount;
        this.mid = mid;
        this.lid = lid;
        this.bookName = bookName;
        this.rid = rid;
    }

    public FineDTO() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int bid) {
        this.lid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
