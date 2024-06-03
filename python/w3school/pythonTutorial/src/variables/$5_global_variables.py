x = "global variable"


def function():
    x = "local variable"
    print("print", x)


function()

print("print", x)

# ====================================== NEXT POSSIBLE WAY ============================================
x = "global variable"


def function():
    global x
    print("print", x)
    x = "local variable"


function()

print("print", x)
