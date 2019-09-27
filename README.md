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

<?xml version="1.0" encoding="UTF-8"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
--><!-- The contents of this file will be loaded for each web application --><Context>

    <!-- Default set of monitored resources. If one of these changes, the    -->
    <!-- web application will be reloaded.                                   -->
    <WatchedResource>WEB-INF/web.xml</WatchedResource>
    <WatchedResource>WEB-INF/tomcat-web.xml</WatchedResource>
    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>

    <!-- Uncomment this to disable session persistence across Tomcat restarts -->
    <!--
    <Manager pathname="" />
    -->
   <Resource auth="Container" 
     driverClassName="oracle.jdbc.OracleDriver" maxIdle="5" maxTotal="10" maxWaitMillis="-1" name="jdbc/DB_NAME"    
     username="YOUR_USER_NAME" password="YOUR_PASSWORD" type="javax.sql.DataSource" 
     url="jdbc:oracle:thin:@YOUR_DOMAIN:1521:YOUR_ORACLE_SID"/>
</Context>
