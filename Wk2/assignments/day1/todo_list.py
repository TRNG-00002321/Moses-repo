# To-Do List Manager: Create a program to add, view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file. Please use the following as well while writing code

import json
from flask import Flask

app = Flask(__name__)

#add

def add_task():
    with open("todo_list.json", "w") as file:
        to_do_list = json.load(file)
    try:
        name=input("Enter the task name: ")
        description=input("Enter the task description: ")
        task = {"name": name, "description": description}
        to_do_list.append(task)
        return "Thank you for your task"
    except:
        return "You need to enter invalid information"

# view task
def view_tasks():
    with open("todo_list.json", "r") as file:
        to_do_list = json.load(file)
    input_choice = input("Do you want to view all tasks? (y/n): ")
    if input_choice == "y":
        print(f"{'Name':<10}{'Description':<35}{'Status':<12}")
        print("-" * 60)
        for task in to_do_list:
            print(f"{task["name"]:<10}{task["description"]:<35}{task['status']:<12}")
    elif input_choice == "n":
        task_name = input(f"Please enter the name of he task you would like to see: ")
        for task in to_do_list:
            if task["name"].lower() == task_name.lower():
                print(f"{task["name"]:<10}{task["description"]:<35}{task['status']:<12}")
            else:
                print("Don't be stupid, you've enter the wrong name. BYE")
                break
    else:
        print("Don't be stupid, invalid choice!")


# mark task as complete of in complete
def mark_task():
    with open("todo_list.json", "w") as file:
        to_do_list = json.load(file)
    t_name = input(f"What task will you like to mark complete or incomplete: ")
    status = input("How will like to mark it? (complete/incomplete): ")
    try:
        task = list(filter(lambda t: t["name"].lower() == t_name.lower(), to_do_list))
        if task:
            task[0]["status"] = status
            print("Marked")
    except:
        print("Invalid entry, try again")


# delete tasks
def delete_task(t_list):
    with open("todo_list.json", "w") as file:
        to_do_list = json.load(file)
    t_name = input("Enter the name of task: ")
    return list(filter(lambda t: t["name"].lower() != t_name.lower(), to_do_list))
