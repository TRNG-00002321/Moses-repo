
from unittest.mock import Mock
# Create a mock object
mock = Mock()

#
mock.api.return_value = {"id": 1, "name": "Test Item"}

# this will print the mock object representation
print(mock.api)          # Output: <Mock name='mock.api' id='...'>
print(mock.api())        # Output: {'id': 1, 'name': 'Test Item'}

