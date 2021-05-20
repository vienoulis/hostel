package ru.vienoulis.karabin.hostel.entity;

import lombok.Value;

@Value
public class User {
    long id;
    String name;
    long hostelId;
}
