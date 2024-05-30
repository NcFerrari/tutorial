# basic
a = 5
b = 3
if a > b:
    print("a is greater than b")

# else větev
if a > b:
    print("a is greater than b")
else:
    print("a is less than b")

x = 200
print(isinstance(x, int))


class test():
    def metoda(self):
        return 0


object = test()
print(isinstance(object, test))

# větvení
a = 1
if a == 0:
    print("a is zero")
elif a == 1:
    print("a is one")
elif a == 2:
    print("a is two")

# switch
match (a):
    case 0:
        print("a is zero")
    case 1:
        print("a is one")
    case 2:
        print("a is two")
