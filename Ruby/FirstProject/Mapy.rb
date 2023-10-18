mapa = {
  "key" => "value",
  :jinyZapis => "to mi ho vyndej",
  33 => "prostě si sem můžu dát cokoliv a kdykoliv",
  :map => {
    :test => "to mi ho opravdu vyndej"
  }
}

puts mapa["key"]
puts mapa[:jinyZapis]
puts mapa[33]
puts mapa[:map][:test]