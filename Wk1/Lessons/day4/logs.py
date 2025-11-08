# Loggings are record of events that happening in a software application.
# They provide a way to track the flow of a program and help in debugging and monitoring.

import logging

logging.basicConfig(level=logging.WARNING, format='%(asctime)s - %(name)s - %(levelname)s %(message)s')

logging.debug("This is a log")
logging.info("This is a log")
logging.warning("This is a log")
logging.error("This is a log")
logging.critical("Critical")


# Logging Levels: are used to indecate the severity of an event.
# DEBUG: Detailed information, typically of interest only when diagnosing problems.
# INFO: Confirmation that things are working as expected.
# WARNING: An indication that something unexpected happened, or indicative of some problem in the near future
# ERROR: Due to a more serious problem, the software has not been able to perform some function.
# CRITICAL: A serious error, indicating that the program itself may be unable to continue running.

logger.basicConfig(level=logging.DEBUG)
logger.debug("This is a debug message")
logger.info("This is an info message")
logger.warning("This is a warning message")
logger.error("This is an error message")
logger.critical("This is a critical message")

# Logging to a file
logging.basicConfig(filename='app.log', filemode='w', level=logging.warning, format='%(name)s - %(levelname)s - %(message)s')