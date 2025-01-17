//package Pages.UserManagement;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Base.DriverManager;
//
//public class UserManagementPage extends DriverManager {
//
//    public UserManagementPage() {
//        PageFactory.initElements(webDriver.get(), this);
//    }
//
//    @FindBy(xpath = "//span[.='User Management']")
//    private WebElement userMgmtModule;
//
//    @FindBy(id = "listing-filter-toggle")
//    private WebElement filterUserManagement;
//
//    @FindBy(id = "search_name")
//    private WebElement filterNameUserManagement;
//
//    @FindBy(xpath = "//table")
//    private WebElement userManagementTable;
//
//    @FindBy(xpath = "//table/tbody/tr")
//    private List<WebElement> rows;
//
//    @FindBy(xpath = "//table/thead/tr/th")
//    private List<WebElement> headers;
//
//    // Click the User Management module
//    public void clickUserMgmt() {
//        userMgmtModule.click();
//    }
//
//    // Click the filter toggle button
//    public void clickFilterUserManagement() {
//        filterUserManagement.click();
//    }
//
//    // Enter a name in the filter input
//    public void enterFilterName(String name) {
//        filterNameUserManagement.sendKeys(name);
//    }
//
//    // Retrieve table data as a string
//    public String getTableDataAsString() {
//        WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(rows));
//
//        StringBuilder tableData = new StringBuilder();
//
//        // Add headers to the string
//        for (WebElement header : headers) {
//            tableData.append(header.getText()).append("\t");
//        }
//        tableData.append("\n");
//
//        // Add row data to the string
//        for (WebElement row : rows) {
//            List<WebElement> columns = row.findElements(By.xpath("td"));
//            for (WebElement column : columns) {
//                tableData.append(column.getText()).append("\t");
//            }
//            tableData.append("\n");
//        }
//
//        return tableData.toString();
//    }
//}

package Pages.UserManagement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;

public class UserManagementPage extends DriverManager {

    public UserManagementPage() {
        PageFactory.initElements(webDriver.get(), this);
    }

    @FindBy(xpath = "//span[.='User Management']")
    private WebElement userMgmtModule;

    @FindBy(id = "listing-filter-toggle")
    private WebElement filterUserManagement;

    @FindBy(id = "search_name")
    private WebElement filterNameUserManagement;

    @FindBy(xpath = "//table")
    private WebElement userManagementTable;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//table/thead/tr/th")
    private List<WebElement> headers;

    // Click the User Management module
    public void clickUserMgmt() {
        userMgmtModule.click();
    }

    // Click the filter toggle button
    public void clickFilterUserManagement() {
        filterUserManagement.click();
    }

    // Enter a name in the filter input
    public void enterFilterName(String name) throws InterruptedException {
        filterNameUserManagement.sendKeys(name);
        Thread.sleep(3000);
//        WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(rows));
    }

    // Retrieve table data as a list of lists (for comparison)
//    public List<List<String>> getTableDataAsList() {
//        // Collect all rows and columns as lists of strings
//        List<List<String>> tableData = new ArrayList<>();
//        for (WebElement row : rows) {
//            List<String> rowData = new ArrayList<>();
//            List<WebElement> columns = row.findElements(By.xpath("td"));
//            for (WebElement column : columns) {
//                rowData.add(column.getText());
//            }
//            tableData.add(rowData);
//        }
//        return tableData;
//    }
//    
 // Method to retrieve table data as a formatted string
//    public String getTableDataAsString() {
//        WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(rows));
//
//        // StringBuilder to store table data
//        StringBuilder tableData = new StringBuilder();
//
//        // Add table headers to the string
//        for (WebElement header : headers) {
//            tableData.append(header.getText()).append("\t");
//        }
//        tableData.append("\n");
//
//        // Add table row data to the string
//        for (WebElement row : rows) {
//            List<WebElement> columns = row.findElements(By.xpath("td"));
//            for (WebElement column : columns) {
//                tableData.append(column.getText()).append("\t");
//            }
//            tableData.append("\n");
//        }
//
//        return tableData.toString();
//    }

    
    public String getFilteredTableDataAsString() {
        WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));

        // Wait for the filtered rows to load
        wait.until(ExpectedConditions.visibilityOfAllElements(rows));

        StringBuilder tableData = new StringBuilder();

        // Add headers to the string
        for (WebElement header : headers) {
            tableData.append(header.getText()).append("\t");
        }
        tableData.append("\n");

        // Add row data to the string
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath("td"));
            for (WebElement column : columns) {
                tableData.append(column.getText()).append("\t");
            }
            tableData.append("\n");
        }

        return tableData.toString();
    }
    
    public List<WebElement> getRows() {
        return rows;
    }
}

