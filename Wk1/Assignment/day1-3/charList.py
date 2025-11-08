#Create a list containing 5 elements (anything). Based on this list, create another 
#list having elements from the previous list containing the character 'a'

words = ["apple", "banana", "mango", "corn", "orange", "aaa"]

def sameChar(l1):
    n = []
    for item in words:
        if "a" in item:
            n.append(item)
    
    return n

print(sameChar(words))

# List conprehansion:
newlist = [x for x in words if "a" in x]
print(newlist)

# Write a python program to input two numbers. Calculate and display their division.

def add(a, b):
    try:
        result =  a // b
    except:
        print(f"Cannot be devided by zero")
    else:
        print(f"the result will just be {result}" )

add(10, 0)


