class UsefullSyntaxeController < ApplicationController
  def prohozeni
    cislo1 = 4
    cislo2 = 7
    puts cislo1.to_s + ", " + cislo2.to_s
    cislo1 = (cislo1 + cislo2) - (cislo2 = cislo1)
    puts cislo1.to_s + ", " + cislo2.to_s
  end

  def nsd
    cislo1 = 25
    cislo2 = 70

    cislo1 = cislo1.abs
    cislo2 = cislo2.abs

    while cislo2 > 0
      local = cislo1 % cislo2
      cislo1 = cislo2
      cislo2 = local
    end
    puts cislo1
  end

  def sleepy
    10.times do |i|
      sleep(1)
      puts i
    end
  end

  def random
    cislo = rand
    cislo2 = rand(100)
    cislo3 = rand(5..10)
    puts cislo
    puts cislo2
    puts cislo3
  end

  def timing
    time = Time.now.to_f # sekundy
    puts time
    puts time * 1_000 # milisekundy
    puts time * 1_000_000 # mikro sekundy sekundy
    sleep(1)
  end
end
