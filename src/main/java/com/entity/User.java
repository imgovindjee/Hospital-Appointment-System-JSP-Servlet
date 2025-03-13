package com.entity;

public class User {

    private int ID;
    private String fullName;
    private String email;
    private String password;

    /**
     * {@AllArgsConstructor} diff-type
     */
    public User() {
        super();
    }

    public User(int ID, String fullName, String email, String password) {
        super();
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User(String fullName, String email, String password) {
        super();
        this.fullName = fullName;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [ID=" +ID+ ", fullName=" +fullName+ ", email=" +email+ ", password="+password+"]";
    }
}
