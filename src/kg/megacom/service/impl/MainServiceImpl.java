package kg.megacom.service.impl;
import kg.megacom.service.DataBaseService;
import kg.megacom.service.MainService;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainServiceImpl implements MainService {
    DataBaseService dataBaseService = new DataBaseServiceImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void test(int countOfQuestions) {
        dataBaseService.getAllCountries();

        int countryOfCorrect = 0;
        int questionNum = 1;

        for (int i = 0; i < countOfQuestions; i++) {
            HashMap<String, HashMap<String, Boolean>> params = dataBaseService.getQuestion();

            for (Map.Entry<String, HashMap<String, Boolean>> item : params.entrySet()) {
                System.out.println("Вопрос номер: " + questionNum);
                questionNum++;
                System.out.println("Страна " + item.getKey() + ", выберите сталицу ");

                ArrayList<String> cities = new ArrayList<>();

                for (Map.Entry<String, Boolean> option : item.getValue().entrySet()) {
                    cities.add(option.getKey());

                }

                Collections.shuffle(cities);

                int cityNum = 1;
                for (String city : cities) {
                    System.out.println(cityNum + ")" + " " + city);
                    cityNum++;
                }
                int answer = 0;
                while (answer != 1 & answer != 2 & answer != 3 & answer != 4) {
                    try {
                        System.out.print("Выберите номер ответа (#): ");
                        answer = scanner.nextInt();
                        System.out.println("-----------------------------");
                        if (item.getValue().get(cities.get(answer - 1))) {
                            countryOfCorrect++;
                        }
                    } catch (RuntimeException ex) {
                        System.out.println("Не верно введены данные, прошу повторить!");
                    }

                }
            }
        }

        System.out.print("Правильных ответов " + countryOfCorrect + "/" + countOfQuestions + " ");
        System.out.println("(" + ((countryOfCorrect * 100) / countOfQuestions) + "%)");
    }

    static boolean reg(String S) {
        Pattern p = Pattern.compile("[1-4]");
        Matcher m = p.matcher(S);
        return m.matches();
    }
}