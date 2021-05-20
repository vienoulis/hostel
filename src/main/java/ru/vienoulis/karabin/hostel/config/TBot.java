package ru.vienoulis.karabin.hostel.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.vienoulis.karabin.hostel.entity.Hostel;
import ru.vienoulis.karabin.hostel.listener.MessageListener;

import java.util.List;


@Slf4j
@Component
@PropertySource("application.properties")
public class TBot extends TelegramLongPollingCommandBot {
    private final MapperService mapperService;
    private final MessageListener updateListener;


    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    @Autowired
    public TBot(MapperService mapperService,
                MessageListener listener) {
        this.mapperService = mapperService;
        this.updateListener = listener;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            updateListener.messageReceived(update);

            List<Hostel> allHostel = mapperService.getHostelMapper().getAllHostel();

            String message = StringUtils.join(allHostel.toArray(), "\n");
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
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
