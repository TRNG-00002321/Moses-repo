from random import randint

def speed():
    return randint(0, 100)  # Simulate speed in km/h
def alert():
    s = speed()
    if s<60 or s>100:
        return True
    return False

