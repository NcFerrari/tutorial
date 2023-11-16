class StatikaVsInstanceController < ApplicationController

  def index
    auto1 = Car.new
    auto2 = Car.new
    puts auto1.number
    puts auto2.number
    puts Car.get_count
    auto3 = Car.new
    puts auto1.number
    puts auto2.number
    puts auto3.number
    puts Car.get_count

    puts Matematika.sum 321, 6574
  end

end
