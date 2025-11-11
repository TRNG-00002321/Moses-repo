class Animal:
    def __init__(self, name):
        self.name = name
    
    def speak(self):
        print("Animal Speaks")

class Dog(Animal):
    def __init__(self, name, color):
        super().__init__(name)  # call the parent constructor
        self.color = color
    
    def speak(self):
        print(f"Dog {self.name} speaks")

    def describe(self):
        return f"Hi I am Dog {self.name} is and i love {self.color}"

animal = Animal("pipier")
animal.speak()

dog = Dog("ky", "Blue")
dog.speak()
print(dog.describe())
