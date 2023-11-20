# frozen_string_literal: true

require_relative '../modules/barva'
require_relative '../modules/attributes'

class Auto2
  include Attributes
  include Barva

  def initialize barva
    @barva = barva
  end
end
