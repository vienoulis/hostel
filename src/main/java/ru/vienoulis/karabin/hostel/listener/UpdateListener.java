package ru.vienoulis.karabin.hostel.listener;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UpdateListener implements MessageListener<Update> {

    @Override
    public void messageReceived(Update data) {

    }
}
