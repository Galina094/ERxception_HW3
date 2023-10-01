// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
// разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
//
// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
//
// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
// ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы
// данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы
// java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией,
// что именно неверно.


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

class EntereData {

    public static String EnterName( String str){
        String name = "";

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your " + str);
        name = in.next();

        while (!name.matches("[a-zA-Z]+")){
            System.out.print("Enter your " + str);
            name = in.next();
        }

        return name;
    }

    public static long EnterPhoneNumber(){
        String phoneNum = "";
        long parse_phone = 0;
        try(Scanner in = new Scanner(System.in);){
            System.out.println("Enter your phone number in the format '89193456785' : ");
            phoneNum = in.next();
            while(phoneNum.matches("[^0-9]+") | phoneNum.length()!=11 ){
                System.out.println("Enter your phone number in the format '89193456785' : ");
                phoneNum = in.next();
            }
            try {
                parse_phone = Long.parseLong(phoneNum);
            } catch (Exception ex){
                System.out.println("Error of parsing!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Invalid data format!!!");
        }
        return parse_phone;
    }

    public static LocalDate GetDate(){

        LocalDate date = null;

        try ( Scanner in = new Scanner(System.in);) {
            System.out.println("Введите дату рождения в формате (yyyy-mm-dd):");
            String dateString = in.nextLine();
            date = LocalDate.parse(dateString);
            System.out.println("Дата рождения: " + date);

        } catch (DateTimeException e ) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception ex){
            System.out.println("I don't know what is it ?!" + Arrays.toString(ex.getStackTrace()));
        }
        return date;
    }

    public static String EnterGender(){

        String name = "";

        Scanner in = new Scanner(System.in);
        System.out.print("Enter gen");
        name = in.next();

        while (name.length()!=1){
            System.out.print("Enter your gen");
            name = in.next();
        }

        return name;
//        String gender = "";
//        try{
//            Scanner in = new Scanner(System.in);
//            System.out.println("Enter your gender 'f' or 'm': ");
//            gender = in.next();
//
//            while (gender.length()!=1){
//                System.out.println("Enter your gender 'f' or 'm': ");
//                gender = in.next();
//            }
//            return gender;
//        }catch (Exception e){
//            System.out.println("Error of gender :" + e.getStackTrace());
//            System.out.println("Error of gender :" + e.getMessage());
//        }
    }
}

public class HW3_Task1 {
    public static void main(String[] args) {


        String last_name = EntereData.EnterName("last name:");
        String first_name = EntereData.EnterName("first name:");
        String patronymic = EntereData.EnterName("patronymic name:");
        // LocalDate dateOfBirthday = EntereData.GetDate();
        long phone_number = EntereData.EnterPhoneNumber();
        String gender = EntereData.EnterGender();


        System.out.println(last_name + " " + first_name + " " + patronymic);
        System.out.println("phone number: " + phone_number);
        System.out.println("gender is: " + gender);
//        System.out.println("Birthday's date: " + dateOfBirthday);
    }
}
