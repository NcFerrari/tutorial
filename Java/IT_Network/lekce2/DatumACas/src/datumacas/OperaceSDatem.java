package datumacas;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Period;

public class OperaceSDatem {

    /**
     * AKTUÁLNÍ ČAS
     * <li>LocalDate.now()</li>
     * <li>LocalTime.now()</li>
     * <li>LocalDateTime.now()</li>
     *
     * @return
     */
    public LocalDateTime getActualDateTime() {
        return LocalDateTime.now();
    }

    /**
     * MANUÁLNĚ ZADANÝ ČAS
     * <li>LocalDate.of(2021, Month.JUNE, 27)</li>
     * <li>LocalTime.of(15, 22)</li>
     * <li>LocalDateTime.of(2021, Month.JUNE, 27, 15, 22)</li>
     *
     * @return
     */
    public LocalDateTime getManualDateTime() {
        return LocalDateTime.of(2021, Month.JUNE, 27, 15, 22);
    }

    /**
     * PŘEVOD STRINGU NA ČAS
     *
     * je potřeba dodržovat formáty ve stringu
     * <li>String -> LocalDate: LocalDateTime.parse("yyyy-MM-dd")</li>
     * <li>String -> LocalTime: LocalDateTime.parse("HH:ss")</li>
     * <li>String -> LocalDateTime: LocalDateTime.parse("yyyy-MM-ddTHH:ss")</li>
     *
     * @param date
     * @return
     */
    public LocalDateTime getDateTimeFromString(String date) {
        return LocalDateTime.parse(date);
    }

    /**
     * ČAS NA STRING
     *
     * normálně zavolat metodu toString()
     *
     * @param date
     * @return
     */
    public String getStringFromLocalDateTime(LocalDateTime date) {
        return date.toString();
    }

    /**
     * ČAS NA LONG (SEKUNDY)
     *
     * !!POZOR, FUNGUJE POUZE PRO LOCALDATETIME!!
     *
     * @param date
     * @return
     */
    public Long getLongSecondsFromLocalDateTime(LocalDateTime date) {
        return date.toEpochSecond(ZoneOffset.UTC);
    }

    /**
     * ČAS NA LONG (MILISEKUNDY)
     *
     * !!POZOR, FUNGUJE POUZE PRO LOCALDATETIME!!
     *
     * @param date
     * @return
     */
    public Long getLongMiliSecondsFromLocalDateTime(LocalDateTime date) {
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * LONG (SEKUNDY) NA ČAS
     *
     * @param seccons
     * @return
     */
    public LocalDateTime getLocalDateTimeFromLongSeconds(Long seccons) {
        return LocalDateTime.ofEpochSecond(seccons, 0, ZoneOffset.UTC);
    }

    /**
     * LONG (MILISEKUNDY) NA ČAS
     *
     * @param miliseconds
     * @return
     */
    public LocalDateTime getLocalDateTimeFromLongMiliseconds(Long miliseconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(miliseconds), ZoneId.systemDefault());
    }

    /**
     * STARÝ DATE() NA ČAS
     *
     * @param date
     * @return
     */
    public LocalDateTime getLocalDateTimeFromDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * ČAS NA STARÝ DATE()
     *
     * @param date
     * @return
     */
    public Date getDateFromLocalDateTime(LocalDateTime date) {
        return Date.from(date.toInstant(ZoneOffset.UTC));
    }

    /**
     * ČESKÝ MĚSÍC Z LOCALDATETIME
     *
     * alternativou pro toto je:
     *
     * date.format(DateTimeFormatter.ofPattern("MMMM", new Locale("CS")));
     *
     * @param date
     * @return
     */
    public String getCzechMonthFromLocalDateTime(LocalDateTime date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, new Locale("CS"));
    }

    /**
     * ČESKÝ DEN V TÝDNU Z LOCALDATETIME
     *
     * @param date
     * @return
     */
    public String getCzechDayOfWeekFromLocalDateTime(LocalDateTime date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("CS"));
    }

    /**
     * TIMESTAMP NA ČAS
     *
     * Dala by se použít i tato metoda: timestamp.toLocalDateTime(); Ale není to
     * čisté řešení. Je lepší zvyknout si používat ID zóny. V případných
     * sloužitějších projektech můžete předejít některým problémům
     *
     * @param timestamp
     * @return
     */
    public LocalDateTime getLocalDateTimeFromTimestamp(Timestamp timestamp) {
        return timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * ČAS na TIMESTAMP
     *
     * @param date
     * @return
     */
    public Timestamp getTimestampFromLocalDateTime(LocalDateTime date) {
        return Timestamp.valueOf(date);
    }

    /**
     * FORMÁTOVÁNÍ
     *
     * Nejlepší způsob je zvolit formát pomocí zástupných znaků. Zde je jejich
     * výpis:
     * <li>[y] nebo [Y] -> 4 čísla představující rok (např.: 2021)</li>
     * <li>[yy] nebo [YY] -> 2 poslední čísla z roku (např.: 21)</li>
     * <li>[D] nebo [DD] nebo [DDD] -> pořadí dne v roce. 2x nebo 3x D znamená,
     * že bude dvojmístné nebo trojmístné číslo, takže třeba i s nulou na
     * začátku (např.: 6 nebo 06 nebo 006)</li>
     * <li>[d] nebo [dd] -> číslo dne v měsíci. 2x d znamená, že bude dvojmístné
     * číslo, takže třeba i s nulou na začátku (např.: 9 nebo 09)</li>
     * <li>[M] nebo [L] -> číslo měsíce (např.: 5)</li>
     * <li>[MM] nebo [LL] -> dvouciferné číslo měsíce (např.: 06)</li>
     * <li>[MMM] nebo [LLL] -> krátký název měsíce (např.: kvě)</li>
     * <li>[MMMM] nebo [LLLL] -> celý název měsíce. Rozdíl mezi MMMM a LLLL je
     * ve skloňování. MMMM píše název tak, jak bychom ho řekli v datumu a LLLL
     * napíše název měsíce. (např.: července nebo červenec)</li>
     * <li>[q] nebo [Q] -> číslo kvartálu/čtvrtletí (např.: 1)</li>
     * <li>[qq] nebo [QQ] -> dvojciferné číslo kvartálu/čtvrtletí, tedy i s
     * nulou na začátku (např.: 02)</li>
     * <li>[qqq] nebo [QQQ] -> označení kvartálu/čtvrtletí pomocí písmene Q a
     * čísla kvartálu (např.: Q3)</li>
     * <li>[qqqq] nebo [QQQQ] -> plný text označující kvartál/čtvrtletí (např.:
     * 4. čtvrtletí)</li>
     * <li>[w] nebo [ww] -> číslo týdne v roce. 2x w znamená, že bude číslo
     * dvojmístné (např.: 3 nebo 03)</li>
     * <li>[W] nebo [F] -> číslo týdne v měsíci (např.: 2)</li>
     * <li>[e] nebo [ee] -> číslo dne týdne. 2x e znamená dvojciferné číslo,
     * tedy i s nulou (např.: 5 nebo 05)</li>
     * <li>[eee] nebo [E] -> zkrácený název dne v týdnu (např.: so)</li>
     * <li>[eeee] nebo [EEEE] -> celý název dne v týdnu (např.: pátek)</li>
     * <li>[a] -> text, jestli je hodina odpoledne nebo dopoledne (např.:
     * dop.)</li>
     * <li>[h] nebo [hh] -> hodina ve 12 hodinovém formátu. 2x h znamená
     * dvojciferné číslo, tedy i s nulou na začátku (např.: 3 nebo 03)</li>
     * <li>[H] nebo [HH] -> hodina ve 24 hodinovém formátu. 2x H znamená
     * dvojciferné číslo, tedy i s nulou na začátku (např.: 15 nebo 06)</li>
     * <li>[m] nebo [mm] -> minuta hodiny. 2x m znamená dvojciferné číslo, tedy
     * i s nulou na začátku (např.: 7 nebo 07)</li>
     * <li>[s] nebo [ss] -> sekunda hodiny. 2x s znamená dvojciferné číslo, tedy
     * i s nulou na začátku (např.: 5 nebo 05)</li>
     * <li>[S] až [SSSSSSSSS] -> části sekundy.</li>
     * <li>1 sek = 1 000 milisekund (milisekundy = SSS) (3xS)</li>
     * <li>1 sek = 1 000 000 mikrosekund (mikrosekundy = SSSSSS)(6xS)</li>
     * <li>1 sek = 1 000 000 000 nanosekund (nanosekundy = SSSSSSSSS)(9xS)</li>
     * <li>[A] -> milisekundy za den. Počítá se to od času 00:00:0000 každého
     * dne (např.: 1000)</li>
     *
     * @param date
     * @return
     */
    public String getFormattedOutput(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(""));
    }

    /**
     * ÚPRAVY DATUMU NATVRDO
     *
     * pokud budeme chtít upravit jakýkoliv údaj v datu, tak stačí na daný čas
     * zavolat jednu z metod withXXX() !!!POZOR Tyto metody nenastaví ten tomu
     * objektu času takovou hodnotu, pouze ji vrátí. Pokud ji budeme chtít
     * změnit, tak ji musíme dotyčnému času i přiřadit!!! např.: date =
     * date.withYear(2030);
     * <li>withDayOfMonth()</li>
     * <li>withDayOfYear()</li>
     * <li>withHour()</li>
     * <li>withMinute()</li>
     * <li>withMonth()</li>
     * <li>withDayOfMonth()</li>
     * <li>withNano()</li>
     * <li>withSecond()</li>
     * <li>withYear()</li>
     *
     * @param date
     * @return
     */
    public LocalDateTime modifyDateHard(LocalDateTime date) {
        return date.withYear(2022);
    }

    /**
     * PŘIČÍTÁNÍ HODNOT K DATUMU slouží pro to dva typy metod.
     * <li>plusXXX()</li>
     * <li>minusXXX()</li>
     * Obě metody mají ve svých názvech hodnoty, ke kterým přičítají či
     * odečítají hodnoty, které uvedete jako parametr v závorce. Ani tyto metody
     * nezmění hodnotu instance. Prostě jen vrátí její podobu. Pokud bychom je
     * chtěli instanci nastavit, museli bychom opět tuto změněnou podobu
     * instanci přiřadit např.: date = date.plusHours(45);
     *
     * @param date
     * @return
     */
    public LocalDateTime modifyDateSoft(LocalDateTime date) {
        return date.plusHours(1);
    }

    /**
     * DNY MEZI DATUMY
     *
     * @param date1
     * @param date2
     * @return
     */
    public long getDaysBetweenDates(LocalDateTime date1, LocalDateTime date2) {
        return Duration.between(date1, date2).toDays();
    }

    /**
     * ČAS MEZI DATUMY (počet let, měsíců a dní mezi datumy)
     *
     * @param date1
     * @param date2
     * @return
     */
    public String getTimeBetweenDates(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        return String.format("%d %d %d", period.getYears(), period.getMonths(), period.getDays());
    }

    /**
     * PŘEVODY MEZI ČASY
     *
     * Pro tohle slouží nejlépe třída Duration
     */
    public void prevody() {
        System.out.println(Duration.ofDays(100).toMinutes());
        System.out.println(Duration.ofMinutes(100).toSeconds());
        System.out.println(Duration.ofHours(100).toMinutes());
        System.out.println(Duration.ofHours(1).toMinutes());
    }

    public static void main(String[] args) {
        OperaceSDatem o = new OperaceSDatem();
        o.prevody();
    }
}
