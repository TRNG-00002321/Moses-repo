#Filter and Reduce Assignment

#1. Filter Strings by Length
#Given a list of strings, use filter() to create a new list containing only the strings with a length greater than 5.
#Example
words = ["apple", "banana", "cat", "dog", "elephant", "frog"]

filter_names = list(filter(lambda x: len(x) > 5, words))
print(filter_names)

#2. Filter Students by Grade
#Given a list of dictionaries, where each dictionary represents a student with name and grade keys, use filter() to extract students with a grade of 90 or higher.
#Example
students = [
    {"name": "Alice", "grade": 85},
    {"name": "Bob", "grade": 92},
    {"name": "Charlie", "grade": 78},
    {"name": "David", "grade": 95}
]

higher_grades_stud = list(filter(lambda x: x["grade"] > 89, students))
print(higher_grades_stud)

#3. Concatenate Strings
#Given a list of strings, concatenate them into a single string using reduce.

from functools import reduce
#The function you pass to reduce() must take exactly two arguments because:
#reduce() combines elements pair by pair, step by step.
	
words = ["Python", "is", "awesome", "!"]
concat_string = reduce(lambda x, y: x +" "+ y, words)
print(concat_string)
	
#4. Find the Maximum Element
#Given a list of numbers, find the maximum element using reduce.
#Example:
numbers = [10, 3, 25, 7, 18]
maxNum = reduce(lambda x, y: x if x > y else y, numbers) #Could also use max(x,y)
print(maxNum)

#5. Flatten a List of Lists
#Given a list of lists, flatten it into a single list using reduce.
#Example:
list_of_lists = [[1, 2], [3, 4], [5, 6]]
single_list = reduce(lambda x, y: x + y, list_of_lists)
print(single_list)