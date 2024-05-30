array = ["apple", "banana", "cherry"]

for item in array:
    print(item)

for index in range(len(array)):
    print(index)
    # print(i, array[i])
    # print("{}: {}".format(i, array[i]))

i = 0
while i < len(array):
    print(i)
    i += 1

# for each with method reference
"""
JAVA
array.forEach(System.out::println);
PYTHON
"""
[print(x) for x in array]

# Příklad:
# vyberte z listu ovocí taková ovoce, která obsahují písmena a
fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
selected_fruits = []

for fruit in fruits:
    if "a" in fruit:
        selected_fruits.append(fruit)

print(selected_fruits)

# řešení přes streams, kterým se v pythonu říká: comprehension
fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
selected_fruits = [fruit for fruit in fruits if "n" in fruit]
print(selected_fruits)
"""
pro zajímavost v JAVIČCE by to vypadalo takto:
List<String> fruits = Arrays.asList("apple", "banana", "cherry", "kiwi", "mango");
fruits.stream().filter(s -> s.contains("n")).forEach(System.out::println);
"""
