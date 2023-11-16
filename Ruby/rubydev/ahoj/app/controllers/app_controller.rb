class AppController < ApplicationController
  KONSTANTA = "konstanta se nepíše jako final, ale první písmeno velkým.\n\
Konvence říká, že jsou velkým psaná všechna písmena"

  def index
    vypis
    prace_s_cisly
    prace_s_textem
    funkcionalita_HERE
    promenne
    vstup
    metoda_oddelovani_prvku_v_poli
  end

  Prvni_cislo = 657
  Druhe_cislo = 315

  def secti
    Prvni_cislo + Druhe_cislo
  end

  def odecti
    Prvni_cislo - Druhe_cislo
  end

  def vynasob
    Prvni_cislo * Druhe_cislo
  end

  def vydel
    Prvni_cislo / Druhe_cislo
  end

  def umocni
    Prvni_cislo ** Druhe_cislo
  end

  def vrat_zbytek
    Prvni_cislo % Druhe_cislo
  end

  def nejvetsi_spolecny_delitel a, b
    a = a.abs
    b = b.abs
    while b > 0
      c = a % b
      a = b
      b = c
    end
    return a
  end

  def prohozeni_cisel a, b
    print a, "\n", b, "\n"
    a = (a + b) - (b = a)
    print a, "\n", b, "\n"
  end

  def zobraz_pole
    pole = [1, 2, 3]
    puts pole
    pole = ["Líbám", "tě", "miláčku", 1, 2, 3]
    puts pole[0]
    puts pole[1]
    puts pole.length
    pole2 = Array.new
    puts pole2.length
    pole2[0] = "Banánové"
    pole2[1] = "rybičky"
    puts pole2[0] + " " + pole2[1]
    puts pole2.length
  end

  def nahrazovani_a_pridavani_do_pole
    pole = ["To", "si", "ho", "vyndej"]
    pole[1, 1] = "mi"
    puts pole
    pole[3, 0] = "ale", "fakt"
    puts pole
    pole2 = [0, 0, 0, 0]
    pole2[2, 2] = 1, 1
    puts pole2
  end

  def mapa
    mapa = { "key" => "value" }
    puts mapa.keys
    pizza = { "první vrstva" => "papričky", "druhá vrstva" => "klobásky" }
    puts pizza["první vrstva"]
    puts pizza
    puts pizza.length
    trzby = { "prvni_den" => 5.03, "druhy_den" => 15_003.00 }
    puts trzby["prvni_den"]
    puts trzby["druhy_den"]
  end

  def rozsahy
    # rozsah vypíšeme pomocí dvou teček
    numbers = 1..4
    puts numbers
    puts numbers.to_a
    # rozsah bez poslední položky je pomocí tří teček
    numbers = 1...4
    puts numbers.to_a

    dny = ["pondělí", "úterý", "středa", "čtvrtek", "pátek"]
    puts dny[0, dny.length - 1]

    letters = "a".."z"
    puts letters.to_a

    letters = "bublifuka".."bublifuke"
    puts letters.to_a
    puts letters.max
    puts letters.min
  end

  def next
    puts secti
    puts odecti
    puts vynasob
    puts vydel
    puts umocni
    puts vrat_zbytek
    a = 64
    b = 20
    puts "největší společný dělitel čísel #{a} a #{b} je #{nejvetsi_spolecny_delitel a, b}"
    prohozeni_cisel a, b

    puts "POLE, ty vole"
    zobraz_pole
    nahrazovani_a_pridavani_do_pole
    mapa
    rozsahy
  end

  def vypis
    puts 'nazdar prdi!!'
  end

  def prace_s_cisly
    puts 12345
    puts 3.1415
    puts 31415.0e-4
    puts 12_345_678_987_654_321
    puts 0xddff
  end

  def prace_s_textem
    puts "Ahoj"
    puts "Ahoj " + "tam"
    puts 'Rád vás vidím.'
    puts %Q/Jak se máte?/
    puts %Q!Dobře. A Vy?!
    puts %q!také dobře, děkuji.!
    puts "Musím říci: 'Mám se dobře.'"
    puts "Musím říci: \"vše je v pořádku.\""
  end

  def funkcionalita_HERE
    print <<ZDE
No a vše, co napíšu mezi tyto dva tagy
tak se zobrazí jako println
takže by takto šel psát souvislý text, bomba!
ZDE
  end

  def promenne
    teplota = 34
    puts "teplota je %d (tuto hodnotu získáváme z proměnné)" % [teplota]
    puts "jiný zápis nahrazování řetězce"
    puts "teplota je #{teplota} (tuto hodnotu získáváme z proměnné)"
    puts KONSTANTA
  end

  def vstup
    puts "zadej číslo:"
    gets.chomp # metoda chomp jen odebere znak odřádkování (\n)
    puts "zadal jsi #{$_}."
  end

  def metoda_oddelovani_prvku_v_poli
    pole = ["a", "b", "c", "d", "e"]
    carka_s_mezerou = ""
    pole.each do |i|
      print carka_s_mezerou + i.to_s
      carka_s_mezerou = ", "
    end
    puts

    # jiný zápis
    puts pole.join(", ")
  end
end
