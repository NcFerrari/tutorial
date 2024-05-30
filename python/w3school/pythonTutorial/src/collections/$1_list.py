# List (kolekce = pole)

list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(range(10))
print([x for x in range(10)])
[print(x) for x in range(10)]
list2 = ["one", "two", "three", "four", ""]

print(list2[1])
print(list2[-2])
print(list2[2:])
print(list2)
list2[4] = "bongo"
print(list2)
list2.insert(4, "tadá")
print(list2)

thislist = ["apple", "banana", "cherry"]
tropical = ["mango", "pineapple", "papaya"]
print(thislist)
thislist.extend(tropical)
print(thislist)

list.append(10)  # add()
print(list)
list.remove(8)  # remove()
print(list)
list.remove(list[8])
print(list)
# místo remove list[index] existuje metoda pop
list.pop(1)
print(list)
# pokud nezadáme parametr do metody pop(), tak se smaže poslední index
list.pop()
print(list)
print(7 in list)  # contains()
print(len(list))  # size()
print(list2)
list2.sort()
print(list2)
list2.sort(reverse=1)
print(list2)
list2.clear()
print(list2)

# list objektů
list1 = ["abc", 34, True, 40, "male"]
print(list1)

# copy reference
array1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
array2 = array1
array1.pop()
print(array2)

# copy values
array1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
array2 = array1.copy()
array1.pop()
print(array2)
