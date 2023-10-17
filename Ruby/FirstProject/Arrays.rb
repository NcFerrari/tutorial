
hobbies = Array["matematika", "programování", "hry"]
puts hobbies
hobbies.clear

persons = Array.new
persons[0] = "Lubor"
persons[5] = "Magda"

puts persons
persons.clear

persons[persons.length] = "Lubor"
persons[persons.length] = "Magda"
puts persons

numbers = Array[2, 1, 5, 8]
puts numbers.sort
puts numbers.reverse
puts numbers
numbers = numbers.sort
puts numbers