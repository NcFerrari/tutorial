class HeleController < ApplicationController

  def tady
    zpracovatel = Zpracovatel.new
    zpracovatel.data = params[:zpracovatel][:data]
    puts zpracovatel.data
  end

end
