package com.daotrung.bai3_buoi4;

public class MyFolder {
    int imgFile ;
    String txtTitle ;
    int imgEdit;
    int imgRemove;

    public MyFolder(int imgFile, String txtTitle, int imgEdit, int imgRemove) {
        this.imgFile = imgFile;
        this.txtTitle = txtTitle;
        this.imgEdit = imgEdit;
        this.imgRemove = imgRemove;
    }

    public int getImgFile() {
        return imgFile;
    }

    public void setImgFile(int imgFile) {
        this.imgFile = imgFile;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public int getImgEdit() {
        return imgEdit;
    }

    public void setImgEdit(int imgEdit) {
        this.imgEdit = imgEdit;
    }

    public int getImgRemove() {
        return imgRemove;
    }

    public void setImgRemove(int imgRemove) {
        this.imgRemove = imgRemove;
    }
}
