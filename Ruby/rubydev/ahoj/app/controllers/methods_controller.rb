class MethodsController < ApplicationController
  def index
    obycejna_metoda
    metoda_s_parametrem nil
    metoda_s_vice_parametry 1, 2, 3
    metoda_podobna_trojteckove_syntaxi_pole "prvni_parametr", 1, 2, 3
    puts navratova_metoda 5, 3
    puts navratova_metoda2 5, 3
    metoda_provolavajici_predany_blok {}
    metoda_provolavajici_predany_blok { puts "to mi ho fakt vyndej" }
    metoda_provolavajici_predany_blok { cislo = 4 ** 2; puts cislo }
    metoda_s_podminkou_pro_zjisteni_bloku { puts "kurva fix" }
    parametry_a_blok 7, 8
    parametry_a_blok("test", 54) { puts "to mi ho ale fakt opravdu vyndej" }
    predavani_dat_do_bloku("alfa", "beta") {|parametr1, parametr2| puts parametr1, parametr2}
  end

  def obycejna_metoda

  end

  def metoda_s_parametrem parametr

  end

  def metoda_s_vice_parametry parametr1, parametr2, parametr3

  end

  def metoda_podobna_trojteckove_syntaxi_pole parametr1, *nula_az_x_parametru_v_poli

  end

  def navratova_metoda a, b
    return a + b
  end

  def navratova_metoda2 a, b
    a + b
  end

  def metoda_provolavajici_predany_blok
    yield
  end

  def metoda_s_podminkou_pro_zjisteni_bloku
    if block_given?
      yield
    end
  end

  def parametry_a_blok a, b
    puts a, b
    if block_given?
      yield
    end
  end

  def predavani_dat_do_bloku prvni_parametr, druhy_parametr
    if block_given?
      yield prvni_parametr, druhy_parametr
    end
  end

end
