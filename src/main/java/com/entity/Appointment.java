package com.entity;

public class Appointment {

    private int ID;
    private int userID;
    private String fullName;
    private String gender;
    private String age;
    private String appointmentDate;
    private String email;
    private String phone;
    private String disease;
    private int doctorID;
    private String address;
    private String status;

    /**
     * {@AllArgsConstructor} diff-type
     */
    public Appointment() {
        super();
    }

    public Appointment(int ID, int userID, String fullName, String gender, String age, String appointmentDate, String email, String phone, String disease, int doctorID, String address, String status) {
        super();
        this.ID = ID;
        this.userID = userID;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.appointmentDate = appointmentDate;
        this.email = email;
        this.phone = phone;
        this.disease = disease;
        this.doctorID = doctorID;
        this.address = address;
        this.status = status;
    }

    public Appointment(int userID, String fullName, String gender, String age, String appointmentDate, String email, String phone, String disease, int doctorID, String address, String status) {
        super();
        this.userID = userID;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.appointmentDate = appointmentDate;
        this.email = email;
        this.phone = phone;
        this.disease = disease;
        this.doctorID = doctorID;
        this.address = address;
        this.status = status;
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
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
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
    public String getDisease() {
        return disease;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }
    public int getDoctorID() {
        return doctorID;
    }
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
