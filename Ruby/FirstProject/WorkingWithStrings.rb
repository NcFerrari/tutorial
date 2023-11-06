# frozen_string_literal: true

phrase = "           Máme nějakou větu, kde jsou možná i nějaké stejné znaky"
puts phrase.upcase() # toUpperCase
puts phrase.downcase() # toLowerCase
puts phrase.strip() # trim
puts phrase.strip().length # length
puts phrase.include? "nějakou" # contains
puts phrase[12] # string.split("")[12]
puts phrase[12, 3] # substring(x, y)
puts phrase.index("možná") # indexOf
puts "spojování" + " řetězců"

puts "klasika".upcase()

puts "pokud chceme vložit číslo do výpisu, musíme ho přetypovat (třeba jako: " + 10.to_s + ")"