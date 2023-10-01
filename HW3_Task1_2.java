
// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
// разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
//
// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей w или m.
//
// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
// ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы
// данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы
// java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией,
// что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
// записаться полученные данные, вида
//
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class EnterData2{
    public static String Data(){
        String str = "";
        try(Scanner scanner = new Scanner(System.in);){
            System.out.println("Enter Фамилия Имя Отчество датарождения номертелефона пол");
            str = scanner.nextLine();
        } catch (Exception e){
            System.out.println("Error " + e.getStackTrace());
        }
        return str;
    }
}

public class HW3_Task1_2 {
    public static void main(String[] args) {
        String[] data = null;
        String input_data = EnterData2.Data();
        System.out.println("Data: " + input_data);
        String lastName = null;
        try {
            data = input_data.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("не хватает данных");
            }
            lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            Date dateOfBirth = parseDate(data[3]);
            int phoneNumber = Integer.parseInt(data[4]);
            char gender = data[5].charAt(0);

            System.out.println(lastName + " " + firstName + " " + middleName);
            System.out.println("date of birthday:" + dateOfBirth);
            System.out.println("phone num:" + phoneNumber);
            System.out.println("gender: " + gender);

        } catch (NumberFormatException ex) {
            System.out.println("Error number phone");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("data error: ");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Data too small");
        }

        Copy(data, lastName);
    }

    private static Date parseDate(String dateStr) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(dateStr);
    }

    public static void Copy(String[] data, String lastName) {
        String newFileName = lastName + ".txt";
        try (FileWriter writer = new FileWriter(newFileName, true)){
           
            for (int i = 0; i < 6; i++) {
                writer.append("<");
                writer.append(data[i]);
                writer.append(">");

            }
            writer.append("\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
