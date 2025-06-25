## Features Implemented

### Selenium WebDriver Integration
- Launched and controlled browser using `ChromeDriver`
- Located elements via `By.id`, `By.name`, `By.cssSelector`, `By.xpath`, etc.
- Selenium Grid setup and remote test execution

### Test Classes
- **AlertExample.java** – Handles alert interactions on a webpage
- **DropdownTest.java** – Interacts with dropdown elements
- **MultipleBrowserTest.java** – Executes tests across multiple browsers using Grid
- **LoginTest.java** – Automates login form validation
- **FileUploadTest.java** – Automates file upload testing
- **Screenshot.java** – Captures current and full-page screenshots

### Screenshot Testing
- Includes sample screenshots like `screenshot.png` and `fullscreenshot.png`

---

## Prerequisites

- Java 11+
- Maven
- Selenium Server JAR (`selenium-server-4.33.0.jar`)
- Chrome, Firefox browsers installed
- WebDrivers (`chromedriver`, `geckodriver`) available in system PATH

---

## Setting Up Selenium Grid

### 1. Download Selenium Server

```bash
wget https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.33.0/selenium-server-4.33.0.jar
```

### 2. Start the Hub
```bash
java -jar selenium-server-4.33.0.jar hub
```
### 3. Start the node
```bash
java -jar selenium-server-4.33.0.jar node --detect-drivers true --hub http://localhost:4444
```

## Grid Dashboard
http://localhost:4444/ui



##  How to Run Tests

```bash
# Compile the project
mvn clean compile

# Run tests
mvn exec:java -Dexec.mainClass="com.seleniumdemo.MultipleBrowserTest"
```
