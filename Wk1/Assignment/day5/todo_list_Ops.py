import json

#add
def add_task():
    try:
        # load the file first to avoid the json write mode overwritting the file.
        with open('todo_list.json', 'r') as file:
            to_do_list = json.load(file)  # file is save in the todoList to persist past data
    except (FileNotFoundError, json.JSONDecodeError):
        to_do_list = []
    name=input("Enter the task name: ")
    description=input("Enter the task description: ")
    status = "imcomplete"
    task = {"name": name, "description": description, 'status': status}
    to_do_list.append(task)
    try:
        with open("todo_list.json", "w") as file:
            json.dump(to_do_list, file, indent=4)
            return "Thank you for your task"
    except:
        return "Invalid Entry"

# view task
def view_tasks():
    with open("todo_list.json", "r") as file:
        to_do_list = json.load(file)

    input_choice = input("Do you want to view all tasks? (y/n): ").lower()

    if input_choice == "y":
        print(f"{'Name':<10}{'Description':<35}{'Status':<12}")
        print("-" * 60)
        for task in to_do_list:
            print(f"{task['name']:<10}{task['description']:<35}{task['status']:<12}")

    elif input_choice == "n":
        task_name = input("Please enter the name of the task you would like to see: ")
        found = False
        for task in to_do_list:
            if task["name"].lower() == task_name.lower():
                print(f"{task['name']:<10}{task['description']:<35}{task['status']:<12}")
                found = True
                break
        if not found:
            print("Task not found. Please check the name and try again.")

    else:
        print("Invalid choice! Please enter 'y' or 'n'.")

# mark task as complete of in complete
def mark_task():
    try:
        with open('todo_list.json', 'r') as file:
            to_do_list = json.load(file)
    except (FileNotFoundError, json.JSONDecodeError):
            to_do_list = []


    try:
        t_name = input(f"What task will you like to mark complete or incomplete: ")
        task = list(filter(lambda t: t["name"].lower() == t_name.lower(), to_do_list))
    except:
        print("Invalid entry, try again")

    if task:
        status = input("How will like to mark it? (complete/incomplete): ")
        task[0]["status"] = status
        print("Marked")
        with open("todo_list.json", "w") as file:
            json.dump(to_do_list, file, indent=4)
        print("Updated")
    else:
        print("Task not found. Please check the name and try again.")


# delete tasks
def delete_task():
    try:
        with open('todo_list.json', 'r') as file:
            to_do_list = json.load(file)
    except (FileNotFoundError, json.JSONDecodeError):
            to_do_list = []
    t_name = input("Enter the name of task: ")
    to_do_list = list(filter(lambda t: t["name"].lower() != t_name.lower(), to_do_list))
    try:
        with open('todo_list.json', 'w') as file:
            json.dump(to_do_list, file, indent=4)
            return "Task Deleted"
    except:
        return "Invalid Entry"
