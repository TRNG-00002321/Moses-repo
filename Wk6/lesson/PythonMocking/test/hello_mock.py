from unittest.mock import Mock

# Create a mock object for a weather API
# Mock: is an object that simulates the behavior of real objects in controlled ways.
wearther_api = Mock()

# Configure the mock to return a specific temperature
wearther_api.get_temperature.return_value = 25

# Use the mock object to get the temperature
temp = wearther_api.get_temperature("New York")

# you can assert the other attributes of the mock object
# Verify / asserting the mock was called with the expected argument
wearther_api.get_temperature.assert_called_once_with("New York")

