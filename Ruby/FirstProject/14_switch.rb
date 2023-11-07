def day_of_week(day)
  case day
  when "mon"
    puts "Monday"
  when "tue"
    puts "Tuesday"
  when "wed"
    puts "Wednesday"
  when "thu"
    puts "Thursday"
  when "fri"
    puts "Friday"
  when "sat"
    puts "Saturday"
  when "sun"
    puts "Sunday"
  else
    # type code here
  end
end

day_of_week(gets.chomp)