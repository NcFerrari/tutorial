# frozen_string_literal: true

class Person
  attr_accessor :name, :age

  def initialize(name, age)
    @name = name
    @age = age
  end

  def walk
    puts "i go!"
    return self
  end

end

class JumpPerson < Person
  def jump
    puts "i jump!"
  end
end

Person.new("maník", 33).walk
JumpPerson.new("hugo", 214).walk.jump