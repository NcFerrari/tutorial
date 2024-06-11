import json

x = '{"name":"Lubor", "age":33, "city":"Adamov"}'
y = json.loads(x)

print(y["age"])

x = {
    "name": "Lubor",
    "age": 33,
    "city": "Adamov"
}

y = json.dumps(x)
print(y)

print(json.dumps({"name": "John", "age": 30}))  # map (dict)
print(json.dumps(["apple", "bananas"]))  # list
print(json.dumps(("apple", "bananas")))  # tuple
print(json.dumps("hello"))  # string
print(json.dumps(42))  # int
print(json.dumps(31.76))  # float
print(json.dumps(True))  # boolean
print(json.dumps(False))  # boolean
print(json.dumps(None))  # null (None)

x = {
    "name": "John",
    "age": 30,
    "married": True,
    "divorced": False,
    "children": ("Ann", "Billy"),
    "pets": None,
    "cars": [
        {"model": "BMW 230", "mpg": 27.5},
        {"model": "Ford Edge", "mpg": 24.1}
    ]
}

print("JSON OUTPUT")
print("===========")
print(json.dumps(x))
print("===========\n\n")
print("JSON OUTPUT - BETTER READING")
print("===========")
print(json.dumps(x, indent=4))
print("===========\n\n")
print("JSON OUTPUT - BETTER READING změnit čárky na tečky a dvojtečky na rovnítka")
print("===========")
print(json.dumps(x, indent=4, separators=(". ", " = ")))
print("===========")

# setřízení json hodnot
print(json.dumps(x, indent=4, sort_keys=True))
