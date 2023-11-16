# frozen_string_literal: true

name = "Roman"
age = 35

puts "existuje muž, jehož jméno je " + name
puts "je mu " + age.to_s + " let"
puts "opravdu se mu líbí jméno " + name
puts "ale nelíbí se mu, že je mu " + age.to_s

i = 0
puts i
i += 1
puts i
# i++ doesnt exists in ruby


a = 5
b = 3
puts a, b

# prohození proměnných
c = a
a = b
b = c
puts a, b

d = 8
e = 1
puts d, e
d = d + e - (e = d)
puts d, e