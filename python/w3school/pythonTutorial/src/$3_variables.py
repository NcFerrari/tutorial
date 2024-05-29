def file_chooser(case):
    match case:
        case 1:
            return "$1_basics"
        case 2:
            return "$2_names"
        case 3:
            return "$3_multiple_values"
        case 4:
            return "$4_output"
        case 5:
            return "$5_"
        case 6:
            return "$6_"


fileName = "variables/" + file_chooser(4) + ".py"

with open(fileName, encoding="utf-8") as file:
    exec(file.read())
