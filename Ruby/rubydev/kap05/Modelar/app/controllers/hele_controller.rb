class HeleController < ApplicationController
  def tady
    @zpracovatel = Zpracovatel.new
    @data = @zpracovatel.zpracovat
  end
end
