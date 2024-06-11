import numpy as np

arr = np.array([1, 2, 3, 4, 5])
print(arr)
print(np.__version__)

print(type(arr))

array0D = np.array(23)
array1D = np.array([1, 2, 3])
array2DList = np.array([[1, 2, 3], [4, 5, 6]])
array2D = np.array((("a", "b", "c"), ("fkjas", "fůdasj", "fkadjfůj")))
array3D = np.array([[[1, 2, 3], [4, 5, 6]], [[1, 2, 3], [4, 5, 6]]])

print(array0D.ndim)
print(array1D.ndim)
print(array2D.ndim)
print(array3D.ndim)

# vypiš mi všechna lichá čísla od 1 - 1000
obb = np.array(range(1, 1000))
print(obb[::2])
print(obb.dtype)

floatobb = obb.astype(float)
print(floatobb)