require_relative '../modules/matika'
# require './app/modules/matika' <- absolutní cesta, jinak stejný zápis jako předchozí
require_relative '../modules/modul_pro_include'
require_relative '../modules/modul_se_tridou'

class ModulesController < ApplicationController

  include Matika
  include ModulProInclude
  include ModulSeTridou # potřebný include pro vytvoření nové instance třídy Calc - viz řádky 22-23

  def index
    Matika.count 5, 7
    count_jako_include 6, 7

    metoda_modulu
  end

  def trida
    ModulSeTridou::Calc.secti 7, 9

    o = Calc.new
    o.odecti 7, 4
  end

end
