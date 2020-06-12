/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.entity;

/**
 * @author doanv
 */
public class Student {
    private String tenLop;
    private String maSV;
    private String idUser;
    private String tenSV;
    private String lopCN;
    private boolean isDiemDanh;
    private String color;
    private String noteDiemDanh;

    public Student() {
    }

    public Student(String tenLop, String maSV, String idUser, String tenSV, String lopCN, boolean isDiemDanh, String color, String noteDiemDanh) {
        this.tenLop = tenLop;
        this.maSV = maSV;
        this.idUser = idUser;
        this.tenSV = tenSV;
        this.lopCN = lopCN;
        this.isDiemDanh = isDiemDanh;
        this.color = color;
        this.noteDiemDanh = noteDiemDanh;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getLopCN() {
        return lopCN;
    }

    public void setLopCN(String lopCN) {
        this.lopCN = lopCN;
    }

    public boolean isIsDiemDanh() {
        return isDiemDanh;
    }

    public void setIsDiemDanh(boolean isDiemDanh) {
        this.isDiemDanh = isDiemDanh;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNoteDiemDanh() {
        return noteDiemDanh;
    }

    public void setNoteDiemDanh(String noteDiemDanh) {
        this.noteDiemDanh = noteDiemDanh;
    }

    
}