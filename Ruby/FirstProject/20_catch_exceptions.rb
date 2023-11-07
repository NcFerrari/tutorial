# frozen_string_literal: true

array = [1, 58, 3, 5, 6, 43135]

begin
  array["dfsa"]
  num = 10 / 0
rescue ZeroDivisionError
  puts "nulou se nedělí"
rescue TypeError => e
  puts "špatný typ"
  puts e
end