from ctypes import HRESULT
from unittest.mock import Mock, patch
import unittest
from scr import total

class TestTotal(unittest.TestCase):
    def test_calculate_total(self ):
        # Create a mock object
        total.read = Mock()
        # total.read = MagicMock()
        # Configure the mock to return a specific list of prices
        total.read.return_value = [10.0, 20.0, 30.0]
        result = total.calculate_total('')
        self.assertEqual( result, 60.0)
        # Verify that the mock was called once with the expected argument
        total.read.assert_called_once_with('')

# Patch: using the patch
def test_calculate_total_with_patch(self):
    with patch('scr.total.read') as mock_read:
        # Configure the mock to return a specific list of prices
        mock_read.return_value = [15.0, 25.0, 35.0]
        result = total.calculate_total('')
        self.assertEqual(result, 75.0)

# Using the patch Decorator
@patch("uni_test.total.calculate_total")
def test_calculate_total_patch_decorator(self, mock_read_decorator):
    mock_read_decorator.return_value = [15.0, 25.5]
    result = total.calculate_total('')
    self.assertEauals(result, 50.0)


# @patch("unittest_test.total.read")
# def test_multiply_values(self, mock_read_decorator):
#     mock_read_decorator.return_value=[1,2,3,4]
#     with patch('unit_test.total.sum', )


# Test with side effect. Side effect changes the behavior 




