def file_chooser(case):
    match case:
        case 1:
            return "$1_list_and_tuple"
        case 2:
            return "$2_loops"
        case 3:
            return "$3_set"


fileName = "collections/" + file_chooser(3) + ".py"

with open(fileName, encoding="utf-8") as file:
    exec(file.read())
