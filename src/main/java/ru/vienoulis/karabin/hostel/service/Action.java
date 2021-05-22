package ru.vienoulis.karabin.hostel.service;

import lombok.Getter;

import java.util.List;

import static ru.vienoulis.karabin.hostel.service.AccessLevel.All;

public enum Action {

    GetAllHostel (List.of(All));

    @Getter
    private final List<AccessLevel> lvl;

    Action (List<AccessLevel> lvl){

        this.lvl = lvl;
    }
}
