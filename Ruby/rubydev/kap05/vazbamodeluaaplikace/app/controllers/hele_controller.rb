class HeleController < ApplicationController
  def tady
    @data_asoc = params[:zpracovatel]
    @zpracovatel = Zpracovatel.new @data_asoc[:zpracovat]
    @data = @zpracovatel.zpracovat
  end

  def vstup
    @zpracovatel = Zpracovatel.new "Gagarencis"
  end
end
