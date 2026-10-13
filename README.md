# File Integrity Checker

This is a Java-based cybersecurity project that uses SHA-256 hashing to detect changes to application log files. The program reads a log file, generates a hash, and saves it for future comparisons. If the file is modified, the program detects the change and displays a warning.

The project was built using Java and SHA-256 cryptographic hashing, with Git and GitHub for version control.

To run the program, download the repository, open it in VS Code, and run `FileIntegrityChecker.java`. You can modify `application.log` and run the program again to test whether the changes are detected.

Future improvements include monitoring multiple log files, adding a user menu, and improving security alerts.