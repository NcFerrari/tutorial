# frozen_string_literal: true

# while
index = 0
while index <= 10
  puts index
  index += 1
end


number = gets.chomp.to_i
index2 = number
while index2 <= number * 10
  puts index2
  index2 += number
end

i = 0
while i < 100
  puts i
  i += 1
  if i>50
    break
  end
end

# opakem while cyklu je until

j = 0
until j == 100
  print j
  j += 1
end