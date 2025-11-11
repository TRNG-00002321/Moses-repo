import json

#add
def save_task(task):
    try:
        # load the file first to avoid the json write mode overwritting the file.
        with open('todo_list.json', 'r') as file:
            to_do_list = json.load(file)  # file is save in the todoList to persist past data
    except (FileNotFoundError, json.JSONDecodeError):
        to_do_list = []
    to_do_list.append(task)
    try:
        with open("todo_list.json", "w") as file:
            json.dump(to_do_list, file, indent=4)
    except:
        return "Invalid Entry"

# view task

def load_todos():
    with open("todo_list.json", "r") as file:
        to_do_list = json.load(file)
    return to_do_list

# delete tasks
def delete_task(name):
    try:
        with open('todo_list.json', 'r') as file:
            to_do_list = json.load(file)
    except (FileNotFoundError, json.JSONDecodeError):
        to_do_list = []
    to_do_list = list(filter(lambda t: t["name"].lower() != name.lower(), to_do_list))
    with open('todo_list.json', 'w') as file:
        json.dump(to_do_list, file, indent=4)
