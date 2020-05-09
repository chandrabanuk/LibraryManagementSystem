package dto;

public class ReceptionistDTO {
    private int accountId;
    private String password;
    private String accountName;
    private int RID;
    private String name;
    private String NIC;
    private String Address;
    private String gender;
    private int contact;

    public ReceptionistDTO() {
    }

    public ReceptionistDTO(int accountId, String password, String accountName, int RID, String name, String NIC, String address, String gender, int contact) {
        this.accountId = accountId;
        this.password = password;
        this.accountName = accountName;
        this.RID = RID;
        this.name = name;
        this.NIC = NIC;
        Address = address;
        this.gender = gender;
        this.contact = contact;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
