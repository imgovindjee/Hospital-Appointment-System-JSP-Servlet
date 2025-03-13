package com.entity;

public class Doctor {

    private int ID;
    private String fullName;
    private String dateOfBirth;
    private String qualification;
    private String specialist;
    private String email;
    private String phone;
    private String password;

    /**
     * {@AllArgsConstructor} diff-type
     */
    public Doctor() {
        super();
    }

    public Doctor(String fullName, String dateOfBirth, String qualification, String specialist, String email, String phone, String password) {
        super();
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.qualification = qualification;
        this.specialist = specialist;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Doctor(int ID, String fullName, String dateOfBirth, String qualification, String specialist, String email, String phone, String password) {
        super();
        this.ID = ID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.qualification = qualification;
        this.specialist = specialist;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     *
     * GETTER's AND SETTER's
     * @return OBJECT's
     */
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getSpecialist() {
        return specialist;
    }
    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
