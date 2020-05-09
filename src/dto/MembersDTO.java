package dto;

import java.util.Date;

public class MembersDTO {

    private int mid;
    private String Name;
    private String nic;
    private String address;
    private int contact;
    private String email;
    private Date dob;
    private String gender;
    private String occupation;

    public MembersDTO() {
    }

    public MembersDTO(String name, String nic, String address, int contact, String email, Date dob, String gender, String occupation) {
        Name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.occupation = occupation;
    }

    public MembersDTO(int mid, String name, String nic, String address, int contact, String email, Date dob, String gender, String occupation) {
        this.mid = mid;
        Name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.occupation = occupation;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "MembersDTO{" +
                "mid=" + mid +
                ", Name='" + Name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }

}
