package com.appdevmhr.bangladeshswedenpolytechnic.model;

public class uploadSessionModel {
    String session,shift,department;

    public uploadSessionModel() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public uploadSessionModel(String session, String shift, String department) {
        this.session = session;
        this.shift = shift;
        this.department = department;
    }

    public uploadSessionModel(String session, String shift) {
        this.session = session;
        this.shift = shift;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
