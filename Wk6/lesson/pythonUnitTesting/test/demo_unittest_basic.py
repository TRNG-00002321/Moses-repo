import sys
import unittest
from calendar import setfirstweekday

from src.calculator import Calculator

class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.calc = Calculator()


    def tearDown(self):
        self.calc = None

    def test_add(self):
        # Arrange
        n1=1
        n2=2
        # Act
        result = self.calc.add(n1, n2)
        # Assert
        self.assertEqual(result, 3)

    @unittest.skip("Demonstrating unconditional skipping")
    def test_unconditional_skip(self):
        self.fail("This test should be skipped")

    @unittest.skipIf(sys.platform == "win32", "Skipping on Windows")
    def test_skip_on_windows(self):
        self.fail("This test should be skipped on Windows")

    def test_subtract(self):
        # Arrange
        n1=5
        n2=3
        # Act
        result = self.calc.subtract(n1, n2)
        # Assert
        self.assertEqual(result, 2)

    def divide_by_zero(self):
        # Arrange
        n1=5
        n2=0
        # Act / Assert
        with self.assertRaises(ValueError):
            self.calc.divide(n1, n2)
