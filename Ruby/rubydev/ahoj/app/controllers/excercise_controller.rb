class ExcerciseController < ApplicationController
  def jedna
    pristup_k_poli
    dementni_mapa
    rozsah
  end

  def dva
    15.times do |i|
      puts faktorial i
    end

    tiskarna("kurva tento text!!!!!") { |argument| puts argument }

    puts prevadec_pole 1, 2, 3, 4
  end

  def pristup_k_poli
    pole = [1, 2, 3, 4, 5, 6, 7, 8]
    puts pole[-6]
  end

  def dementni_mapa
    mapa = { 0 => 1,
             1 => 2,
             2 => 3,
             3 => 4,
             4 => 5,
             5 => 6,
             6 => 7,
             7 => 8,
             -1 => 8,
             -2 => 7,
             -3 => 6,
             -4 => 5,
             -5 => 4,
             -6 => 3,
             -7 => 2,
             -8 => 1 }
    puts mapa[2]
  end

  def rozsah
    pole = 1..8
    puts pole.to_a
  end

  def faktorial cislo
    if cislo > 0
      cislo *= faktorial cislo - 1
    elsif cislo == 0
      cislo = 1
    else
      cislo = -1
      puts "faktoriál nesmí být záporný"
    end
    cislo
  end

  def tiskarna text
    if block_given?
      yield text
    end
  end

  def prevadec_pole arg1, arg2, arg3, arg4
    [arg1, arg2, arg3, arg4]
  end
end
