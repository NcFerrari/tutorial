# frozen_string_literal: true

input = gets
puts input

puts "Zadej své jméno:"
input = gets.chomp()
puts "Nazdar %s!, jsi fakt bourák" %[input]
# metoda chomp() slouží k tomu, že dostaneme surový text a neodřádkujeme. Bez ní bychom nemohli s inputem dál pracovat