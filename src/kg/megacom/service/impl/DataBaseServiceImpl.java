package kg.megacom.service.impl;

import kg.megacom.Main;
import kg.megacom.service.DataBaseService;

import java.util.*;

public class DataBaseServiceImpl implements DataBaseService {

    HashMap<String, String> map = new HashMap<>();
    ArrayList<String> countries = new ArrayList<>();
    ArrayList<String> cities = new ArrayList<>();


    @Override
    public void getAllCountries() {

        map.put("Кыргызстан", "Бишкек");
        map.put("Турция", "Анкара");
        map.put("Южная Корея", "Сеул");
        map.put("Чехия", "Прага");
        map.put("Нидерланды", "Амстердам");
        map.put("Монголия", "Улан-Батор");
        map.put("Китай", "Пекин");
        map.put("Италия", "Рим");
        map.put("Египет", "Каир");
        map.put("Греция", "Афины");
        map.put("Бельгия", "Брюссель");
        map.put("Австрия", "Вена");
        map.put("Япония", "Токио");
        map.put("Франция", "Париж");
        map.put("Украина", "Киев");

        for (Map.Entry<String, String> item : map.entrySet()) {
            countries.add(item.getKey());
            cities.add(item.getValue());
        }
        Collections.shuffle(countries);
        Collections.shuffle(cities);

    }

    @Override
    public HashMap getQuestion() {
        HashMap<String, HashMap<String, Boolean>> questions = new HashMap<>();
        try {
            String country = countries.get(3);
            countries.remove(3);
            String city = map.get(country);
            HashMap<String, Boolean> options = new HashMap<>();
            options.put(city, true);

            cities.remove(city);
            Collections.shuffle(cities);
            for (int i = 0; i < 3; i++) {
                options.put(cities.get(i), false);
            }
            cities.add(city);

            questions.put(country, options);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Тест завершён");
        }
        return questions;


    }
}

