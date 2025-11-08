# Creating Json
import json

my_data = {
    "name": "Alice",
    "age": 30,
    "city": "New York",
    "is_student": False,
    "courses": ["Math", "Science", "Art"],
}

# Open a file in write mode and use json.dump() to write the data to the file. if the file does not exist, it will be created.
# if the file exists, it will overwrite the existing content.

with open("data.json", "w") as json_file:
    # json.dump(data, jsonFile)
    json.dump(my_data, json_file, indent=4)  # indent for pretty printing

# Reading Json
# Open the file in read mode and use json.load() to read the data from the file
with open("data.json", "r") as json_file:
    data = json.load(json_file)
    print(data)
