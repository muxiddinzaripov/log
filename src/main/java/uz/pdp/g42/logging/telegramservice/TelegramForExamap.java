package uz.pdp.g42.logging.telegramservice;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.*;

public class TelegramForExamap {
    static {
        try {
            URL resource = TelegramForExamap.class.getClassLoader().getResource("logging.properties");
            if (resource != null) {
                LogManager.getLogManager().readConfiguration(resource.openStream());
            } else {
                System.err.println("Could not find logging.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Logger logger = Logger.getLogger(TelegramForExamap.class.getName());

    public static void main(String[] args) {
        Handler handler = new TelegramBotHandler();
        logger.addHandler(handler);

       try {
           if (new Random().nextBoolean()) {
              throw  new RuntimeException("Runtime Exception For alarm testing");
           }
       }catch (RuntimeException e){
           logger.log(Level.SEVERE,"Error Message For Telegram",e);
       }
    }
}
