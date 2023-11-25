# frozen_string_literal: true

class Zpracovatel
  attr_reader :zpracovat
  attr_writer :zpracovat

  def initialize data
    @zpracovat = data
  end
end
