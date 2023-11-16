# frozen_string_literal: true

class Car
  @@count = 0
  attr_reader :number

  def Car.get_count
    @@count
  end

  def initialize
    @@count += 1
    @number = @@count
  end
end
