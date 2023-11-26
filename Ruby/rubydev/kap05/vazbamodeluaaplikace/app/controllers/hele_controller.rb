class HeleController < ApplicationController
  def tady
    @data_asoc = params[:objekt]
    @zpracovatel = Zpracovatel.new @data_asoc[:metoda]
    @data = @zpracovatel.zpracovat
  end

  def vstup
  end
end
