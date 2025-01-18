package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class HeadButtons {
    public void setButtons (SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);


        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyBoardFirstRow = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        keyboardButton1.setText("Совместимость по знакам");
        keyboardButton2.setText("Гороскоп на сегодня");


        keyboardRowList.add(keyBoardFirstRow);
        keyBoardFirstRow.add(keyboardButton1);
        keyBoardFirstRow.add(keyboardButton2);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

}
