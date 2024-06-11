import datetime
import locale

date = datetime.datetime.now()
print(date)

print(datetime.datetime.now().date())
print(datetime.datetime.now().time())

print(datetime.datetime.date(date))
print(date.year)
print(date.strftime("%A"))

myDate = datetime.datetime(2020, 5, 17, 15, 30, 1, 123456)
print(myDate)


# test rychlosti funkce

def testFunction():
    for i in range(3, 100_000):
        print(i)


start = datetime.datetime.now()
testFunction()
# převedení na long
print((datetime.datetime.now().timestamp() - start.timestamp()) * 1000)
# rozdíl mezi datetime a datetime se dá vrátit v total jednotkách
print((datetime.datetime.now() - start).total_seconds())
print((datetime.datetime.now() - start).microseconds)
print((datetime.datetime.now() - start).seconds)
print((datetime.datetime.now() - start).min)

# formátování
print("FORMÁTOVÁNÍ ČASU\n")

date = datetime.datetime.now()
print("standardní datum:", date)
print("krátký den v angličtině", date.strftime("%a"))
print("dlouhý den v angličtině", date.strftime("%A"))
# locale.setlocale(locale.LC_TIME, "cs_CZ.UTF-8")
# print("krátký den v angličtině", date.strftime("%a"))
# print("dlouhý den v angličtině", date.strftime("%A"))  # dořešit kódování
print("den v týdnu (pořadí od neděle(0) do soboty(6) )", date.strftime("%w"))
print("den v měsíci", date.strftime("%d"))
print("den v roce", date.strftime("%j"))
print("týden v roce", date.strftime("%U"))
print("krátký název měsíce", date.strftime("%b"))
print("dlouhý název měsíce", date.strftime("%B"))
print("pořadí měsíce v roce", date.strftime("%m"))
print("krátký rok (dvě čísla)", date.strftime("%y"))
print("dlouhý rok (4 čísla)", date.strftime("%Y"))
print("Hodiny (24)", date.strftime("%H"))
print("Hodiny (12)", date.strftime("%I"))
print("AM/PM", date.strftime("%p"))
print("Minuty", date.strftime("%M"))
print("Sekundy", date.strftime("%S"))
print("Mikrosekundy", date.strftime(
    "%f"))  # milisekundy (javička) jsou 4 čísla (tisíciny) za sekundou. Mikroskeund je 6 čísel (stotisícina)
print("století", date.strftime(
    "%C"))  # vrací století, ovšem tak, že prostě vezme první dvě čísla z roku v datumu, proto u roku 2024 vrátí 20. století
print("století", int(date.strftime(
    "%C")) + 1)  # aby století bylo skutečné, musíme přičíst jedničku, jenže to je nejdřív potřeba převést date objekt (který vrací metoda strtime) na int a pak až k němu lze přičíst 1
print("lokální formát času", date.strftime("%c"))
print("lokální formát datumu", date.strftime("%x"))
print("procento", date.strftime("%%"))  # nejspíš potřeba, kdybychom řetězili příkazy např.: date.strftime("%H%%%M")
print("rok podle ISO 8601", date.strftime("%G"))
print("den v týdnu podle ISO 8601", date.strftime("%u"))
print("týden v roce podle ISO 8601", date.strftime("%V"))
