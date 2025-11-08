# Assingment: 
# 1 Write a python script to copy the contents of one file to another file.
with open("filecopy1.txt", "r") as source_file:
    content = source_file.read()
    print(content)

with open("filecopy2.txt", "w") as dest_file:
    dest_file.write(content)

# 2. Write a python script to copy an image file from one location to another. rb mode for reading binary files
with open("moses.jpg", "rb") as source_file:
    image_data = source_file.read()

with open("moses_photo/moses_copy.jpg", "wb") as dest_file:
    dest_file.write(image_data)
#

