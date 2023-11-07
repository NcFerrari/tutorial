# KLASICKÝ IF

ismale = true

if ismale
  puts "You are male"
else
  puts "You are female"
end

# VÍCE VĚTVÍ

def method(x)
  if x == 5
    puts "pět"
  elsif x == 3
    puts "tři"
  else
    puts "něco jiného"
  end
end

method(5)
method(3)
method(1)

# UNÁRNÍ ZÁPIS

def method2(x)
  x > 3 ? "velký" : "malý"
end

puts method2(3)

# OPERÁTORY
# ==
# !=
# <=
# >=
# <
# >
# !
# &&
# ||

def operators1(x)
  if x == 5
    puts "== ok"
  end
end

def operators2(x)
  if x != 5
    puts "!= ok"
  end
end

def operators3(x)
  if x <= 5
    puts "<= ok"
  end
end

def operators4(x)
  if x >= 5
    puts ">= ok"
  end
end

def operators5(x)
  if x < 5
    puts "< ok"
  end
end

def operators6(x)
  if x > 5
    puts "> ok"
  end
end

def operators7(x)
  if x < 5 && x > 0
    puts "&& ok"
  end
  if x < 5 and x > 0
    puts "&& ok"
  end
end

def operators8(x)
  if x == 3 || x == 1
    puts "|| ok"
  end
  if x == 3 or x == 1
    puts "|| ok"
  end
end

operators8(3)