package com.example.IT.Nico.TelBot.model;

import lombok.Data;

import java.util.Date;

@Data
public class CurrencyModel {
    Integer cur_ID;
    Date date;
    String cur_Abbreviation;
    Integer cur_Scale;
    String cur_Name;
    Double cur_TelBot;
}