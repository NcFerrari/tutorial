def file_chooser(case):
    match case:
        case 1:
            return "$1_basics"
        case 2:
            return "$2_slicing_strings"
        case 3:
            return "$3_modify_strings"


fileName = "strings/" + file_chooser(3) + ".py"

with open(fileName, encoding="utf-8") as file:
    exec(file.read())
