package kg.megacom;

import kg.megacom.service.DataBaseService;
import kg.megacom.service.MainService;
import kg.megacom.service.impl.DataBaseServiceImpl;
import kg.megacom.service.impl.MainServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Создать тест из 5 вопросов. В конце вывести процент правильных ответов.
        // Вопросов должно быть не меньше 15. Рандомно на каждый тест выбирать 5 вопросов.
        // Структура словаря: {country:{city:boolean}}

        // Страна (ключь) - столица (значение)  добавляем в очередь.
        // не создавать обьекты
        // правильный ответ заложить

        DataBaseService dataBaseService = new DataBaseServiceImpl();
        MainService mainService = new MainServiceImpl();

        mainService.test(3);
        dataBaseService.getQuestion();




    }
}
