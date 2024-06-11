import shutil
from pathlib import Path


def create_file():
    open("testFile.txt", "x")


def create_if_not_exists(file_path):
    if not Path().exists():
        Path(file_path).touch()
    else:
        print("soubor už existuje")


def write_into_file(file_path, text):
    if Path(file_path).exists():
        Path(file_path).write_text(text, "utf-8")


def append_to_file(file_path: str, added_text: str) -> None:
    file = Path(file_path)
    try:
        with file.open("a", encoding="utf-8") as file:
            file.write(added_text)
    except IOError as e:
        print(f"Došlo k chybě při přidávání do souboru: {e}")
    except Exception as e:
        print(f"Došlo k neočekávané chybě: {e}")


def read_file(file_path) -> None:
    file = Path(file_path)
    try:
        with file.open("r", encoding="utf-8") as file:
            print(file.read())
    except IOError as e:
        print(e)


def delete_file_or_dir(file_path) -> None:
    try:
        file = Path(file_path)
        if file.is_file():
            Path.unlink(file_path)
        elif file.is_dir():
            file.rmdir()
    except FileNotFoundError:
        print("Soubor/adresář neexistuje")
    except OSError:
        print("Adresář není prázdný. Přejete si jej vymazat i s obsahem? [y/n]")
        if input().lower() == "y":
            shutil.rmtree(file_path)


def folders():
    print("=============")
    print("create folder")
    single_directory = Path("folderA")
    if not single_directory.exists():
        single_directory.mkdir()
    print("create folders in folder")
    dir_name = "0"
    if not Path(dir_name).exists():
        Path(dir_name).mkdir()
    for i in range(1, 10):
        dir_name += "/" + str(i)
        directory = Path(dir_name)
        if not directory.exists():
            directory.mkdir()
    print("delete folder")
    single_directory.rmdir()
    print("delete folder with content")
    shutil.rmtree(Path("0"))
    print("list files in folder")
    for file in Path("").cwd().iterdir():
        print("\t", file.name, "[DIR]" if file.is_dir() else "")
    print("rename folder")
    single_directory = Path("test")
    single_directory.mkdir()
    single_directory.rename("test22")

    create_if_not_exists("testFile.txt")
    write_into_file("testFile.txt", "ěščřžýáíéůú")
    append_to_file("testFile.txt", "\npřidaný text")
    read_file("testFile.txt")
    delete_file_or_dir("testFile.txt")


folders()


def recursion(dir_name: Path, tabulator: str):
    append_to_file("output.txt", tabulator + "" + dir_name.name + "\n")
    directory = Path(dir_name)
    if directory.is_dir():
        for file in directory.iterdir():
            recursion(file, tabulator + "\t")


recursion(Path("D:/Dokumenty/Projekty"), "")
