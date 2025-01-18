package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

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
            setButtons(sm);
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
        } else if (text.equalsIgnoreCase("/help")) {
            sendText(userId, "Чтобы узнать вашу совместимость по зна");
        } else {
            sendText(userId, "Что?");
        }

        System.out.println(message.getText());

    }

    public void setButtons (SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyBoardFirstRow = new KeyboardRow();
        KeyboardRow keyBoardSecondRow = new KeyboardRow();
        KeyboardRow keyBoardThirdRow = new KeyboardRow();
        KeyboardRow keyBoardFourthRow = new KeyboardRow();

        keyBoardFirstRow.add(new KeyboardButton("Овен"));
        keyBoardFirstRow.add(new KeyboardButton("Телец"));
        keyBoardFirstRow.add(new KeyboardButton("Близнецы"));
        keyBoardSecondRow.add(new KeyboardButton("Рак"));
        keyBoardSecondRow.add(new KeyboardButton("Лев"));
        keyBoardSecondRow.add(new KeyboardButton("Дева"));
        keyBoardThirdRow.add(new KeyboardButton("Весы"));
        keyBoardThirdRow.add(new KeyboardButton("Скорпион"));
        keyBoardThirdRow.add(new KeyboardButton("Стрелец"));
        keyBoardFourthRow.add(new KeyboardButton("Козерог"));
        keyBoardFourthRow.add(new KeyboardButton("Водолей"));
        keyBoardFourthRow.add(new KeyboardButton("Рыбы"));

        keyboardRowList.add(keyBoardFirstRow);
        keyboardRowList.add(keyBoardSecondRow);
        keyboardRowList.add(keyBoardThirdRow);
        keyboardRowList.add(keyBoardFourthRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }
}
