number_operators = Array["+", "-", "*", "/", "%", "pow"]
array_operators = Array["max", "min", "avg"]

def sum(number1, number2)
  number1 + number2
end

def diff(number1, number2)
  number1 - number2
end

def prod(number1, number2)
  number1 * number2
end

def share(number1, number2)
  number1 / number2
end

def modulo(number1, number2)
  number1 % number2
end

def pow(base, exp)
  # TODO
end

def max(array)
  # TODO
end

def min(array)
  # TODO
end

def avg(array)
  # TODO
end

puts "Zadejte operátor:"
op = gets.chomp().to_s

if number_operators.include? op
  puts "Napište první číslo:"
  num1 = gets.chomp().to_f
  puts "Napište druhé číslo:"
  num2 = gets.chomp().to_f

  case op
  when number_operators[0]
    result = sum(num1, num2)
  when number_operators[1]
    result = diff(num1, num2)
  when number_operators[2]
    result = prod(num1, num2)
  when number_operators[3]
    result = share(num1, num2)
  when number_operators[4]
    result = modulo(num1, num2)
  when number_operators[5]
    result = pow(num1, num2)
  end
elsif array_operators.include? op
  puts "Zadejte prvky do pole oddělené čárkami:"
  array = (gets.chomp().to_s).split","

  case op
  when array_operators[0]
    result = max(array)
  when array_operators[1]
    result = min(array)
  when array_operators[2]
    result = avg(array)
  end
end

puts result