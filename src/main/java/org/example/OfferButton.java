package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class OfferButton {

    public static SendMessage hermitageInlineKeyboardAb(long chat_id) {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chat_id));
        message.setText("Здесь вы можете оформить заказ");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Заказать поездку");
        inlineKeyboardButton1.setCallbackData("ЗАКАЗАТЬ ПОЕЗДКУ");
        inlineKeyboardButton1.setUrl("https://t.me/danigarko");
        rowInline1.add(inlineKeyboardButton1);

        rowsInline.add(rowInline1);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        return message;
    }
}
