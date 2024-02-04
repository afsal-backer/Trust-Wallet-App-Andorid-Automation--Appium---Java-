# TrustWallet Mobile App Test Automation Project

This repository contains mobile automation tests for the TrustWallet app, utilizing Appium with Java. The project aims to cover critical functionalities of the TrustWallet application.

Test cases can be found here: https://docs.google.com/spreadsheets/d/1msWG4R1PeheoS0A8RCeuw0sZvC4_faakkRDPXbkwFB8/edit?usp=sharing

Test cases marked in Green are currently automated. Test cases marked in yellow are identified to be automated later.

## Prerequisites

Before running the tests, ensure you have the following installed:
- Java JDK 11 or higher
- Maven
- Appium Server
- Android SDK
- Node.js

## Installation

Follow these steps to set up the environment:

1. **Install Node.js and npm**
   
   Download and install Node.js from [nodejs.org](https://nodejs.org/).

2. **Install Appium**
   
   Run `npm install -g appium` to install Appium globally.

3. **Set up Android SDK**

   Ensure that you have Android Studio installed and configured, with the necessary emulators or simulators set up. This project is configured to run on Pixel 6 API 33 device with OS verison 13.

4. **Install Java JDK**

   Download and install the Java Development Kit (JDK) from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager like Homebrew on macOS.

5. **Install Maven**

   Follow the installation instructions on the [Maven website](https://maven.apache.org/install.html).

6. **Clone the Repository**

   Clone this repository to your local machine using `git clone <repository-url>`.

7. **Configure the Project**

   Update the `src/test/java/appium/utils/AppiumDriverManager.java` file with your device/emulator/simulator details and application path.

## Running Tests

To run the tests, navigate to the project directory and execute the following command:

```bash
mvn clean test -DsuiteXmlFile=e2e.xml
```
    This will pick the E2E tests mentioned in the e2e.xml file and run them on the simulator.

## Reporting

    The project is configured with Allure report and screenshots are captured on failure. To open the report after test execution, run the command:

```bash
mvn allure:serve
```
