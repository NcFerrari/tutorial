# frozen_string_literal: true

# File.open("19_persons.txt", "a") do |file|
#   file.write"\nMagdalena Baťková"
# end

# File.open("index.html", "w") do |file|
#   file.write"<html>\n<head>\n</head>\n<body>\n</body>\n</html>"
# end

File.open("index.html", "r+") do |file|
  file.readline()
  file.write("what?")
end

# Mode |  Meaning
# -----+--------------------------------------------------------
# "r"  |  Read-only, starts at beginning of file  (default mode).
#   -----+--------------------------------------------------------
# "r+" |  Read-write, starts at beginning of file.
#   -----+--------------------------------------------------------
# "w"  |  Write-only, truncates existing file
# |  to zero length or creates a new file for writing.
#   -----+--------------------------------------------------------
# "w+" |  Read-write, truncates existing file to zero length
# |  or creates a new file for reading and writing.
#   -----+--------------------------------------------------------
# "a"  |  Write-only, starts at end of file if file exists,
# |  otherwise creates a new file for writing.
#   -----+--------------------------------------------------------
# "a+" |  Read-write, starts at end of file if file exists,
# |  otherwise creates a new file for reading and
# |  writing.
#   -----+--------------------------------------------------------
# "b"  |  Binary file mode (may appear with
# |  any of the key letters listed above).
#   |  Suppresses EOL <-> CRLF conversion on Windows. And
# |  sets external encoding to ASCII-8BIT unless explicitly
# |  specified.
#   -----+--------------------------------------------------------
# "t"  |  Text file mode (may appear with
# |  any of the key letters listed above except "b").