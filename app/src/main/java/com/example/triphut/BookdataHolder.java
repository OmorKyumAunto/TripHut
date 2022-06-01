package com.example.triphut;

public class BookdataHolder {
    String name,phone,total,status;

    public BookdataHolder(String name, String phone, String total) {
        this.name = name;
        this.phone = phone;
        this.total = total;
        this.status="0";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
