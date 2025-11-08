from functools import reduce
# 1. Create a dictionary of five countries and their capitals. Write a function that takes a country name as
# input and returns its capital.
countries = [
    {
        "country": "Liberia",
        "capital": "Monrovia"
    },

    {
        "country": "united States",
        "capital": "Washington DC"
    },

    {
        "country": "Ghana",
        "capital": "Accra"
    },

    {
        "country": "Nigeria",
        "capital": "Abuja"
    },
    {
        "country": "China",
        "capital": "Beljin"
    }
]

#
# def capital(countries):
#     try:
#         country = input(f"Please enter a country: ")
#         print(f"The capital is: {countries[country]['capital']}")
#     except:
#         print("Invalid enrty")
#
#
# capital(countries)

# 2. Make a dictionary of student names and their scores. Write a function to find the student with the highest score.
# students = [{"name": "Sally", "grade": 96}, {"name": "Mary", "grade": 60}, {"name": "Kay", "grade": 80}, {"name": "Jane", "grade": 88}, {"name": "Moses", "grade": 100}]
#
#
# def high_score(students_list):
#     student = reduce(lambda x, y: x if x["grade"] > y["grade"] else y, students_list)
#     print(student["name"])
#
# high_score(students)

# 3. Create a nested dictionary of three employees, each with keys for name, age, and salary. Write a function to give
# each employee a 10% raise and print the updated dictionary.
employees = {
    "emp1": {
        "name": "Sally",
        "age": 45,
        "salary": 70000
    },
    "emp2": {
        "name": "Mary",
        "age": 32,
        "salary": 65000
    },
    "emp3": {
        "name": "Kay",
        "age": 28,
        "salary": 72000
    }
}


def salary_raise(emp_list):
    for emp in emp_list.values():
        emp["salary"] *= 1.10


salary_raise(employees)
print(employees)


# 4. Write a Python program to add a key to a dictionary
# Sample Output
dictionary = {"Name": "Ram", "Age": 23}
#add_key = {"City" : "Salem"}
# dictionary = {'Name' : 'Ram', 'Age' : 23, 'City' : 'Salem'}
if "City" not in dictionary:
    dictionary["City"] = "Salem"

print(dictionary)


# 5. Write a Python program to concatenate following dictionaries to create a new one.
# Sample Output
dictionary1 = {"Name" : "Ram" , "Age" : 23}
dictionary2 = {"City" : "Salem", "Gender": "Male"}
# first option
concatenate_dictionaries = dictionary1 | dictionary2
# Second option
# concatenate_dictionaries = {**dictionary1, **dictionary2}
# concatenate_dictionaries = dict(dictionary1, **dictionary2)


print(concatenate_dictionaries)
#
# 6. Write a Python program to check whether a given key already exists in a dictionary.
# Sample Output
l1 = {'Name' : 'Ram', 'Age' : 23,}
key = "Name"
# Key is Available in the Dictionary
print("exist") if key in l1.keys() else print("non-exist")


# 75. Write a Python program to iterate over dictionaries using for loops.
# Sample Output
l2 = {
        "Name": "Ram",
        "Age": 23,
        "City": "Salem",
        "Gender": "Male"
      }

for key in l2:
    print(l2[key])
