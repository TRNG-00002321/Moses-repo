# To-Do List Manager: Create a program to add, view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file. Please use the following as well while writing code

from todo_list_Ops import add_task, view_tasks, mark_task, delete_task

user_choice = ''
while user_choice != '-1':
    user_choice = input(f"What would you like to do? (enter 1 for view, 2 for add task, 3 to mark, 4 to delete and -1 to end)\n")
    if user_choice == '1':
        view_tasks()
    elif user_choice == '2':
        add_task()
    elif user_choice == '3':
        mark_task()
    elif user_choice == '4':
        delete_task()
    elif user_choice == '-1':
        print("Exiting the program. Goodbye!")
    else:
        print("Invalid choice, please try again.")
