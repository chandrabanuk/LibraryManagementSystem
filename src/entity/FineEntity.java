package entity;

public class FineEntity {

    private int fid;
    private double amount;
    private int lid;
    private int rid;

    public FineEntity() {
    }

    public FineEntity(double amount, int lid, int rid) {
        this.amount = amount;
        this.lid = lid;
        this.rid = rid;
    }

    public FineEntity(int fid, double amount, int lid, int rid) {
        this.fid = fid;
        this.amount = amount;
        this.lid = lid;
        this.rid = rid;
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

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "FineEntity{" +
                "fid=" + fid +
                ", amount=" + amount +
                ", lid=" + lid +
                ", rid=" + rid +
                '}';
    }
}
