import java.time.DateTimeException;
import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void print_info(String family, char N, char P, String gender, int age)
    {
        System.out.println("Фамилия И. О.: " + family + " " + N + ". " + P + ".");
        System.out.println("Пол: " + gender);
        if (age % 10 == 1 && (age < 10 || age > 20)) System.out.println("Возраст: " + age + " год");
        else if (age % 10 > 1 && age % 10 < 5 && (age < 10 || age > 20)) System.out.println("Возраст: " + age + " года");
        else System.out.println("Возраст: " + age + " лет");
    }

    public static void main(String[] args) {
        System.out.println("Введите Фамилию, Имя, Отчество и дату рождения (в формате ГГГГ-ММ-ДД): ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();

        String[] data_parts = data.split(" ");
        String gender = (data_parts[2].charAt(data_parts[2].length() - 1) == 'а') ? "женский" : "мужской";

        LocalDate currentDate = LocalDate.now();
        try
        {
            LocalDate birthDate = LocalDate.parse(data_parts[3]);
            Period difference = Period.between(birthDate, currentDate);
            int age = difference.getYears();
            print_info(data_parts[0], data_parts[1].charAt(0), data_parts[2].charAt(0), gender, age);
        }
        catch (DateTimeException ex) {
            System.out.println("Некорректная дата!");
        }
    }
}
