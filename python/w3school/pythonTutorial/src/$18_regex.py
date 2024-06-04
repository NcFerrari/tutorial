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


