a = "acHoj pRdi!"
print(a.upper())  # toUpperCase()
print(a.lower())  # toLowerCase()
print(a.strip())  # trim()
print(a.replace("cH", "J").upper())  # replace
print(a.split(" "))  # split("")

# nejdou automaticky kombinovat stringy a jiné datové typy
age = 36
txt = "Můj věk je "
# toto je chyba
# print(txt + age)

# String.format() je tu kombinací String.format a logu
txt = f"Můj věk je {age}"
print(txt)

# počet desetinných míst ve výpise je stejný jako v javě
pi = 3.141592653589793
print(f"{pi:.2f}")
# nejde samostatně napsat print(pi:.2f)

# můžeme klidně i ve výpise takto počítat, prostě klasika
print(f"3 x 4 = {3 * 4}")
# bohužel by to nešlo napsat jednodušeji
# print("3 x 4 = " + (3 * 4))

# zpětné lomítko funguje jako v Javě i s klasickými zkratkami
print("toto bude\nnový řádek a tohle\t\tzase tabulátor")
print("ahoj\b")  # toto v javě není a je to kurva dobrý! \b smaže poslední znak (backspace)

# formátovaný výstup můžeme docílit i pomocí této syntaxe:
age = 36
txt = "My name is Lubor, and I am {}"
print(txt.format(age))