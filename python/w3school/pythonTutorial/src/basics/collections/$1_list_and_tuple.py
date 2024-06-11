# List (kolekce = pole)

listArray = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(range(10))
print([x for x in range(10)])
[print(x) for x in range(10)]
listArray2 = ["one", "two", "three", "four", ""]

print(listArray2[1])
print(listArray2[-2])
print(listArray2[2:])
print(listArray2)
listArray2[4] = "bongo"
print(listArray2)
listArray2.insert(4, "tadá")
print(listArray2)

thislist = ["apple", "banana", "cherry"]
tropical = ["mango", "pineapple", "papaya"]
print(thislist)
thislist.extend(tropical)
print(thislist)

listArray.append(10)  # add()
print(listArray)
listArray.remove(8)  # remove()
print(listArray)
listArray.remove(listArray[8])
print(listArray)
# místo remove list[index] existuje metoda pop
listArray.pop(1)
print(listArray)
# pokud nezadáme parametr do metody pop(), tak se smaže poslední index
listArray.pop()
print(listArray)
print(7 in listArray)  # contains()
print(len(listArray))  # size()
print(listArray2)
listArray2.sort()
print(listArray2)
listArray2.sort(reverse=1)
print(listArray2)
listArray2.clear()
print(listArray2)

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

# rozdíl na první pohled je v závorkách
# funkční rozdíl je v tom, že nejdou měnit hodnoty (je to v podstatě tedy pole, kde ani nejdou měnit indexované položky)
tupleArray = (1, 2, 3, 4, 5, 6, 7, 8, 9)

# ale samozřejmě existuje postup, jak to změnit nějak jde :)
list_from_tuple = list(tupleArray)
list_from_tuple.pop()
tupleArray = tuple(list_from_tuple)
print(tupleArray)