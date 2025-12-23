"""
Test navigation functionality using Python Selenium.

Implement tests that:
1. Navigate to https://the-internet.herokuapp.com/
2. Click on "Form Authentication" link
3. Verify URL changed to /login
4. Use back/forward navigation
5. Capture screenshots at key points
"""

from selenium.webdriver.common.by import By
import sys

sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver


def test_navigate_to_login_page():
    """
    Test: Navigate from home to login page

    Steps:
    1. Go to the-internet homepage

    2. Find and click "Form Authentication" link
    3. Assert URL contains "/login"
    4. Assert page contains "Login Page" heading
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        # Go to the-internet homepage
        driver.get("https://the-internet.herokuapp.com/")
        # Find and click "Form Authentication" link
        link = driver.find_element(By.LINK_TEXT, "Form Authentication")
        # click the link
        link.click()
        # Assert URL contains "/login"
        assert "/login" in driver.current_url
        # Assert page contains "Login Page" heading
        heading = driver.find_element(By.TAG_NAME, "h2")
        # assert heading text contains "Login Page"
        assert heading.text == "Login Page"

    pass


def test_back_forward_navigation():
    """
    Test: Browser navigation (back/forward)

    Steps:
    1. Navigate to homepage
    2. Click a link to go to another page
    3. Use driver.back() to return
    4. Assert you're on homepage
    5. Use driver.forward() to go forward
    6. Assert you're on the second page again
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        # Navigate to homepage
        driver.get("https://the-internet.herokuapp.com/")
        # Click a link to go to another page
        link = driver.find_element(By.LINK_TEXT, "Form Authentication")
        link.click()
        # Use driver.back() to return
        driver.back()
        # Assert you're on homepage
        assert driver.current_url == "https://the-internet.herokuapp.com/"
        # Use driver.forward() to go forward
        driver.forward()
        # Assert you're on the second page again
        assert "/login" in driver.current_url
    pass


def test_capture_screenshot():
    """
    Test: Screenshot capture

    Steps:
    1. Navigate to any page
    2. Take a full page screenshot
    3. Save it to screenshots/homepage.png
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        # Navigate to any page
        driver.get("https://the-internet.herokuapp.com/")
        # Take a full page screenshot
        driver.save_screenshot("screenshots/homepage.png")

    pass