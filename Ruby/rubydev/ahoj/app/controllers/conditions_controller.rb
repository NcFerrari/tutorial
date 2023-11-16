class ConditionsController < ApplicationController

  def index
    zakladni_podminka
    negace_podminky
    switche_patri_do_pice
    switch_s_rozsahem
    jeste_jeden_switch
  end

  def zakladni_podminka
    teplota = 25
    if teplota > 30
      puts "příliš horko"
    elsif teplota < 20
      puts "příliš chladno"
    else
      puts "Čas na piknik!"
    end
  end

  def negace_podminky
    teplota = 25
    unless teplota < 20 || teplota > 30
      puts "Čas na piknik!"
    else
      puts "Pardon, dnes žádný piknik"
    end
  end

  def switche_patri_do_pice
    prikaz = "bublifuk"

    case prikaz
    when "Jdi"
      puts "jdu"
    when "Čekat"
      puts "čekám"
    when "Otočit"
      puts "otáčím se"
    when "Zastavit"
      puts "stojím"
    else
      puts "příkaz nenalezen"
    end
  end

  def switch_s_rozsahem
    teplota = 30

    case teplota
    when 0...20
      puts "příliš chladno"
    when 30...40
      puts "příliš horko"
    when 20...30
      puts "čas na piknik"
    else
      puts "teplota je mimo rozumný dosah"
    end
  end

  def jeste_jeden_switch
    temperature = 23

    message = case
             when (0...20).include?(temperature)
               "příliš chladno"
             when (20...30).include?(temperature)
               "čas na piknik"
             when (30...40).include?(temperature)
               "příliš horko"
             else
               "to mi ho vyndej"
             end
    puts message
  end
end
