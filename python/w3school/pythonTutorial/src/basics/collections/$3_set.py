"""
Set se chová stejně jako v Javě

Základní rozdíl na první pohled:
[] = list
() = tuple
{} = set
"""

set1 = {1, 2, 3, 4, 5, 6, 7, 4}
[print(x) for x in set1]
print(set1)
# print(set1[0]) -> stejně jako v Javě, nejde vybrat jen jeden index setu
# Do setu ale jde přidávat
set1.add(321)
print(set1)
# nebo ubírat
set1.remove(3)
print(set1)
# ale lepší je použít metodu discard(). Ta na rozdíl od remove() nevyhodí chybu, pokud item není v setu
set1.discard(3)
print(set1)

# dobrá možnost, jak zjistit duplicity v dvou setech :o
set1 = {"apple", "banana", "cherry"}
set2 = {"google", "microsoft", "apple"}

set3 = set1.intersection(set2)
print(set3)
