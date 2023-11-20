require_relative '../modules/matika'
# require './app/modules/matika' <- absolutní cesta, jinak stejný zápis jako předchozí
require_relative '../modules/modul_pro_include'

class ModulesController < ApplicationController

  include Matika
  include ModulProInclude

  def index
    Matika.count 5, 7
    count_jako_include 6,7

    metoda_modulu
  end
end
