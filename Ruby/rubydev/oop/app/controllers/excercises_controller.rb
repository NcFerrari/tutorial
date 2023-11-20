class ExcercisesController < ApplicationController

  def index
    prvni
    druhy
    treti
  end

  def prvni
    vozidlo = Vozidlo.new "hneda"
    puts vozidlo.vezmi_barva
  end

  def druhy
    vozidlo = Auto.new "červená"
    puts vozidlo.vezmi_barva
  end

  def treti
    vozidlo = Auto2.new "zelená"
    puts vozidlo.vezmi_barva
    puts vozidlo.vezmi_pocet_kol
  end
end
