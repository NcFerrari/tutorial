x = 5
y = 0

try:
    print(x / y)
except ZeroDivisionError:
    print("Dělení nulou ty vopice!")
finally:
    print("klasika")

x = -1

if x < 0:
    raise Exception("prostě to hodí chybu")

x = "hello"

if not type(x) is int:
    raise TypeError("Only integers are allowed")
