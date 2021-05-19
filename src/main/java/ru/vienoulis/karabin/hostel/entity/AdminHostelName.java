package ru.vienoulis.karabin.hostel.entity;

import lombok.Value;

@Value
public class AdminHostelName {
    String name;
    String localName;

    @Override
    public String toString(){
        return String.format("Администратор %s работает в хостеле %s", name, localName);
    }
}
