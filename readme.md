# Spring JDBC Practicals Collection

This repository contains a set of 5 Spring JDBC practicals demonstrating core concepts from basic database connections to exception handling. These projects are configured for Maven and intended to be run in an IDE like Eclipse.

## Practicals Included

1.  **Practical 16: Connecting to Database Using Spring JDBC**
    * **Objective:** Establish a basic connection to a MySQL database using Spring's `JdbcTemplate` and XML configuration.
2.  **Practical 17: Inserting Data Using JdbcTemplate**
    * **Objective:** Perform a SQL `INSERT` operation using `JdbcTemplate` and a POJO, configured with XML.
3.  **Practical 18: Reading Data Using RowMapper**
    * **Objective:** Fetch multiple rows from a database and map them to a list of Java objects using a custom `RowMapper` and Java-based configuration (`@Configuration`).
4.  **Practical 19: Performing Batch Insert Using JdbcTemplate**
    * **Objective:** Insert multiple records efficiently in a single batch operation using `JdbcTemplate.batchUpdate` and Java-based configuration.
5.  **Practical 20: Handling Exceptions in Spring JDBC**
    * **Objective:** Demonstrate how Spring translates database-specific exceptions (like a `Duplicate entry`) into its own `DataAccessException` hierarchy.

---

## Requirements ⚙️

* **Java JDK:** Version 8 or 11+
* **IDE:** Eclipse IDE for Java EE Developers (or any IDE that supports Maven)
* **Database:** MySQL Server

---

## Setup and Run Guide 🚀

Follow these steps to get all projects running on your machine.

### 1. Database Setup

1.  **Start MySQL Server:**
    * **Windows:** Open `services.msc`, find the `MySQL` service, and click **Start**.
    * **Linux:** Open a terminal and run `sudo systemctl start mysql`.

2.  **Set Root Password:**
    * Log in to MySQL (you may not have a password set initially):
        ```bash
        mysql -u root -p
        ```
    * Set a new password. **Remember this password!**
        ```sql
        ALTER USER 'root'@'localhost' IDENTIFIED BY 'YourNewPassword';
        ```
    * Type `exit;` and log back in with your new password to test it.

3.  **Create All Databases & Tables:**
    * Log in to MySQL as root.
    * Copy and paste the **entire** SQL script below into the `mysql>` prompt:

    ```sql
    -- Create all required databases
    CREATE DATABASE IF NOT EXISTS testdb;
    CREATE DATABASE IF NOT EXISTS springdb;
    CREATE DATABASE IF NOT EXISTS hospitaldb;

    -- --- Table for Practical 17 & 20 (Uses 'springdb') ---
    USE springdb;
    CREATE TABLE IF NOT EXISTS students (
        id INT PRIMARY KEY,
        name VARCHAR(50),
        course VARCHAR(50),
        fee DOUBLE
    );

    -- --- Table for Practical 18 (Uses 'springdb') ---
    USE springdb;
    CREATE TABLE IF NOT EXISTS student (
        id INT PRIMARY KEY,
        name VARCHAR(50),
        department VARCHAR(50)
    );
    -- Insert sample data for P18
    INSERT IGNORE INTO student VALUES (101, 'Anjali', 'CS'), (102, 'Ravi', 'EC');

    -- --- Table for Practical 19 (Uses 'hospitaldb') ---
    USE hospitaldb;
    CREATE TABLE IF NOT EXISTS patients (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(50),
        age INT,
        disease VARCHAR(100)
    );
    ```

### 2. Project Setup in Eclipse

1.  **Import Projects:**
    * In Eclipse, go to **File > Import...**
    * Filter for "Maven" and select **Existing Maven Projects**.
    * Click **Browse...** and select the root folder where you unzipped all the practicals.
    * Make sure all projects are checked and click **Finish**.
    * Wait for Eclipse to download dependencies and build the projects.

2.  **Update Database Password (Crucial Step!)**
    * You must tell the code your MySQL password. You need to do this for **each** project.

    * **For Practicals 16 & 17 (XML Config):**
        * Open `src/main/resources/jdbc-config.xml` (or `beans.xml`).
        * Find the `password` property and set your password:
            ```xml
            <property name="password" value="YourNewPassword" />
            ```

    * **For Practicals 18, 19, & 20 (Java Config):**
        * Open `src/main/java/com/example/.../AppConfig.java`.
        * Find the `setPassword` method and set your password:
            ```java
            ds.setPassword("YourNewPassword");
            ```

### 3. Run the Practicals

For each project, find its main application file, right-click on it, and select **Run As > Java Application**.

* **P16:** `TestConnectionXML.java`
* **P17:** `App.java`
* **P18:** `ReadApp.java`
* **P19:** `MainApp.java`
* **P20:** `MainApp.java`
