if 5>4
  puts "ah jo"
end

ismale = false

if ismale
  puts "you are male"
else
  puts "you are female"
end

number = 2

if number == 1
  puts "jedna"
elsif number == 2
  puts "dvě"
else
  puts "něco jiného"
end

prvni_vyraz = true
druhy_vyraz = true
treti_vyraz = false

if prvni_vyraz and druhy_vyraz
  puts "ok"
end

if treti_vyraz or prvni_vyraz
  puts "ok ok"
end

if !prvni_vyraz
  puts "neprojde"
else
  puts "projde"
end


# switch

def metoda(number)
  case number
  when 1
    puts "jedna"
  when 2
    puts "dvě"
  when 3
    puts "tři"
  else
    puts "jiné"
  end
end

metoda(1)
metoda(2)
metoda(3)
metoda(4)