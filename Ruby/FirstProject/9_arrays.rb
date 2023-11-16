# frozen_string_literal: true

friends = Array["Luba", "Roman", "Ondra", "Pavel"]

working_crazy_array = Array[123, "string", true, 8.3, nil]

puts friends[0]
puts friends[1,2]

friends[0] = "někdo jiný"
print friends
puts

friends[10] = "lol"
print friends
puts

puts friends.length

puts friends.include? "Roman"

print friends.reverse
puts

numbers = Array[5, 6, 7, 1]
print numbers
puts
print numbers.sort