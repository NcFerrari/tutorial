class HeleController < ApplicationController
  def tady
    @data = params[:text1]
    @age = params[:age]
  end

  def vstup

  end
end
