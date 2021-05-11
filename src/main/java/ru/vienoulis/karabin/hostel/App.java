package ru.vienoulis.karabin.hostel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.vienoulis.karabin.hostel.config.AppConfiguration;
import ru.vienoulis.karabin.hostel.config.TBot;

@Slf4j
public class App {
    private static AnnotationConfigApplicationContext context;
    private static TBot tBot;

    static {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        tBot = context.getBean(TBot.class);
    }

    public static void main(String[] args) {

        log.info("Start app");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(tBot);
        } catch (TelegramApiException e) {
            log.warn("", e);
        }
    }
}