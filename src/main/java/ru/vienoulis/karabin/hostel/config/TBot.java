package ru.vienoulis.karabin.hostel.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.vienoulis.karabin.hostel.service.MessageService;


@Slf4j
@Component
@PropertySource("application.properties")
public class TBot extends TelegramLongPollingCommandBot {
    private final MessageService messageService;


    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    @Autowired
    public TBot(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            log.info("Start process new message. Update id - {}", update.getUpdateId());
            executeMessage(messageService.processMessage(update));
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void executeMessage(SendMessage sm){
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            log.warn("", e);
        }
    }
}
