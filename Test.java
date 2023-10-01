
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;



public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате (yyyy-mm-dd):");
        String dateString = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(dateString);

            System.out.println("Дата рождения: " + date);
        } catch (DateTimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


}
