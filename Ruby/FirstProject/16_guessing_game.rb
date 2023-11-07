# frozen_string_literal: true

secret_world = "abc"
input = ""
tries = 0
possible_tries = 3

until secret_world.eql?(input)
  if tries == possible_tries
    break
  end
  puts "Zadej heslo:"
  input = gets.chomp
  tries += 1
end

if input.eql?(secret_world)
  puts "HESLO JE SPRÁVNĚ!"
else
  puts "Překročil jsi počet pokusů. JSI BLOKLÝ!!"
end
