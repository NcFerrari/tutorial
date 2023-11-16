class LoopsController < ApplicationController
  def while
    user_input
    user_input2
  end

  def for
    prvni_pouziti
    druhe_pouziti
    treti_pouziti
    puts prumer
    ctvrte_pouziti
    pate_pouziti
    seste_pouziti
    foreach
    nekonecny_cyklus
    priklad
    break_redo_next_alias_break_redo_continue
    obracena_cisla
  end

  def user_input
    while "q\n" != $_
      puts "kód běží..."
      puts $_ === "q"
      print "Ukončíte zadáním 'q' "
      gets
    end
    puts "konec"
  end

  def user_input2
    until "q\n" == $_
      puts "kód běží..."
      puts $_ === "q"
      print "Ukončíte zadáním 'q' "
      gets
    end
    puts "konec"
  end

  def prvni_pouziti
    for i in 1..10
      puts i
    end
  end

  def druhe_pouziti
    prisady = ["feferonky", "klobásku", "olivy"]
    print "vaše pizza obsahuje: "
    carka = ""
    for prisada in prisady
      print carka + prisada
      carka = ", "
    end
    puts
  end

  def treti_pouziti
    10.times do |i|
      print i.to_s + " "
    end
    puts
  end

  def prumer
    znamky = [88, 99, 73, 56, 87, 64]
    suma = 0
    for i in znamky
      suma += i
    end
    suma / znamky.length.to_f
  end

  def ctvrte_pouziti
    75.upto(88) do |i|
      print i.to_s + " "
    end
    puts
  end

  def pate_pouziti
    75.downto(63) do |i|
      print i.to_s + " "
    end
    puts
  end

  def seste_pouziti
    3.step(30, 3) do |i|
      print i.to_s + " "
    end
    puts
  end

  def foreach
    pole = [13, 21456, 4564, 44, 342434, 243, 437, 5, 4544534]
    pole.each do |i|
      print i.to_s + " "
    end
    puts
  end

  def nekonecny_cyklus
    loop do
      puts "ukončíš pomoci: exit"
      break if "exit" == gets.chomp
    end
  end

  def priklad
    ovoce = ["broskve", "melouny", "jablka", "pomeranče"]
    print "Nabízíme: "
    0.upto(ovoce.length - 1) do |i|
      print ovoce[i] + " "
    end
    puts
  end

  def break_redo_next_alias_break_redo_continue
    for i in 0..10
      print i
      if i == 5
        break
      end
    end
    puts

    for i in 0..10
      if i == 5
        next
      end
      print i
    end
    puts

    # redo by opakoval aktuální krok iterace
  end

  def obracena_cisla
    -10.upto(10) do |i|
      if i == 0
        next
      end
      puts "1/%d = %.2f" % [i, 1 / i.to_f]
    end
  end
end
