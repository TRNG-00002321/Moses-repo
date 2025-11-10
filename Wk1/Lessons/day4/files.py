# Opening a file in read mode
file = open("fileExample.txt", "r")
# File Modes: w is for write mode, r is for read mode. x is for create mode, a is for append mode, t is for text mode, b is for binary mode.
content = file.read()
print(content)
# Closing the file
file.close()

# Anotther way to open a file using 'with' statement
with open("fileExample.txt", "r") as file:
    content = file.read()
    print(content)
#Reading line by line
with open("fileExample.txt", "r") as file:
    line1 = file.readline()
    line2 = file.readline()
    # Reading all lines
    lines = file.readlines()

# Iterating over lines: You can loop through a loop, line by line
with open("fileExample.txt", "r") as file:
    for line in file:
        print(line.strip())  # strip() removes leading/trailing whitespace

#Reading in chunks: Useful for large files
with open("fileExample.txt", "r") as file:
    while chunck := file.read(1024):
        print(chunck)

# writing to a file
import os
path = os.path.join("fileExample.txt")
with open(path, "a") as file:
    file.write("\nThis is a new line added to the file.")

with open("fileExample.txt", "w") as file:
    file.write("This will overwrite the existing content.\n")
    file.write("This will overwrite the existing content.\n")

# Appending to a file
with open("fileExample.txt", "a") as file:
    file.write("this line is appended to the file. \n")

# X mode: create a file, if the file already exists, it will raise an error.
try:
    with open("newfile.txt", "x") as file:
        file.write("This file is created in x mode.\n")
except FileExistsError:
    print("File already exists.")

# Writting a list of lines to a file
lines_to_write = ["Line 1\n", "Line 2\n", "Line 3\n"]
with open("fileExample.txt", "w") as file:
    file.writelines(lines_to_write)
    # Note: writelines does not add newline characters automatically.


# Writtng with string formatting, you can use f-strings or format method
name = "John"
age = 30
with open("fileExample.txt", "a") as file:
    file.write(f"My name is {name} and I am {age} years old.\n")
    file.write("My name is {} and I am {} years old.\n".format(name, age))

# Writting binary files, use wb mode to write binary data (eg: images, encoded content)
data = bytes([120, 3, 255, 0, 100])
with open("binaryfile.bin", "wb") as file:
    file.write(data)

# Assingment: 
# 1 Write a python script to copy the contents of one file to another file.
# 2. Write a python script to copy an image file from one location to another.
