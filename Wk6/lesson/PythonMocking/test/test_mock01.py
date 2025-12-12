import unittest
from unittest.mock import Mock

def greet(func):
    return "Hello, " + func()

class TestMockBasic(unittest.TestCase):
    def test_mock_return_value_and_assert_call(self):
        fake_func = Mock(return_value="World")
        result = greet(fake_func)
        # Behavior check
        self.assertEqual(result, "Hello, World")
        #  Validation: was the mock called once?
        fake_func.assert_called_once()
        # Alternative validation method
        fake_func.assert_called_once_with()


if __name__ == '__main__':
    unittest.main()