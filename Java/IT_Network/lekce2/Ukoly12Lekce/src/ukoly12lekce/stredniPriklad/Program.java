package ukoly12lekce.stredniPriklad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d.M.y");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Pro zadaný interval datumů vypíše všechny pátky 13.:\nZadejte 1. datum:");
        String date1InString = scanner.nextLine(); //1.1.2013
        LocalDate date1 = getFormatedDate(date1InString);
        System.out.println("Zadejte 2. datum:");
        String date2InString = scanner.nextLine();
        LocalDate date2 = getFormatedDate(date2InString);
        System.out.println("Pátky 13.:");
        getFridays(date1, date2);
    }

    private static LocalDate getFormatedDate(String dateInString) {
        return LocalDate.parse(dateInString, DATE_FORMAT);
    }

    private static void getFridays(LocalDate date1, LocalDate date2) {
        while (date1.getDayOfWeek() != DayOfWeek.FRIDAY) {
            date1 = date1.plusDays(1);
        }
        while (date1.isBefore(date2)) {
            if(date1.getDayOfMonth() == 13) {
                System.out.print(date1.format(DATE_FORMAT) + ", ");
            }
            date1 = date1.plusWeeks(1);
        }
        System.out.println();
    }
}