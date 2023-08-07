package com.example.ThymeleafDemo.models;



import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Hocsinhs")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocsinhid")
    private int id;
    @Column(name = "tenhocsinh")
    private String tenHocSinh;

    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }





}
