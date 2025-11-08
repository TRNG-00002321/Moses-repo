# Append json data into a joson file, prompting user to enter data. Eg. Name, Age, School
import json
try:
    name = str(input(f"Enter your name: "))
    age = int(input(f"Enter your age: "))
    job = str(input(f"Enter your job: "))
    data = {
        "name": name,
        "age": age,
        "job": job
    }
except:
    print(f"invalid entry")

with open("data1.json", "a") as json_file:
    json.dump(data, json_file)


# Search for name in the json file, and return the details of that name.
with open("data1.json", "r") as json_file:
    for line in json_file:
        record = json.loads(line)
        if record["name"] == name:
            print(f"Details found: Name: {record['name']}, Age: {record['age']}, Job: {record['job']}")
            break
    else:
        print(f"No details found for the name: {name}")
    