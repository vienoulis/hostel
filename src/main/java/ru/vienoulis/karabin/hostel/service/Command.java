package ru.vienoulis.karabin.hostel.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);

    Action getAction();
}
