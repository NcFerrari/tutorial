# frozen_string_literal: true

puts "Zadej první číslo:"
first_number = gets.chomp.to_f
puts "Zadej druhé číslo:"
second_number = gets.chomp.to_f
puts "zadej operaci"
operation = gets.chomp

case operation
when "+"
  puts first_number + second_number
when "-"
  puts first_number - second_number
when "*"
  puts first_number * second_number
when "/"
  puts first_number / second_number
when "%"
  puts first_number % second_number
when "sqrt"
  puts Math.sqrt(first_number)
when "pow"
  puts first_number ** second_number
else
  # type code here
end