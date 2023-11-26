class HeleController < ApplicationController
  protect_from_forgery with: :exception
  def tady
    @data = params[:textField]
    @age = params[:age]
  end
end
