package uz.pdp.g42.logging.telegramservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class TelegramBotHandler extends StreamHandler {

    public TelegramBotHandler() {
        super.setFilter(new TelegramBotFilter());
        super.setFormatter(new TelegramBotFarmatter());
    }

    @Override
    public void publish(LogRecord record) {
        if (isLoggable(record)) {


            try {

                String formatMessage = getFormatter().format(record);

                String message = """
                        {
                        "chat_id":"%s",
                        "text":"%s"
                        }
                        """.formatted(TelegramBotAPI.chatId, formatMessage);


                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(message))
                        .uri(URI.create(TelegramBotAPI.sendmessage))
                        .header("Content-Type", "application/json")
                        .build();

                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }
}
