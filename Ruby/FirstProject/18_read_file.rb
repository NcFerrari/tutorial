# frozen_string_literal: true
file_name = "18_persons.txt"

File.open(file_name, "r") do |file|
  puts file.read
end

puts

File.open(file_name, "r") do |file|
  puts file.readline
  puts file.readline
end

puts

File.open(file_name, "r") do |file|
  puts file.readchar
  puts file.readchar
  puts file.readchar
  puts file.readchar
  puts file.readchar
end

puts

File.open(file_name, "r") do |file|
  for line in file.readlines
    puts line
  end
end

puts

File.open(file_name, "r") do |file|
  file.readlines.each { |line|
    puts line
  }
end

puts

File.open(file_name, "r") do |file|
  puts file.readlines
end

puts

File.open(file_name, "r") do |file|
  puts file.readlines[2]
end

puts

file = File.open(file_name, "r")
puts file.read
file.close