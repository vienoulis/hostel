package ru.vienoulis.karabin.hostel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class MessageService {

    @Autowired
    public MessageService() {
    }

    public SendMessage processMessage(Update update) {
        log.info("Prepare message from TBot");
        String message = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();
        log.info(" get message {}, from chatId {}", message, chatId);
        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText(message);
        return sm;
    }
}
