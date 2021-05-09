package ru.vienoulis.karabin.hostel;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.vienoulis.karabin.hostel.config.TBot;

import java.util.Map;

public class App {
    private static final Map<String, String> getenv = System.getenv();
    private static final String USERNAME = "karabin_test_bot";
    private static final String TOKEN = "1754403412:AAFQ5cO26nf8emGj0EkSfAmyS5PCqMNdm90";

    public static void main(String[] args) {
        System.out.println("hello");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TBot(USERNAME, TOKEN));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

