# resteasy4-boilerplate
RESTEasy 4 Boilerplate for Tomcat with MySQL/Oracle add-ons
Tested with 
- Eclipse IDE for Enterprise Java Developers 2019-09 R (4.13.0)
- Tomcat 9.0.24
- Oracle 12c
- MySQL 5.8
- JDK 1.8.0_221

When Tomcat server is up, test by using POSTMAN and send request to localhost:8080/resteasy4/customers

To configure a data source in Tomcat server, add the Resource definition in Context.xml. For instance
<Context>
  ......
   <Resource auth="Container" 
     driverClassName="oracle.jdbc.OracleDriver" maxIdle="5" maxTotal="10" maxWaitMillis="-1" name="jdbc/DB_NAME"    
     username="YOUR_USER_NAME" password="YOUR_PASSWORD" type="javax.sql.DataSource" 
     url="jdbc:oracle:thin:@YOUR_DOMAIN:1521:YOUR_ORACLE_SID"/>
</Context>
