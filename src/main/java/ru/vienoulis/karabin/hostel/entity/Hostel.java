package ru.vienoulis.karabin.hostel.entity;

import lombok.Value;

@Value
public class Hostel {
    long id;
    String name;
    int capacity;
    String localName;

    @Override
    public String toString(){
        return String.format("Хостел %s вместимость: %d;", localName, capacity);
    }
}
