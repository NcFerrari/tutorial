# frozen_string_literal: true

puts "Enter a color:"
color = gets.chomp
puts "Enter a plural noun:"
plural_noun = gets.chomp
puts "Enter a celebrity:"
celebrity = gets.chomp

puts "Roses are %s" %[color]
puts "%s are blue" %[plural_noun]
puts "I love %s" %[celebrity]