# method declaration and definition
def main
  puts "ČUS PRDI!"
end

# method calling
main


def main(name)
  puts "hi %s" %[name]
end

main "Lubor"

# VÝŠE UVEDENÝ PŘÍKLAD PŘETÍŽENÍ SICE NĚJAK FUNGUJE, ALE TAKTO SE TO V RUBY NEDĚLÁ!

# Přetížení metod v ruby není. Namísto toho se definují výchozí hodnoty přímo v parametrech

def metoda(parametr, druhy_parametr = "výchozí hodnota")
  puts parametr + ", " + druhy_parametr
end

metoda("test1")
metoda("test2", "used!")


# Všechny metody jsou návratové a vrací (bez klíčového slova return) poslední hodnotu, ať je jakákoliv

def cube(number)
  number**3
end

puts cube(3)

# ale můžeme napsat return. V takovém případě metoda normálně vrátí to, co je v return. Zbytek metody bude ignorován
def navratova_metoda
  return "toto vrátí"
  puts "ovšem tohle"
  local_variable = "i tohle"
  puts "bude ignorováno"
end

puts navratova_metoda