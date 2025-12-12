from unittest.mock import Mock, patch
import pytest
from scr import total

# def test_with_mocker(mocker):
#     # Create a mock
#     mock_function = mocker.Mock(return_value=42)
#     # patch the module attribute
#     mocker.patch('module.function', return_value="mocked")
#
#     # patch an object method
#     mocker.patch.object(object, 'method', return_value="mocked")

def test_calculate_total_with_mocker(mocker):
    # Create a mock object
    mock_read = mocker.Mock()
    # Configure the mock to return a specific list of prices
    mock_read.return_value = [10.0, 20.0, 30.0]
    # Patch the read function in the total module
    mocker.patch('scr.total.read', mock_read)

    result = total.calculate_total('')
    assert result == 60.0
    # Verify that the mock was called once with the expected argument
    mock_read.assert_called_once_with('')















