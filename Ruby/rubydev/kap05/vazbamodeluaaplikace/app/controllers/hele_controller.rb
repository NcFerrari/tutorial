class HeleController < ApplicationController
  def tady
    @data_asoc = params[:zpracovatel]
    @zpracovatel = Zpracovatel.new @data_asoc[:zpracovat], @data_asoc[:vek]
    @data = @zpracovatel.zpracovat
    @vek = @zpracovatel.vek
  end

  def vstup
    @zpracovatel = Zpracovatel.new "Gagarencis", 1024
  end
end
