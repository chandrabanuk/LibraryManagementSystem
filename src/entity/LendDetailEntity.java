package entity;

import java.util.Date;

public class LendDetailEntity {
    private int lid;
    private int mid;
    private int bid;
    private Date issueDate;
    private Date returnDate;
    private Date dueDate;

    public LendDetailEntity() {
    }

    public LendDetailEntity(int mid, int bid, Date issueDate, Date returnDate, Date dueDate) {
        this.mid = mid;
        this.bid = bid;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
    }

    public LendDetailEntity(int lid, int mid, int bid, Date issueDate, Date returnDate, Date dueDate) {
        this.lid = lid;
        this.mid = mid;
        this.bid = bid;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "LendDetailEntity{" +
                "lid=" + lid +
                ", mid=" + mid +
                ", bid=" + bid +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
