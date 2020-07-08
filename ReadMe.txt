
--- Team 3 Deliverable 4 ---

Football App

1. In MySQLWorkbench run the create.sql file.

2. Run the insert.sql file.

3. Go back to the source code and in the resources folder, edit the variables 
in db.properties following the guidline below:

    driverClass = (your jdbc driver)
    dbUrl = (the url of your sql database)
    user = (your database username)
    password = (your password for your database)

4. Create a new java project in your IDE.

5. Replace the src folder in your new project with the src folder from the source code.

6. Link the .jar jdbc driver as a library in the project structure.

7. Run App.java.

*** This was used with Java 11


Alternative Execution (Command-Line):
-------------------------------------
3. From the directory containing the src/ folder, run:

   > javac -d <dest> src/team3/del4/gui/*.java src/team3/del4/db/*.java
   
4. Then launch the app with:

   > java team3.del4.gui.App <driver> <url> <user> <password>
   
   As usual, this assumes the <dest> folder and location of <driver> are on the classpath.
   One can also copy src/resources/db.properties to <dest>/resources/db.properties
   and edit it as in #3 above to avoid providing that info on the command-line.



Individual Contributions
------------------------------------

Sam - Helped update the ER diagram. Recorded video for the ER diagram as well as the intro. Edited the videos together and uploaded the final video. Developed the get roster, get player stats, and get team stats functionality of the final program.

Kyle -

Robert - I did the video for the GUI interface and database functionality.   

Steven - Created initial java framework (DBConnector and basic StatGetter methods, App/AppFrame, and GUI template) and PlayerSelector. Finalized layout of stat editing UIs. Code walkthrough.


Video Link
------------------------------------
https://youtu.be/WbjTQb-wmow

