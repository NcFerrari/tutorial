print("achoj prdi")
print('achoj prdi')

print("It's alright")
print("He is called 'Johny'")
print('He is called "Johny"')

print("let's try this \"word\"")

# string do proměnné
a = "hello"
print(a)

# víceřádkový string
text = """
nějaký text, který můžeme
v klidu odřádkovat
"""
print(text)

# stejně jako v ruby je string pole znaků
a = "achoj prdi!"
print(a[1])

# cyklus stringu
for x in "banana":
    print(x)

# String.length() = len()
a = "achoj prdi!"
print(len(a))

# String.contains() = ("v proměnné") in proměnná
txt = "The best things in life are free!"
print("free" in txt)
# Takže jednou je in v rámci cyklu, podruhé slouží pro podmínku, jako metoda: contains()
txt = "The best things in life are free!"
if "free" in txt:
    print("yes, 'free' is in txt")

# negace předešlého příkladu
if "fly" not in txt:
    print("no, there isn't word 'fly' in txt")
