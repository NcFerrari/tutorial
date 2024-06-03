x, y, z = "Orange", "Banana", "Cherry"
print(x)
print(y)
print(z)

x = y = z = "Orange"
print(x)
print(y)
print(z)

fruits = "apple", "banana", "cherry"
x, y, z = fruits
print(x)
print(y)
print(z)

# list (klasická kolekce, která se ale zapisuje jako pole)
list = [1, 2, 3]
print(list)
list.append(4)
print(list)
print(list[2])
# tuple (n-tice prvků, která může být v kulatých závorkách, ale nemusí. Rozdíl mezi tuple a listem je v tom, že
# list je mutable (měnitelný) a tuple je imutable (neměnitelný)
tuple = "alfa", "beta", "gama"
# tuple = ("alfa", "beta", "gama") stejný zápis
print(tuple)
# tuple.append("delta") by hodil chybu
print(tuple[2])
