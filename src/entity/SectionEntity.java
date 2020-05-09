package entity;

public class SectionEntity {
    private int sid;
    private String description;

    public SectionEntity() {
    }

    public SectionEntity(String description) {
        this.description = description;
    }

    public SectionEntity(int sid, String description) {
        this.sid = sid;
        this.description = description;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SectionEntity{" +
                "sid=" + sid +
                ", description='" + description + '\'' +
                '}';
    }
}
