
# Read numbers from a file and return them as a list of floats
def read(filename):
    with open(filename) as f:
        lines=f.readlines()
        return [float(lines.strip()) for line in lines]


# Calculate the total of numbers in a file
def calculate_total(filename):
    numbers=read(filename)
    return sum(numbers)

# Side effect method for handling negative numbers
def negative_check_side_effect(self, values):
    if any(v<0 for v in values):
        raise ValueError("Negative values not allowed")
    return sum(values)
