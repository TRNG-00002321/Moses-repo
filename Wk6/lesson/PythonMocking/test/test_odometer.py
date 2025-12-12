from unittest import TestCase
from unittest.mock import Mock
from scr import odometer


class Odometer_Test(TestCase):
    def test_odometer_normal(self):
        # Create a mock for the speed Function
        odometer.speed = Mock()

        # Configure
        odometer.speed.return_value =70
        # Test
        result = odometer.alert()
        # Verify
        self.assertFalse(result)
