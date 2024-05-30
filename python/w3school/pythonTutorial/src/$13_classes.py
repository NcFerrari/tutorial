class Tree:
    x = 5


tree = Tree()


class Person:

    def __init__(self):
        print("vyliž mi")

    def __str__(self):  # toString()
        return "fuck you"


p1 = Person()
print(p1)
del p1
try:
    print(p1)
except NameError:
    pass


