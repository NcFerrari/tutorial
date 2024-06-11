import numpy as np

array = np.array(range(1, 10))
array2 = array.copy()
array[0] = 42

print(array)
print(array2)

print(array.base)
print(array2.base)

array = np.array(range(1, 10))
array2 = array.view()
array[0] = 42
array2[1] = 33

print(array)
print(array2)

print(array.base)
print(array2.base)
