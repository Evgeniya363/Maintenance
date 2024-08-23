package ru.gb.maintenance.model;

import lombok.Data;


@Data
public class Person{
    private String secondName;
    private String patronymic;

//    @Override
//    public String getFullName() {
//        return secondName + " " +
//                firstName + " " +
//                patronymic;
//    }
//
//
//    @Override
//    public String getAbbreviatedName() {
//        return secondName +
//                getInitial(firstName) +
//                getInitial(patronymic);
//    }

//    private String getInitial(String name) {
//        return name.isEmpty() ? "" : " " +name.charAt(0) + ".";
//    }
}
