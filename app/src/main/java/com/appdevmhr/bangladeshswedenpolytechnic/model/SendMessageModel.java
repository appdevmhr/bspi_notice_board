package com.appdevmhr.bangladeshswedenpolytechnic.model;

public class SendMessageModel {
    String photo,sms,department,session,shift;
    Long timestamp;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public SendMessageModel(String photo, String sms, String department, String session, String shift) {
        this.photo = photo;
        this.sms = sms;
        this.department = department;
        this.session = session;
        this.shift = shift;
    }

    public SendMessageModel(String sms, String department, String session, String shift) {
        this.sms = sms;
        this.department = department;
        this.session = session;
        this.shift = shift;
    }

    public SendMessageModel(Long timestamp) {
        this.timestamp = timestamp;
    }

    public SendMessageModel() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
