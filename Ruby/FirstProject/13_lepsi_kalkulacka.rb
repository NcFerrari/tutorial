puts "Zadejte první číslo:"
first_number = gets.chomp.to_f
puts "Zadejte operátor:"
operator = gets.chomp
puts "Zadejte druhé číslo:"
second_number = gets.chomp.to_f

def sum(a, b)
  a + b
end

def dif(a, b)
  a - b
end

def multi(a, b)
  a * b
end

def div(a, b)
  a / b
end

def pow(a, b)
  a ** b
end

case operator
when "+"
  puts sum(first_number, second_number)
when "-"
  puts dif(first_number, second_number)
when "*"
  puts multi(first_number, second_number)
when "/"
  puts div(first_number, second_number)
when "pow"
  puts pow(first_number, second_number)
else
  puts "neznám takový operátor:("
end