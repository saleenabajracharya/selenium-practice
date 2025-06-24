
---

## Features Implemented

### 🔸 Selenium WebDriver Integration
- Launched and controlled browser using `ChromeDriver`
- Located elements via `By.id`, `By.name`, `By.cssSelector`, `By.xpath`, etc.

### 🔸 Test Classes
- **AppTest.java**: Basic app launch and login scenario
- **HelloTest.java**: Simple interaction with a form or page
- **CrossBrowserTestCase1.java**: Designed for running tests across multiple browsers
- **ConsoleLog.java**: Captures browser console logs
- **ElementPositionTest.java**: Verifies element position or layout
- **MockGeoLocation.java**: Fakes browser geolocation data for location-based testing
- **NetworkConditions.java**: Simulates different network speeds/conditions
- **Screenshot.java**: Captures full-page screenshots

### 🔸 Screenshot Testing
- Includes an example screenshot (`Applitool FullPage Screenshot.png`).

---

##  Prerequisites

- Java 8+
- Maven
- Chrome browser (and `chromedriver` in PATH)
- VS Code / IntelliJ / Eclipse (you used VS Code on Ubuntu 💻)

---

##  How to Run Tests

```bash
# Compile the project
mvn clean compile

# Run tests
mvn test
