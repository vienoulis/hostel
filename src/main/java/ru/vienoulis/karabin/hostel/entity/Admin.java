package ru.vienoulis.karabin.hostel.entity;

import lombok.Value;

@Value
public class Admin {
    long id;
    long hostelId;
    String name;
}
