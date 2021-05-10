package ru.vienoulis.karabin.hostel.config;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;

@Slf4j
public class TBot extends TelegramLongPollingCommandBot {
    private final String username;

    private final String token;

    public TBot(String username, String token) {
        super();
        this.username = username;
        this.token = token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();
            log.info(" message {}", message);
            log.info(" chatId {}", chatId);
            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                log.warn("", e);
            }
        }
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
