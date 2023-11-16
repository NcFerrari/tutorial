class Pes < Zvire
  def initialize barva, zvuk
    @zvire = Zvire.new barva
    @zvuk = zvuk
  end

  def get_zvuk
    @zvuk
  end
end