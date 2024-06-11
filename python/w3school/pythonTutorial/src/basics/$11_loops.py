i = 1
while i < 10:
    print(i)
    i += 1

while i < 15:
    print(i, "2nd")
    i += 1
    if (i == 13):
        break

while i < 20:
    i += 1
    if (i == 17):
        continue
    print(i, "3rd")

# break a continue jako normálně

"""
klasický for cyklus v Javičce:
for (int i = 0; i<10; i++) {
    System.out.println("i");
}

tož to samé v tom pythonu no
"""
for i in range(10):
    print(i)

for i in range(2, 6):
    print(i)

list1 = []
for i in range(3, 31, 3):
    list1.append(i)

print(list1)

# for each with method reference
"""
v Javičce:
list1.forEach(System.out::println);
"""
[print(x) for x in list1]
