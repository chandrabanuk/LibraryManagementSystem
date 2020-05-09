package entity;

import java.util.Date;

public class MemberEntity {
    private int mid;
    private String name;
    private String nic;
    private String address;
    private int contact;
    private String email;
    private Date dob;
    private String gender;
    private String memberType;

    public MemberEntity() {
    }

    public MemberEntity(String name, String nic, String address, int contact, String email, Date dob, String gender, String memberType) {
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.memberType = memberType;
    }

    public MemberEntity(int mid, String name, String nic, String address, int contact, String email, Date dob, String gender, String memberType) {
        this.mid = mid;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.memberType = memberType;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
