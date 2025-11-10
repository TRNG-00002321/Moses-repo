
#1. Given two inputs that are stored in variables a and n, you need to print a, n times in a single line without space
# between them. Output must have a newline at the end.
def single(a, n):
    while n > 0:
        print(a, end="") # end="" removes the end of line
        n -= 1

#2. Given three inputs that are stored in the variables a, b, and c. You need to print a,  a times and b,  b times
# in a single line separated by c.
def tri_print(a, b, c):
    while a:
        print("a", end="")
        a-=1
    while c:
        print("c", end="")
        c-=1
    while b:
        print("b", end="")
        b-=1

#3. You need to perform three separate tasks based on the given input:
# String Input and Print: Take a text input as a string and print it as it is.
def str_add_float():
    user_input = input(f"Please enter you input (Int, String or float value): ")
    # Integer Input and Add: Take an integer input n, add 10 to it, and print the result
    try:
        user_input = int(user_input)
        print(user_input + 10 )
        return
    except ValueError:
        pass
    try:
        user_input = float(user_input)
        print(user_input * 10)
    except ValueError:
        pass
    # String Input and Print: Take a text input as a string and print it as it is.
    print(user_input)


#4. You are given two integer variables x and y. You need to perform the following operations:
#p = x + y : Addition
def add(a, b):
    return a+b

#q = x - y : Subtraction
def sub(a, b):
    return a-b

#r = x * y :Multiplication
def mul(a, b):
    return a*b

#s = x / y : Division
def mul(a, b):
    return a//b

#t = x % y : Modulo
def mul(a, b):
    return a%b

#5. Given two numbers a and b, you need to swap their values so a holds the value of b and b holds the value of a. Just write the code to swap values of a and b at the specified place.
def swapping(a, b):
    temp = a
    a = b
    b = temp


