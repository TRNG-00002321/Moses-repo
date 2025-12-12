import pytest

def test_calculator():
    from src.calculator import Calculator
    calc = Calculator()

def test_add():
    # Test addition
    # Arrange
    n1, n2 = 1, 2
    # Act
    result = calc.add(n1, n2)
    # Assert
    assert result == 3

# Test subtraction
def test_subtract():
    # Arrange
    n1, n2 = 5, 3
    # Act
    result = calc.subtract(n1, n2)
    # Assert
    assert result == 2

# Test division by zero
def test_divide_by_zero():
    # Arrange
    Calculator calc = Calculator()
    n1, n2 = 5, 0
    # Act / Assert
    with pytest.raises(ZeroDivisionError):
        calc.divide(n1, n2)


