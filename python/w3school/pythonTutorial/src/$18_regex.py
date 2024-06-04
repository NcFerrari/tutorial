import re


# txt = "The rain in Spain"
#
#
# def regexFunction(x, *output):
#     if output == ():
#         print(x)
#     else:
#         print(output[0], x.start())
#
#
# regexFunction(re.search("^The.*Spain$", txt))
# regexFunction(re.findall("ai", txt))
# regexFunction(re.findall("Portugal", txt))
# regexFunction(re.search(r"\s", txt), ("The first white-space character is located in position:"))
# regexFunction(re.search("Portugal", txt))
# regexFunction(re.split(r"\s", txt))
# regexFunction(re.split(r"\s", txt, 1))
# regexFunction(re.sub("Spain", "Czech", txt))
# regexFunction(re.sub(r"\s", "9", txt))
# regexFunction(re.sub(r"\s", "9", txt, 2))
#
#
# # možné práce s Matcher outputem
# def regexGivenMatcher(regex):
#     return regex
#
#
# print(regexGivenMatcher(re.search(r"\bS\w+", txt)).span())
# print(regexGivenMatcher(re.search(r"\bS\w+", txt)).group())
#
# print("\nEXAMPLES\n")
# index = 1
# """
# 1) najít první (search) (buď najde nebo nenajde)
# 2) najít všechny (findall) (najde všechny)
# 3) nahradit (sub) (nahradí x výskytů)
# 4) vrátit všechno kromě hledaného (split) (rozdělí to dle x výskytů)
# """
#
#
# def najit(pat, mat):
#     global index
#     result = re.search(pat, mat)
#     if result:
#         print(index, result.group())
#     else:
#         print(index, "Even no one result")
#     index += 1
#
#
# najit(r"[a-z]", "Python is greater then Java")
# najit(r"[w]", "Python is greater then Java")
# najit(r"\d", "Python is 1st, Java is 2nd")
# najit(r"\D", "Python is 1st, Java is 2nd")
# najit(r"[a-zA-Z0-9_]", "Python is greater then Java")  # r"[a-zA-Z0-9_]"   je to samé jako:   r"\w"
# najit(r"\w", "Python is greater then Java")
# najit(r".", "Python is greater then Java")
# najit(r"^Python", "Python is greater then Java")
# najit(r"^Java", "Python is greater then Java")
# najit(r"Python$", "Python is greater then Java")
#
# najit(r"Java$", "Python is greater then Java")
# najit(r"great[a-z]*", "Python is greater then Java")
# najit(r"great[0-9]*", "Python is greater then Java")
# najit(r"great[0-9]+", "Python is greater then Java")
# najit(r"great[a-z]?", "Python is greater then Java")
# najit(r"[a-zA-Z]{7}", "Python is greater then Java")
# najit(r"C++|C#|Java", "Python is greater then Java")
#
# print("")
# index = 1
#
#
# def najitVse(pat, mat):
#     global index
#     result = re.findall(pat, mat)
#     if result:
#         print(index, result)
#     else:
#         print(index, "Even no one result")
#     index += 1
#
#
# najitVse(r"[a-z]", "Python is greater then Java")
# najitVse(r"[w]", "Python is greater then Java")
# najitVse(r"\d", "Python is 1st, Java is 2nd")
# najitVse(r"\D", "Python is 1st, Java is 2nd")
# najitVse(r"[a-zA-Z0-9_]", "Python is greater then Java")  # r"[a-zA-Z0-9_]"   je to samé jako:   r"\w"
# najitVse(r"\w", "Python is greater then Java")
# najitVse(r".", "Python is greater then Java")
# najitVse(r"^Python", "Python is greater then Java")
# najitVse(r"^Java", "Python is greater then Java")
# najitVse(r"Python$", "Python is greater then Java")
#
# najitVse(r"Java$", "Python is greater then Java")
# najitVse(r"great[a-z]*", "Python is greater then Java")
# najitVse(r"great[0-9]*", "Python is greater then Java")
# najitVse(r"great[0-9]+", "Python is greater then Java")
# najitVse(r"great[a-z]?", "Python is greater then Java")
# najitVse(r"[a-zA-Z]{3}", "Python is greater then Java")
# najitVse(r"C++|C#|Java", "Python is greater then Java")
#
# text = "Python is greater then Java"
# text = re.sub("Java", "Python", text)
# text = re.sub("Python", "Java", text, 1)
# print(text, "\n")


def validateEmail(mail):
    pat = (
        r"^[^.][a-zA-Z0-9+\"_-]+[.]?[a-zA-Z0-9+\"_-]+[^.]@{1}([^-][a-zA-Z0-9+.\"_-]+[^.][.]{1}([a-z]{2}|[a-z]{3}|name|museum)$)|[\[]?(([0-1][0-9][0-9][.][0-1][0-9][0-9][.][0-1][0-9][0-9][.][0-1][0-9][0-9])|([2][0-5][0-6][.][2][0-5][0-6][.][2][0-5][0-6][.][2][0-5][0-6]))[\]]?$")
    return re.search(pat, mail)


def isEmailValid(mail):
    if validateEmail(mail):
        return "Email is ok!"
    else:
        return "ERROR"


# isEmailValid("123456@seznam.kfdjklj")
# isEmailValid("")
# isEmailValid("lubor.pesek#post.cz")
# isEmailValid("lubor.pese@post")
# isEmailValid("lubor.pese@post.")
# isEmailValid("lubor@pesek@post.cz")
# isEmailValid("123456@674#ols")
# isEmailValid(".....@.....@....")
# isEmailValid("@@.@@.644")
# isEmailValid("lfjdsafk@@sdůfh.6456")
# isEmailValid("lubor.pesek@post.cz")
# isEmailValid("lubor.pesek@post.cz")

validMails = ("email@example.com",
              "firstname.lastname@example.com",
              "email@subdomain.example.com",
              "firstname+lastname@example.com",
              "email@123.123.123.123",
              "email@[123.123.123.123]",
              "\"email\"@example.com",
              "1234567890@example.com",
              "email@example-one.com",
              "_______@example.com",
              "email@example.name",
              "email@example.museum",
              "email@example.co.jp",
              "firstname-lastname@example.com")
# "much.”more\ unusual”@example.com",
# "very.unusual.”@”.unusual.com@example.com",
# "very.”(),:;<>[]”.VERY.”very@\\ \"very”.unusual@strange.example.com")
invalidMails = ("plainaddress",
                "#@%^%#$@#$@#.com",
                "@example.com",
                "Joe Smith <email@example.com>",
                "email.example.com",
                "email@example@example.com",
                ".email@example.com",
                "email.@example.com",
                "email..email@example.com",
                "あいうえお@example.com",
                "email@example.com (Joe Smith)",
                "email@example",
                "email@-example.com",
                "email@example.web",
                "email@111.222.333.44444",
                "email@example..com",
                "Abc..123@example.com")
# "”(),:;<>[\]@example.com",
# "just”not”right@example.com",
# "this\ is\"really\"not\allowed@example.com")

print("\n\nMAJÍ PROJÍT")
for mail in validMails:
    print(isEmailValid(mail), "\t", mail)

print("\n\nNEMAJÍ PROJÍT")
for mail in invalidMails:
    print(isEmailValid(mail), "\t", mail)
