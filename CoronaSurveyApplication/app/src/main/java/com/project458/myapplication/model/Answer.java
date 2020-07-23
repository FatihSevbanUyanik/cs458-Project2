package com.project458.myapplication.model;

import java.util.Map;

public class Answer {

    private String nameSurname;
    private String birthDate;
    private String city;
    private String gender;
    private String text;

    public Answer() {}

    public Answer(Map<String, Object> map) {
        this.nameSurname = (String) map.get("nameSurname");
        this.birthDate =  (String) map.get("birthDate");
        this.gender = (String) map.get("gender");
        this.city = (String) map.get("city");
        this.text = (String) map.get("text");
    }

    public Answer(String nameSurname, String birthDate, String city, String gender, String text) {
        this.nameSurname = nameSurname;
        this.birthDate = birthDate;
        this.city = city;
        this.gender = gender;
        this.text = text;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "nameSurname='" + nameSurname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
