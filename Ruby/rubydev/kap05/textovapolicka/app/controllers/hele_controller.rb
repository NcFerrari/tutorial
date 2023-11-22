class HeleController < ApplicationController
  protect_from_forgery with: :exception
  def tady
    @data = params[:textField]
  end
end
