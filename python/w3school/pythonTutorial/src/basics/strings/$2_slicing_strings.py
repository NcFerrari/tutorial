# metoda String.substring(int, int) = string[int:int]

b = "achoj prdi!"
print(b[2:5])  # znaky od pozice <2,5), takže první začátek je zahrnut, konec už ne

# pokud začínám od první pozice, můžu nulu vynechat
print(b[:5])
# to samé platí i, pokud směřuji až ke konci
print(b[6:])

# negativní čísla značí pozici znaku ODZADU
print(b[-2])  # vrátí předposlední znak

# pokud budu chtít poslední 3 znaky od konce, můžu napsat
print(b[len(b) - 3:len(b)])  # vybrání posledních 3 znaků
# nebo
print(b[-3:])