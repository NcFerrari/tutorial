# frozen_string_literal: true

class Zpracovatel
  attr_accessor :zpracovat
  attr_accessor :vek

  def initialize data, vek
    @zpracovat = data
    @vek = vek
  end
end
