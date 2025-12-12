import pytest
import csv

@pytest.mark.parametrize("n1, n2, expected", [
    (1, 2, 3),
    (5, 3, 8),
    (-1, 1, 0),
    (0, 0, 0),
])
def test_add(n1, n2, expected):
    from src.calculator import Calculator
    calc = Calculator()
    result = calc.add(n1, n2)
    assert result == expected
@pytest.mark.parametrize("n1, n2, expected",[
    (5, 3, 2),
    (10, 5, 5),
    (0, 0, 0),
    (-1, -1, 0)
])
def test_subtract(n1, n2, expected):
    from src.calculator import Calculator
    calc = Calculator()
    result = calc.subtract(n1, n2)
    assert result == expected

# Uses a csv file to read test data




