package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "CompatibilityForLife_Bot";
    }

    @Override
    public String getBotToken() {
        return "7045169343:AAEWGpbGzkjtylc28Nzjnjb0CFOfy72ezPM";
    }

    Buttons buttons = new Buttons();
    HeadButtons headButtons = new HeadButtons();

    public void sendText(Long who, String what){
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

    public void sendText1(Long who, String what){
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


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        String text = message.getText();
        long userId = message.getFrom().getId();
        if (text.equals("/start")) {
            sendText(userId, "Выберите пункт меню");
        } else if (text.equalsIgnoreCase("Стрелец")) {
            sendText1(userId, "Ваша идеальная пара - Водолей");
        } else if (text.equalsIgnoreCase("Овен")) {
            sendText1(userId, "Ваша идеальная пара - Козерог");
        } else if (text.equalsIgnoreCase("Телец")) {
            sendText1(userId, "Ваша идеальная пара - Рыбы");
        } else if (text.equalsIgnoreCase("Близнецы")) {
            sendText1(userId, "Ваша идеальная пара - Лев");
        } else if (text.equalsIgnoreCase("Рак")) {
            sendText1(userId, "Ваша идеальная пара - Скорпион");
        } else if (text.equalsIgnoreCase("Лев")) {
            sendText1(userId, "Ваша идеальная пара - Стрелец");
        } else if (text.equalsIgnoreCase("Дева")) {
            sendText1(userId, "Ваша идеальная пара - Скорпион");
        } else if (text.equalsIgnoreCase("Весы")) {
            sendText1(userId, "Ваша идеальная пара - Лев");
        } else if (text.equalsIgnoreCase("Скорпион")) {
            sendText1(userId, "Ваша идеальная пара - Рыбы");
        } else if (text.equalsIgnoreCase("Козерог")) {
            sendText1(userId, "Ваша идеальная пара - Телец");
        } else if (text.equalsIgnoreCase("Водолей")) {
            sendText1(userId, "Ваша идеальная пара - Водолей");
        } else if (text.equalsIgnoreCase("Рыбы")) {
            sendText1(userId, "Ваша идеальная пара - Стрелец");
        } else if (text.equalsIgnoreCase("Совместимость по знакам")) {
            sendText1(userId, "Укажите ваш знак зодиака");
        } else if (text.equalsIgnoreCase("Гороскоп на сегодня")) {
            sendText(userId, "Пока в разработке");
        } else if (text.equalsIgnoreCase("Вернуться на главное меню")) {
            sendText(userId, "Пока в разработке");
        } else {
            sendText(userId, "Что?");
        }

        System.out.println(message.getText());

    }


}
