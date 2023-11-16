# frozen_string_literal: true

class Jedinacek
  @@jedinacek = nil

  def Jedinacek.get_instance
    if @@jedinacek == nil
      @@jedinacek = new
    end
    @@jedinacek
  end

  private_class_method :new

  def pica
    puts "fakt kokotina tady"
  end
end
