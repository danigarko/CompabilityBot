package org.example;

import okhttp3.OkHttpClient;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "ZooTaxiLapCarBot";
    }

    @Override
    public String getBotToken() {
        return "7840055911:AAFc2Lo-Jbsz0xfQRQxQeeeB4Exr6rrAIlo";
    }

    Buttons buttons = new Buttons();
    HeadButtons headButtons = new HeadButtons();

    OfferButton offerButton = new OfferButton();

    final public int priceWith = 2500;
    final public int priceWithout = 3000;


    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            headButtons.setButtons(sm);
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void WithOrWithout(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            buttons.setButtons(sm);
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendTextEmpty(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        String text;
        long userId = message.getFrom().getId();
        if (update.hasMessage() && update.getMessage().hasText()) {
            text = update.getMessage().getText();
            text = message.getText();
            long chat_id = update.getMessage().getChatId();


            if (text.equals("/start")) {
                sendText(userId,"Выберите пункт меню");
            } else if (text.equals("Узнать тарифы по Москве")) {
                WithOrWithout(userId, "Поездка по Москве без вашего сопровождения 3000р " + "\n" +
                        "Ночной тариф 3600р" + "\n" +
                        "Поездка туда-обратно с 1 часом ожидания 4500р" + "\n" +
                        "" + "\n" +
                        "Поездка по Москве c вашим сопровождением 2500р " + "\n" +
                        "Ночной тариф 3000р" + "\n" +
                        "Поездка туда-обратно с 1 часом ожидания 3750р");
                try {
                    execute(OfferButton.hermitageInlineKeyboardAb(chat_id));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (text.equals("Узнать тарифы в Московской области")) {
                sendTextEmpty(userId, "Напишите расстояние от МКАД в км");
            } else if (text.equalsIgnoreCase("Вернуться в главное меню")) {
                    sendText(userId,"Выберите пункт меню");
            } else if (text.equalsIgnoreCase("Уточнить цену поездки межгород")) {
                sendText(userId, "За более подробной информацией обращайтесь к @danigarko");
            }
            final int priceWay = Integer.parseInt(text) * 50;
            int priceFullWithOut = priceWay + priceWithout;
            int priceFullWith = priceWay + priceWith;


            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) < 350) {
                sendTextEmpty(userId, "Цена поездки без вашего сопровождения " + priceFullWithOut + "р" + "\n" +
                        "Ночной тариф (после с 22:00 до 6:00) " + priceFullWithOut * 1.2 + "р" + "\n" +
                        "Поездка туда-обратно с ожиданием 1 час " + priceFullWithOut * 1.5 + "р");
                WithOrWithout(userId, "Цена поездки c вашим сопровождением " + priceFullWith + "р" + "\n" +
                        "Ночной тариф (после с 22:00 до 6:00) " + priceFullWith * 1.2 + "р" + "\n" +
                        "Поездка туда-обратно с ожиданием 1 час " + priceFullWith * 1.5 + "р");
                try {
                    execute(OfferButton.hermitageInlineKeyboardAb(chat_id));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (Integer.parseInt(text) > 350 || Integer.parseInt(text) < 0) {
                WithOrWithout(userId, "Укажите расстояние от 1 до 350км, в противном случае уточняйте цены поездок по тарифу межгород");
            }

        }
    }
}

