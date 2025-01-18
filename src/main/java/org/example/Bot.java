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

    public void sendText(Long who, String what){
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
        String text = message.getText();
        long userId = message.getFrom().getId();
        if (text.equals("/start")) {
            sendText(userId, "Напишите ваш знак зодиака");
        } else if (text.equalsIgnoreCase("Стрелец")) {
            sendText(userId, "Ваша идеальная пара - Водолей");
        } else if (text.equalsIgnoreCase("Овен") || text.equals("овен")) {
            sendText(userId, "Ваша идеальная пара - Козерог");
        } else if (text.equalsIgnoreCase("Телец")) {
            sendText(userId, "Ваша идеальная пара - Рыбы");
        } else if (text.equalsIgnoreCase("Близнецы")) {
            sendText(userId, "Ваша идеальная пара - Лев");
        } else if (text.equalsIgnoreCase("Рак")) {
            sendText(userId, "Ваша идеальная пара - Скорпион");
        } else if (text.equalsIgnoreCase("Лев")) {
            sendText(userId, "Ваша идеальная пара - Стрелец");
        } else if (text.equalsIgnoreCase("Дева")) {
            sendText(userId, "Ваша идеальная пара - Скорпион");
        } else if (text.equalsIgnoreCase("Весы")) {
            sendText(userId, "Ваша идеальная пара - Лев");
        } else if (text.equalsIgnoreCase("Скорпион")) {
            sendText(userId, "Ваша идеальная пара - Рыбы");
        } else if (text.equalsIgnoreCase("Козерог")) {
            sendText(userId, "Ваша идеальная пара - Телец");
        } else if (text.equalsIgnoreCase("Водолей")) {
            sendText(userId, "Ваша идеальная пара - Водолей");
        } else if (text.equalsIgnoreCase("Рыбы")) {
            sendText(userId, "Ваша идеальная пара - Стрелец");
        } else {
            sendText(userId, "Что?");
        }
        System.out.println(message.getText());

    }
}
