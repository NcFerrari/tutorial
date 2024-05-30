def my_function():
    print("achoj prdi")


my_function()


def count(a, b):
    return a + b


print(count(5, 8))


# defaultní hodnota v parametru
def function(name="Lubor"):
    print(f"Hello, {name}")


function("test")
function()


def values(items):
    [print(x) for x in items]


values([1, 2, 3])
values("slovo")
values({1, 2, 2, 4})
values((1, 2, 2, 4))


def preparedMethod():
    pass


"""
LAMBDA FUCTION
lambda je v pythonu funkce, která něco provede a bez slovíčka return vrátí výsledek. zapisuje se díky tomu na jeden řádek
"""

print("LAMBDA")

x = lambda a: a
print(x(4))

x = lambda a, b: a * b
print(x(4, 3))

x = lambda a: f"fuck you with {a}"
print(x("jméno"))


def faktorial(x):
    return x * faktorial(x - 1) if x > 1 else x


print(faktorial(5))

for i in range(1, 1000):
    print(i, ": ", faktorial(i))
