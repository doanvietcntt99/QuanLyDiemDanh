/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.entity;

import java.sql.Time;

/**
 * @author doanv
 */
public class Class {
    private String color;
    private int idTrangThai;
    private String trangThai;
    private String tenLop;
    private String tenMonHoc;
    private String tenGiangVien;
    private String place;
    private Time thoiGianBatDau;
    private Time thoiGianKetThuc;
    private String loaiLich;
    private String id_atteSchedule;

    public Class(String color, int idTrangThai, String trangThai, String tenLop, String tenMonHoc, String tenGiangVien, String place, Time thoiGianBatDau, Time thoiGianKetThuc, String loaiLich, String id_atteSchedule) {
        this.color = color;
        this.idTrangThai = idTrangThai;
        this.trangThai = trangThai;
        this.tenLop = tenLop;
        this.tenMonHoc = tenMonHoc;
        this.tenGiangVien = tenGiangVien;
        this.place = place;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.loaiLich = loaiLich;
        this.id_atteSchedule = id_atteSchedule;
    }

    public Class() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Time getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Time thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Time getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Time thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getLoaiLich() {
        return loaiLich;
    }

    public void setLoaiLich(String loaiLich) {
        this.loaiLich = loaiLich;
    }

    public String getId_atteSchedule() {
        return id_atteSchedule;
    }

    public void setId_atteSchedule(String id_atteSchedule) {
        this.id_atteSchedule = id_atteSchedule;
    }

}
