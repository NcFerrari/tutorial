puts "now (puts = output a odřádkování)"
print "ok, let's start (print = output bez odřádkování)\n"

a = 5
b = 4
puts(a, b)
a = (a + b) - (b = a)
puts(a, b)

number = 5
Integer number2 = 3
puts number + number2

name = "Lubor"
object = nil

puts(name.split("")[1])
puts name[2,4] + "ec"

puts name.include? "b"
puts name.index("r")

puts "OPERÁTORY"
puts 7 + 3
puts 7 - 3
puts 7 * 3
puts 7 / 3
puts 7 / 3.0
puts 7 % 3
puts 7 ** 3
incrementace = 5
puts "v ruby neexistuje zkrácený výraz jako incrementace++"
puts incrementace.next
puts incrementace.next.next