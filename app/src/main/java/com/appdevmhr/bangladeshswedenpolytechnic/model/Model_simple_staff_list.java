package com.appdevmhr.bangladeshswedenpolytechnic.model;

import com.appdevmhr.bangladeshswedenpolytechnic.R;

public class Model_simple_staff_list {
    String simple_staff_list_Name, simple_staff_list_post, Imagelink, section, HomeDistrict, Education, GovtJobJoiningDate, CurrentPositionJoinningDate, CurrentInstituteJoinningDate, Mobile, Email,Password;
    int simple_staff_list_Image = R.drawable.ic_baseline_person_add_24;
    int piority = 0;
    boolean Admin;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    public Model_simple_staff_list(String simple_staff_list_Name, String simple_staff_list_post, int simple_staff_list_Image, String section, String homeDistrict, String education, String govtJobJoiningDate, String currentPositionJoinningDate, String currentInstituteJoinningDate, String mobile, String email) {
        this.simple_staff_list_Name = simple_staff_list_Name;
        this.simple_staff_list_post = simple_staff_list_post;
        this.simple_staff_list_Image = simple_staff_list_Image;
        this.section = section;
        HomeDistrict = homeDistrict;
        Education = education;
        GovtJobJoiningDate = govtJobJoiningDate;
        CurrentPositionJoinningDate = currentPositionJoinningDate;
        CurrentInstituteJoinningDate = currentInstituteJoinningDate;
        Mobile = mobile;
        Email = email;

    }

    public Model_simple_staff_list(String simple_staff_list_Name, String simple_staff_list_post, String imagelink, String section, String homeDistrict, String education, String govtJobJoiningDate, String currentPositionJoinningDate, String currentInstituteJoinningDate, String mobile, String email, int piority) {
        this.simple_staff_list_Name = simple_staff_list_Name;
        this.simple_staff_list_post = simple_staff_list_post;
        Imagelink = imagelink;
        this.section = section;
        HomeDistrict = homeDistrict;
        Education = education;
        GovtJobJoiningDate = govtJobJoiningDate;
        CurrentPositionJoinningDate = currentPositionJoinningDate;
        CurrentInstituteJoinningDate = currentInstituteJoinningDate;
        Mobile = mobile;
        Email = email;
        this.piority = piority;
    }    public Model_simple_staff_list(String simple_staff_list_Name, String simple_staff_list_post, String imagelink, String section, String homeDistrict, String education, String govtJobJoiningDate, String currentPositionJoinningDate, String currentInstituteJoinningDate, String mobile, String email, int piority ,String Password,boolean Admin) {
        this.simple_staff_list_Name = simple_staff_list_Name;
        this.simple_staff_list_post = simple_staff_list_post;
        Imagelink = imagelink;
        this.section = section;
        HomeDistrict = homeDistrict;
        Education = education;
        GovtJobJoiningDate = govtJobJoiningDate;
        CurrentPositionJoinningDate = currentPositionJoinningDate;
        CurrentInstituteJoinningDate = currentInstituteJoinningDate;
        Mobile = mobile;
        Email = email;
        this.piority = piority;
        this.Password = Password;
        this.Admin = Admin;
    }

    public Model_simple_staff_list(String simple_staff_list_Name, String simple_staff_list_post, int simple_staff_list_Image, String section, String homeDistrict, String education, String govtJobJoiningDate, String currentPositionJoinningDate, String currentInstituteJoinningDate, String mobile, String email, int piority) {
        this.simple_staff_list_Name = simple_staff_list_Name;
        this.simple_staff_list_post = simple_staff_list_post;
        this.simple_staff_list_Image = simple_staff_list_Image;
        this.section = section;
        HomeDistrict = homeDistrict;
        Education = education;
        GovtJobJoiningDate = govtJobJoiningDate;
        CurrentPositionJoinningDate = currentPositionJoinningDate;
        CurrentInstituteJoinningDate = currentInstituteJoinningDate;
        Mobile = mobile;
        Email = email;
        this.piority = piority;
    }


    public Model_simple_staff_list() {
    }

    public int getPiority() {
        return piority;
    }

    public void setPiority(int piority) {
        this.piority = piority;
    }

    public String getImagelink() {
        return Imagelink;
    }

    public void setImagelink(String imagelink) {
        Imagelink = imagelink;
    }

    public String getSimple_staff_list_Name() {
        return simple_staff_list_Name;
    }

    public void setSimple_staff_list_Name(String simple_staff_list_Name) {
        this.simple_staff_list_Name = simple_staff_list_Name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getHomeDistrict() {
        return HomeDistrict;
    }

    public void setHomeDistrict(String homeDistrict) {
        HomeDistrict = homeDistrict;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getGovtJobJoiningDate() {
        return GovtJobJoiningDate;
    }

    public void setGovtJobJoiningDate(String govtJobJoiningDate) {
        GovtJobJoiningDate = govtJobJoiningDate;
    }

    public String getCurrentPositionJoinningDate() {
        return CurrentPositionJoinningDate;
    }

    public void setCurrentPositionJoinningDate(String currentPositionJoinningDate) {
        CurrentPositionJoinningDate = currentPositionJoinningDate;
    }

    public String getCurrentInstituteJoinningDate() {
        return CurrentInstituteJoinningDate;
    }

    public void setCurrentInstituteJoinningDate(String currentInstituteJoinningDate) {
        CurrentInstituteJoinningDate = currentInstituteJoinningDate;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSimple_staff_list_post() {
        return simple_staff_list_post;
    }

    public void setSimple_staff_list_post(String simple_staff_list_post) {
        this.simple_staff_list_post = simple_staff_list_post;
    }

    public int getSimple_staff_list_Image() {
        return simple_staff_list_Image;
    }

    public void setSimple_staff_list_Image(int simple_staff_list_Image) {
        this.simple_staff_list_Image = simple_staff_list_Image;
    }
}
