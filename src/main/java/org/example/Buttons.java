package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Buttons {
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
        KeyboardRow keyBoardFifthRow = new KeyboardRow();

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
        keyBoardFifthRow.add(new KeyboardButton("Вернуться на главное меню"));

        keyboardRowList.add(keyBoardFirstRow);
        keyboardRowList.add(keyBoardSecondRow);
        keyboardRowList.add(keyBoardThirdRow);
        keyboardRowList.add(keyBoardFourthRow);
        keyboardRowList.add(keyBoardFifthRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }
}
