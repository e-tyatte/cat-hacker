package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "Lusha2025_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "7686040147:AAE6wgJ6o0e-imjJV9ScfyN2_Gr6Xo_YT38"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(com.javarush.telegrambot.Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
// Отобразить сообщение о начале игры - нужно взломать холодильник
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взломать холодильник", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Скинуть банку согурцами! +20 славы", "step_2_btn"));
        }
// Взломать робот-пылесос
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот-пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на роботе-пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робота-пылесоса! +30 славы", "step_4_btn"));
        }
// Взломать камеру Go-Pro
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Взлом камеры Go-Pro", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Бегать по крышам, снимать на Go-Pro! +40 славы", "step_6_btn",
                            "С Go-Pro нападать на других котов из засады! +40 славы", "step_6_btn",
                            "С Go-Pro нападать на собак из засады! +40 славы", "step_6_btn"));
        }
// Взломать компьютер
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом пароля", "step_7_btn"));
        }
// Похвастаться перед дворовыми котами
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Выйти во двор", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            //sendPhotoMessageAsync("final_pic");
            sendPhotoMessageAsync("C:\\Users\\etyat\\OneDrive\\Documents\\TelegramBot\\src\\main\\resources\\images\\step_3_pic.jpg");
            sendTextMessageAsync(FINAL_TEXT);
        }

        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("Сейчас у игрока славы: " + getUserGlory());
        }


        public static <TelegramBotsApi > void main (String[]args) throws com.javarush.telegrambot.TelegramApiException {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(com.javarush.telegrambot.DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyFirstTelegramBot());
        }
    }
}


//if (getMessageText().equals("/start")) {
//    sendTextMessageAsync("Ваше любимое животное?",
//              Map.of("Кот", "cat", "Собака", "dog"));
//}

//if (getMessageText().equals("/bye")) {
//    sendTextMessageAsync("Asta la vista, baby!");
//}

//if (getCallbackQueryButtonKey().equals("cat")) {
//    sendPhotoMessageAsync("step_4_pic");
//}

//if (getCallbackQueryButtonKey().equals("dog")) {
//    sendPhotoMessageAsync("step_6_pic");
//}

//if (getMessageText().equals("smile")) {
//    var message = getLastSentMessage();
//    editTextMessageAsync(message.getMessageId(), message.getText()+" :) ");
//}
