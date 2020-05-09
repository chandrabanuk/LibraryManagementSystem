package model;

public class ReceptionistTM {

    private int ReceptionistId;
    private String name;
    private String NIC;
    private String Address;
    private String gender;
    private int contact;

    public ReceptionistTM(int RID, String name, String NIC, String address, String gender, int contact) {
        this.ReceptionistId = RID;
        this.name = name;
        this.NIC = NIC;
        this.Address = address;
        this.gender = gender;
        this.contact = contact;
    }

    public int getReceptionistId() {
        return ReceptionistId;
    }

    public void setReceptionistId(int receptionistId) {
        ReceptionistId = receptionistId;
    }

    public ReceptionistTM() {

    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
