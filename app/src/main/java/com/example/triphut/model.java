package com.example.triphut;

public class model {

    String Cost, Brif, Duration, Hotel, Place,timage;
    public model() {
    }

    public model(String cost, String brif, String duration, String hotel, String place,String timage) {

        this.Cost = cost;
        this.Brif = brif;
        this.Duration = duration;
        this.Hotel = hotel;
        this.Place = place;
        this.timage = timage;

    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getBrif() {
        return Brif;
    }

    public void setBrif(String brif) {
        Brif = brif;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getHotel() {
        return Hotel;
    }

    public void setHotel(String hotel) {
        Hotel = hotel;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String gettimage() {
        return timage;
    }

    public void setPimage(String timage) {
        this.timage = timage;
    }
}
