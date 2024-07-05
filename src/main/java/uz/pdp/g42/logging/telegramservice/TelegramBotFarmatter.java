package uz.pdp.g42.logging.telegramservice;

import java.text.Format;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class TelegramBotFarmatter extends Formatter {

    @Override
    public String format(LogRecord record) {

        String formatted = "%s : [%s] : [%d] [%s]".formatted(record.getLevel(), record.getLoggerName(), record.getLongThreadID(), record.getMessage());

        return formatted;
    }
}
