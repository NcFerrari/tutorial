import re

txt = "The rain in Spain"


def regexFunction(x, *output):
    if output == ():
        print(x)
    else:
        print(output[0], x.start())


regexFunction(re.search("^The.*Spain$", txt))
regexFunction(re.findall("ai", txt))
regexFunction(re.findall("Portugal", txt))
regexFunction(re.search(r"\s", txt), ("The first white-space character is located in position:"))
regexFunction(re.search("Portugal", txt))
regexFunction(re.split(r"\s", txt))
regexFunction(re.split(r"\s", txt, 1))
regexFunction(re.sub("Spain", "Czech", txt))
regexFunction(re.sub(r"\s", "9", txt))
regexFunction(re.sub(r"\s", "9", txt, 2))


# možné práce s Matcher outputem
def regexGivenMatcher(regex):
    return regex


print(regexGivenMatcher(re.search(r"\bS\w+", txt)).span())
print(regexGivenMatcher(re.search(r"\bS\w+", txt)).group())

print("\nEXAMPLES\n")
index = 1
"""
1) najít první (search) (buď najde nebo nenajde)
2) najít všechny (findall) (najde všechny)
3) nahradit (sub) (nahradí x výskytů)
4) vrátit všechno kromě hledaného (split) (rozdělí to dle x výskytů)
"""


def najit(pat, mat):
    global index
    result = re.search(pat, mat)
    if result:
        print(index, result.group())
    else:
        print(index, "Even no one result")
    index += 1


najit(r"[a-z]", "Python is greater then Java")
najit(r"[w]", "Python is greater then Java")
najit(r"\d", "Python is 1st, Java is 2nd")
najit(r"\D", "Python is 1st, Java is 2nd")
najit(r"[a-zA-Z0-9_]", "Python is greater then Java")  # r"[a-zA-Z0-9_]"   je to samé jako:   r"\w"
najit(r"\w", "Python is greater then Java")
najit(r".", "Python is greater then Java")
najit(r"^Python", "Python is greater then Java")
najit(r"^Java", "Python is greater then Java")
najit(r"Python$", "Python is greater then Java")

najit(r"Java$", "Python is greater then Java")
najit(r"great[a-z]*", "Python is greater then Java")
najit(r"great[0-9]*", "Python is greater then Java")
najit(r"great[0-9]+", "Python is greater then Java")
najit(r"great[a-z]?", "Python is greater then Java")
najit(r"[a-zA-Z]{7}", "Python is greater then Java")
najit(r"C++|C#|Java", "Python is greater then Java")

print("")
index = 1


def najitVse(pat, mat):
    global index
    result = re.findall(pat, mat)
    if result:
        print(index, result)
    else:
        print(index, "Even no one result")
    index += 1


najitVse(r"[a-z]", "Python is greater then Java")
najitVse(r"[w]", "Python is greater then Java")
najitVse(r"\d", "Python is 1st, Java is 2nd")
najitVse(r"\D", "Python is 1st, Java is 2nd")
najitVse(r"[a-zA-Z0-9_]", "Python is greater then Java")  # r"[a-zA-Z0-9_]"   je to samé jako:   r"\w"
najitVse(r"\w", "Python is greater then Java")
najitVse(r".", "Python is greater then Java")
najitVse(r"^Python", "Python is greater then Java")
najitVse(r"^Java", "Python is greater then Java")
najitVse(r"Python$", "Python is greater then Java")

najitVse(r"Java$", "Python is greater then Java")
najitVse(r"great[a-z]*", "Python is greater then Java")
najitVse(r"great[0-9]*", "Python is greater then Java")
najitVse(r"great[0-9]+", "Python is greater then Java")
najitVse(r"great[a-z]?", "Python is greater then Java")
najitVse(r"[a-zA-Z]{3}", "Python is greater then Java")
najitVse(r"C++|C#|Java", "Python is greater then Java")

text = "Python is greater then Java"
text = re.sub("Java", "Python", text)
text = re.sub("Python", "Java", text, 1)
print(text)
