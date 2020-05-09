package entity;

public class TypeEntity {

    private int tid;
    private int sid;
    private String name;

    public TypeEntity() {
    }

    public TypeEntity(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public TypeEntity(int tid, int sid, String name) {
        this.tid = tid;
        this.sid = sid;
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeEntity{" +
                "tid=" + tid +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
