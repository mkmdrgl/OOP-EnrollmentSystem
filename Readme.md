# OOP Enrollment System

### **Author**: Mika Madrigal

---

### **Description:**
The OOP Enrollment System is designed to manage all the necessary steps required to complete the
enrollment process.

### Final System Overview:
#### 1. System Architecture
* The system follows a Strict Interface Architecture, which separates the Business Logic (Implementations) from the 
User Interface (Main), allowing for enhanced operations and data management.

#### 2. Institutional Hierarchy
* **Departments**: The highest level of organization (e.g., College of Information Technology and Engineering). 
* **Sections**: Created under Departments with a specific name and a Maximum Capacity of 30. 
  * **Entities:**
    * **Instructors**: An instructor can be assigned to a specific section. 
    * **Students**: Multiple students can enroll in a section until the capacity is reached.

#### 3. Key Features
* **Student/Instructor/Course CRUD Operations**: Full ability to Add, View, Update, and Delete records. 
* **Tuition Management**: Calculates tuition fees based on units and processes payments with balance updates. 
* **Capacity Validation**: A safety feature that prevents enrollment once a section reaches 30 students.

#### 4. Exception Handling
* The system implements a try-catch blocks to ensure that the
system does not crash when encountering errors. 
  * **Exceptions:**
      * **Duplicate ID**
      * **Invalid User Input**
      * **Invalid Payment**
      * **Section at Full Capacity**

#### 5. JUnit Testing
* Automated testing is utilized to verify that the business logic performs as expected. The JUnit 5 framework was
used to run system tests.
  * **The AAA Pattern:**
    * **Arrange**
    * **Act**
    * **Assert**

---

### Early System Development Overview:

**1. Description**: Encapsulation

![scan.pn](src/main/resources/images/scan.png)
**1. Description**: Inheritance

**Person Class**
![Image](src/main/resources/Images/Person.png)

**Student Class**
![Image](src/main/resources/Images/Student.png)

**Instructor Class**
![Image](src/main/resources/Images/Instructor.png)

**Main Class**
![Image](src/main/resources/Images/Main.png)

**Output**
![Image](src/main/resources/Images/Output.png)

---

**2. Description: Abstraction**

**Person Class**
![Image](src/main/resources/Images/Person1.png)

**Student Class**
![Image](src/main/resources/Images/Student2.png)

**Instructor Class**
![Image](src/main/resources/Images/Instructor2.png)

**Main Class**
![Image](src/main/resources/Images/Main2.png)

**Output**
![Image](src/main/resources/Images/Output2.png)
