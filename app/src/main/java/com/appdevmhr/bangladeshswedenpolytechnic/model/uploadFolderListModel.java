package com.appdevmhr.bangladeshswedenpolytechnic.model;

public class uploadFolderListModel {

    String FolderName,Date;

    public uploadFolderListModel() {
    }

    public uploadFolderListModel(String folderName, String date) {
        FolderName = folderName;
        Date = date;
    }

    public String getFolderName() {
        return FolderName;
    }

    public void setFolderName(String folderName) {
        FolderName = folderName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
