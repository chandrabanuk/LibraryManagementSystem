package entity;

public class ReceptionistEntity {
    private int rid;
    private String name;
    private String nic;
    private String address;
    private int contact;
    private String gender;
    private int accountId;

    public ReceptionistEntity() {
    }

    public ReceptionistEntity(int rid, String name, String nic, String address, int contact, String gender, int accountId) {
        this.rid = rid;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.accountId = accountId;
    }

    public ReceptionistEntity(int rid, String name, String nic, String address, String gender, int contact) {
        this.rid = rid;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
    }


    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "ReceptionistEntity{" +
                "rid=" + rid +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", gender='" + gender + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
