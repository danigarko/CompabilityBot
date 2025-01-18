package org.example;

import okhttp3.OkHttpClient;
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

    public void sendText0 (Long who, String what){
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
            sendText(userId, "Выберите пункт меню");
        } else if (text.equalsIgnoreCase("Стрелец")) {
            sendText1(userId, "Стрельцы и Овны: Хорошая совместимость\n" +
                    "Стрельцы и Львы: Высокая совместимость\n" +
                    "Стрельцы и Девы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Овен")) {
            sendText1(userId, "Овны и Львы: Отличная совместимость\n" +
                    "Овны и Стрельцы: Высокая совместимость\n" +
                    "Овны и Козероги: Сложные отношения");
        } else if (text.equalsIgnoreCase("Телец")) {
            sendText1(userId, "Тельцы и Девы: Хорошая совместимость\n" +
                    "Тельцы и Козероги: Отличная совместимость\n" +
                    "Тельцы и Львы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Близнецы")) {
            sendText1(userId, "Близнецы и Весы: Высокая совместимость\n" +
                    "Близнецы и Водолеи: Хорошая совместимость\n" +
                    "Близнецы и Рыбы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Рак")) {
            sendText1(userId, "Раки и Скорпионы: Отличная совместимость\n" +
                    "Раки и Рыбы: Высокая совместимость\n" +
                    "Раки и Весы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Лев")) {
            sendText1(userId, "Львы и Овны: Отличная совместимость\n" +
                    "Львы и Стрельцы: Хорошая совместимость\n" +
                    "Львы и Тельцы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Дева")) {
            sendText1(userId, "Девы и Тельцы: Хорошая совместимость\n" +
                    "Девы и Козероги: Отличная совместимость\n" +
                    "Девы и Близнецы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Весы")) {
            sendText1(userId, "Весы и Близнецы: Высокая совместимость\n" +
                    "Весы и Водолеи: Хорошая совместимость\n" +
                    "Весы и Раки: Сложные отношения");
        } else if (text.equalsIgnoreCase("Скорпион")) {
            sendText1(userId, "Скорпионы и Раки: Отличная совместимость\n" +
                    "Скорпионы и Рыбы: Высокая совместимость\n" +
                    "Скорпионы и Львы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Козерог")) {
            sendText1(userId, "Козероги и Тельцы: Отличная совместимость\n" +
                    "Козероги и Девы: Высокая совместимость\n" +
                    "Козероги и Овны: Сложные отношения");
        } else if (text.equalsIgnoreCase("Водолей")) {
            sendText1(userId, "Водолеи и Близнецы: Хорошая совместимость\n" +
                    "Водолеи и Весы: Высокая совместимость\n" +
                    "Водолеи и Раки: Сложные отношения");
        } else if (text.equalsIgnoreCase("Рыбы")) {
            sendText1(userId, "Рыбы и Раки: Высокая совместимость\n" +
                    "Рыбы и Скорпионы: Отличная совместимость\n" +
                    "Рыбы и Близнецы: Сложные отношения");
        } else if (text.equalsIgnoreCase("Совместимость по знакам")) {
            sendText1(userId, "Укажите ваш знак зодиака");
        } else if (text.equalsIgnoreCase("Гороскоп на сегодня")) {
            sendText(userId, "Пока в разработке");
        } else if (text.equalsIgnoreCase("Вернуться на главное меню")) {
            sendText(userId, "Выберите пункт меню");
        } else if (text.equalsIgnoreCase("Уточнить совместимость между знаками")) {
            sendText0(userId,"Введите в формате 'знак + знак'");
        } else if (text.equalsIgnoreCase("Стрелец + Телец")) {
            sendText0(userId,"Совместимость Стрельца и Тельца может быть сложной,\n" +
                    "но вполне возможной при условии, что оба партнера готовы к компромиссам.\n " +
                    "Телец должен быть открытым к идеям Стрельца, а Стрелец, в свою очередь,\n " +
                    "должен уважать потребность Тельца в стабильности и предсказуемости.\n " +
                    "Такой союз может быть интересным и наполненным приключениями,\n " +
                    "если оба будут готовы работать над отношениями и\n " +
                    "находить баланс между свободой и стабильностью.");
        } else {
            sendText(userId, "Что?");
        }

        System.out.println(message.getText());

    }


}
