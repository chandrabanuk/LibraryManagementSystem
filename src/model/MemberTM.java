package model;

import java.util.Date;

public class MemberTM {

    private int mid;
    private String name;
    private String nic;
    private String address;
    private String gender;
    private int contact;
    private String email;
    private String occupation;
    private Date dob;


    public MemberTM(int mid, String name, String nic, String address, String gender, int contact, String email, String occupation, Date dob) {
        this.mid = mid;
        this.nic = nic;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.occupation = occupation;
        this.dob = dob;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "MemberTM{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", occupation='" + occupation + '\'' +
                ", dob=" + dob +
                '}';
    }
}
