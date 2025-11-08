import math
from functools import reduce
# List of four or five numbers, calculate and print their squares

l1 = [2,4,6,8]


for num in l1:
    print(f" the square of the number is {num**2}")

# easy to achive this is usin the math function. Applies a give function. to each item in a iterable (list, tuple etc.)
squared_numbers = list(map(lambda x: math.pow(x,2), l1))
print(squared_numbers)

# Filter function: constructs an iterator from those elements of iterable for which function returns true.
# Create a list of numbers and print only the even numbers from the list
l2 = [1,2,3,4,5,6,7,8,9,10]
even_numbers = list(filter(lambda x: x % 2 == 0, l2))
print(even_numbers)

# Another way to do it using loop
evens = []
for n in l2:
    if n % 2 == 0:
        evens.append(n)

# Reduce function: Applies a function of two arguments cumulatively to the items of a sequence, from left to right, so as to reduce the sequence to a single value.
l3 = [1,2,3,4]
product = reduce(lambda x, y: x * y, l3)
print(product)
# Another way to do it using loop
prod = 1
for n in l3:
    prod *= n
print(prod)

# define two lists, first containing name and second containing age. Combine both lists into a turple of pairs using zip function.
# Zip function: makes an iterator that aggregates elements from each of the iterables.
names = ["Alice", "Bob", "Harry"]
ages = [24, 50, 18]
combined = list(zip(names, ages))
print(combined)

# Another way to do it using loop
combined_loop = []
for i in range(len(names)):
    combined_loop.append((names[i], ages[i]))
print(combined_loop)

# Unzip the list of tuples back into two lists using zip function.
unzipped_names, unzipped_ages = zip(*combined)
print(list(unzipped_names))
print(list(unzipped_ages))
