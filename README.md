# 📨 📨 📨 Email 

### Project description

#### A simple microservice, where you can add email to DB, confirm it, control the process of confirming email.

### Features:

* ✅ add user`s email
* ✅ sending/receiving confirming email 
* ✅ control activation code
* ✅ update status

### 📝 List of technologies used in the project

* ✅ Intellij IDEA
* ✅ MySQL
* ✅ Spring Boot

### 📀 Preparing to launch a project

* ✅ Clone project (need to push Code button and choose in what way you want to get project)
* ✅ Open with IntelliJ IDEA (if you do not have this program - download it [here](https://www.jetbrains.com/idea/download/#section=mac))
* ✅ You will also need MySQL to this project. Setup instructions [here](https://www.youtube.com/watch?v=xaPuXh8IFIU) and [here](https://www.youtube.com/watch?v=ImqxBiv5yIY)
* ✅ So, we have Intellij, Browser(Safari, Google Chrome etc.) and MySql
* ✅ Find in [EmailSenderService](src/main/java/com/example/demo/service/EmailSenderService.java) method
**sendMail** and **setFrom** . Here you can write the mail from which notifications will be sent 
(for the test, you can take any email)
* ✅ Find in [application.properties](src/main/resources/application.properties) **spring.mail.username=** and **spring.mail.password**.
Here you can write your`s email login and password.
* ✅ Also you must set 
  * **spring.datasource.url=** (please write here URL of your`s DB). It must be created before. Look at third step
  * **spring.datasource.username=** (write here username from your`s DB)
  * **spring.datasource.password=** (write here password from your`s DB)
  * 
#### 📌 How the project works

1. Press **Run** button or **^R** in Intellij IDEA
2. Open two new windows in your browser
3. Type in first window: http://localhost:8080/user
4. Type in second window: http://localhost:8080/alert
5. In the **email** field and **retype email**, enter the email address to which you can receive the activation code 
for the test. It should be noted 
that at this stage a simple check for empty fields has been implemented. If you leave some field empty 
or the fields do not match or enter an email that is already in the database, you will receive a 
corresponding message
6. Go to http://localhost:8080/alert and in the **Check email** field enter the email you entered earlier, click 
the **Check info** button. You will receive information about your mail and status. 
7. Press the **RESET** button
8. Go to the first tab, in the **Email** field, enter your mail, in the **Activation code** field, 
enter the code that was sent to the mail. It should be noted that there is a check for the correctness of 
the entered activation code, which was received earlier. If you entered all the data correctly, confirmed your 
mail with an activation code, you will receive an email with congratulations on successfully adding to the database.
9. Go to the second tab, make sure that the data in the **INFORMATION** block is reset, if you see information 
from the previous steps, click the **Reset** button
10. In the **Check email** field, enter the email from the first steps and click the **Check info** button. 
You can see information about the status of the mail confirmation, and a detailed description of the errors 
if there are problems with the email confirmation
11. Press the **RESET** button


#### You can also see the information in MySQL in the Status columns and the extended description in the Description column. Status and description column depends on
* #### fullness of fields (cannot be missing fields)
* #### the identity of the entered data