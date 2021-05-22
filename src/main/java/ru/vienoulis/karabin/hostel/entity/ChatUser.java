package ru.vienoulis.karabin.hostel.entity;

import lombok.Value;
import org.telegram.telegrambots.meta.api.objects.User;

import static java.util.logging.Level.ALL;

@Value
public class ChatUser extends generator.ChatUser {
    Integer id;
    String accessLevel;
    Integer chatId;
    String name;
    String other;

    public ChatUser getChatUserFrom(User user) {
        return new ChatUser(null,
                ALL.toString(),
                user.getId().intValue(),
                user.getUserName(),
                null);
    }

    @Override
    public String toString() {
        return  String.format("User %s, is %s (%d)", name, accessLevel, chatId);
    }
}
