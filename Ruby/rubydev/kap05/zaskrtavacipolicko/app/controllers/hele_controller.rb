class HeleController < ApplicationController
  def tady
    @data = params[:check]
  end

  def barva
    @data = params[:radiobutton]
  end

  def znacky
    @data = params[:select]
  end
end
