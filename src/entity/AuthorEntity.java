package entity;

public class AuthorEntity {
    private int aid;
    private String name;

    public AuthorEntity() {
    }

    public AuthorEntity(String name) {
        this.name = name;
    }

    public AuthorEntity(int aid, String name) {
        this.aid = aid;
        this.name = name;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                '}';
    }
}
