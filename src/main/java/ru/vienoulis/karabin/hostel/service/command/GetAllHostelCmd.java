package ru.vienoulis.karabin.hostel.service.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vienoulis.karabin.hostel.service.Action;
import ru.vienoulis.karabin.hostel.service.Command;

@Slf4j
@Service
public class GetAllHostelCmd  implements Command {

    private static final Action ACTION = Action.GetAllHostel;

    @Override
    public void execute(Update update) {
        log.info("Execute get all hostel cmd");
    }

    @Override
    public Action getAction() {
        return ACTION;
    }


}
