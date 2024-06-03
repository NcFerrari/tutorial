import random

x = 1  # int
y = 2.8  # float
e = 3e14  # float
z = 1j  # complex

print(type(x))
print(type(y))
print(type(z))
print(type(e))

# lehké přetypování
x = 1
a = float(x)
print(a)
a = 5.8
print(a)
x = int(a)
print(x, "\n")

# pro random číslo musíme naimportovat knihovnu, takže import java.util.Random = import random
print(random.randrange(1, 2))  # x = <1,2)
print(random.randint(1, 2))  # x = <1,2>
print(random.random())  # x = (0,1)
print(random.uniform(2.5, 10.8))  # x = (2.5, 10.8)
print(random.choice([1, 2, 3]))
print()
list = [1, 2, 3]
print(list)
print(random.shuffle(list))
print(list)