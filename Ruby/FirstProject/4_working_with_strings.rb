# frozen_string_literal: true

phrase = "           Máme nějakou větu, kde jsou možná i nějaké stejné znaky"
puts phrase.upcase # toUpperCase
puts phrase.downcase # toLowerCase
puts phrase.strip # trim
puts phrase.strip.length # length
puts phrase.include? "nějakou" # contains
puts phrase[12] # string.split("")[12]
puts phrase[12, 3] # substring(x, y)
puts phrase.index("možná") # indexOf
puts "spojování" + " řetězců"

puts "klasika".upcase

puts "pokud chceme vložit číslo do výpisu, musíme ho přetypovat (třeba jako: " + 10.to_s + ")"

formatted_string = sprintf("formátovaný text %s", "jako v Javičce")
puts formatted_string

formatted_string = "dá se to psát zkratkou bez sprintf metody %s. Toto je vcelku dobré" %["jako třeba takto"]
puts formatted_string

formatted_string = "funguje i pro čísla (%d) samozřejmě" %[321]
puts formatted_string

formatted_string = "desetinná čísla lze psát klasicky jako třeba %.2f" %[Math::PI]
puts formatted_string

# jak vložit proměnnou do textu - druhý způsob, oproti formátovanému textu

variable = "nějaký text"
puts "tady bude text a ještě k tomu #{variable}"