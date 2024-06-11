import modules.math as math
import modules.currentTime as myTime
import platform

print(math.faktorial(5))
print(myTime.currentTime())
print(myTime.currentTimeInMillis())

x = dir(myTime)
print(x)

x = dir(platform)
print(x)
