package uz.pdp.g42.logging.telegramservice;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class TelegramBotFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {

        return record.getLevel().intValue()>=Level.CONFIG.intValue();
    }
}
