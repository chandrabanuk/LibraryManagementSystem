package entity;

public class PublisherEntity {
    private int pid;
    private String name;
    private int contact;

    public PublisherEntity() {
    }

    public PublisherEntity(String name, int contact) {
        this.name = name;
        this.contact = contact;
    }

    public PublisherEntity(int pid, String name, int contact) {
        this.pid = pid;
        this.name = name;
        this.contact = contact;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "PublisherEntity{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                '}';
    }
}
