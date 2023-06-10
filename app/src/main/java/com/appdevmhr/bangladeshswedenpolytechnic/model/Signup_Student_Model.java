package com.appdevmhr.bangladeshswedenpolytechnic.model;

public class Signup_Student_Model {
    String Photo,Name,Roll,Registration,HomeDistrict,StudentMobileNumber,
            GordianName,GordianMobileNumber,Email_address,Password,Session,Shift,Department;

    public Signup_Student_Model() {
    }

    public Signup_Student_Model(String photo, String name, String roll, String registration, String homeDistrict, String studentMobileNumber, String gordianName, String gordianMobileNumber, String email_address, String password, String session, String shift, String department) {
        Photo = photo;
        Name = name;
        Roll = roll;
        Registration = registration;
        HomeDistrict = homeDistrict;
        StudentMobileNumber = studentMobileNumber;
        GordianName = gordianName;
        GordianMobileNumber = gordianMobileNumber;
        Email_address = email_address;
        Password = password;
        Session = session;
        Shift = shift;
        Department = department;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getRegistration() {
        return Registration;
    }

    public void setRegistration(String registration) {
        Registration = registration;
    }

    public String getHomeDistrict() {
        return HomeDistrict;
    }

    public void setHomeDistrict(String homeDistrict) {
        HomeDistrict = homeDistrict;
    }

    public String getStudentMobileNumber() {
        return StudentMobileNumber;
    }

    public void setStudentMobileNumber(String studentMobileNumber) {
        StudentMobileNumber = studentMobileNumber;
    }

    public String getGordianName() {
        return GordianName;
    }

    public void setGordianName(String gordianName) {
        GordianName = gordianName;
    }

    public String getGordianMobileNumber() {
        return GordianMobileNumber;
    }

    public void setGordianMobileNumber(String gordianMobileNumber) {
        GordianMobileNumber = gordianMobileNumber;
    }

    public String getEmail_address() {
        return Email_address;
    }

    public void setEmail_address(String email_address) {
        Email_address = email_address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSession() {
        return Session;
    }

    public void setSession(String session) {
        Session = session;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String shift) {
        Shift = shift;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
