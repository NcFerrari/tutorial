# frozen_string_literal: true

numbers = [4864, 464, 154, 58431, 48, 10, 84, 143, 31354, 444, 2134]

for number in numbers
  print number
end

puts

numbers.each do |number|
  print number
end

puts

for index in 0..5
  print index
end

puts

(0..5).each do |index|
  print index
end

puts

10.times do |index|
  print index
end