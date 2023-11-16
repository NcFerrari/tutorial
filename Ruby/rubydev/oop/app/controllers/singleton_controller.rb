class SingletonController < ApplicationController
  def index
    variable = Jedinacek.get_instance
    variable.pica
  end
end
