package entity;

public class ReceptionistDetailEntity {
    private int rid;
    private String Receptionistname;
    private String nic;
    private String address;
    private int contact;
    private String gender;
    private String password;
    private int account_id;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public ReceptionistDetailEntity(int rid, String receptionistname, String nic, String address, int contact, String gender, String password) {
        this.rid = rid;
        Receptionistname = receptionistname;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.password = password;
    }

    public ReceptionistDetailEntity() {

    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getReceptionistname() {
        return Receptionistname;
    }

    public void setReceptionistname(String receptionistname) {
        Receptionistname = receptionistname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
