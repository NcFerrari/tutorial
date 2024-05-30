def file_chooser(case):
    match case:
        case 1:
            return "$1_list"
        case 2:
            return "$2_loops"
        case 3:
            return "$3_"


fileName = "collections/" + file_chooser(1) + ".py"

with open(fileName, encoding="utf-8") as file:
    exec(file.read())
