package com.entity;

public class Specialist {

    private int ID;
    private String specialistName;

    /**
     * {@AllArgsConstructor} diff-type
     */
    public Specialist() {
        super();
    }

    public Specialist(int ID, String specialistName) {
        super();
        this.ID = ID;
        this.specialistName = specialistName;
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
    public String getSpecialistName() {
        return specialistName;
    }
    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }
}
