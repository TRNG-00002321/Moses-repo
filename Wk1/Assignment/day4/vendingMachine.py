#Coding Assignment
#If, Else, and Elif Problems

#Use your knowledge of if, elif, and else statements to complete this part of the problem. Your code should
#have an else statement that prints a message and ends the program using sys.exit() if the user does not enter a valid
#input number. 
#1.Your program should take an integer as an input from the user (either a 1, 2, or 3) that corresponds with an option
# for a drink from the vending machine outlined below and assign the corresponding price to a variable as a float.
#Vending Machine:
#1.water = $1.00
#2.cola = $1.50
#3.gatorade = $2.00
#2.After placing an order, the user should be prompted to enter inputs 4 times:
#1.The first time, the user should be prompted to enter the number of quarters they put in the machine. Assign this
#number to a variable as an integer.
#2.The second time, the user should be prompted to enter the number of dimes they put in the machine. Assign this
#number to a variable as an integer.
#3.The third time, the user should be prompted to enter the number of nickles they put in the machine. Assign this
#number to a variable as an integer.
#4.The fourth time, the user should be prompted to enter the number of pennies they put in the machine. Assign this
#number to a variable as an integer.
#3.Create a variable to hold the total value of all the coins the user has put into the machine.
#4.Use flow control statements to print the user's change or output a message asking the user to try again depending
#on whether the total value of the coins the user has put into the machine is enough to pay for the item they ordered.
#New knowledge for this problem:
#1.%f format specifier
#2.import sys and sys.exit()
#3.int()

# Prompt User to enter the coins
import sys

def prompt():
    quarters = int(input(f"Enter the number of quator")) * 0.25
    dimes= int(input(f"Enter the number of quator")) * 0.10
    nickles = int(input(f"Enter the number of quator")) * 0.5
    pennies = int(input(f"Enter the number of quator")) * 0.01

    return  quaters + dimes + nickles + pennies 

# The Tranaction is done here
def vend(d, m):
    if m >= drinks[d]["price"]:
        return "Thanks for your purchase, your change is: " (m - drinks[d]["price"])
    else:
        return "Sorry try again with correct amount"

# dict with the drinks 
drinks = {
    1: {"drink": "Water", "price": 1.00},
    2: {"drink": "Coke", "price": 1.50},
    3: {"drink": "Sprite", "price": 1.75}
}

# Program Driver
print(f" Wecolome: These are the drinks available: \n1. water = $1.00 \n2. cola = $1.50 \n3. Gatorade = $2.00")
user_choice = input("f Please enter the number that corresponds with your choice of drink: " )
if user_choice not in [1,2,3]:
    money = prompt()
    print(vend(user_choice, money))
else:
    print("You've Invalid chocice")
    sys.exit()
