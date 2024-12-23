# Maven Project with PostgreSQL JDBC and Spring BCryptPasswordEncoder

This sample project is a template for Java programs using PostgreSQL JDBC and Spring Framework BCryptPasswordEncoder to encode passwords and authenticate user-login password. Both PostgreSQL JDBC and BCryptPasswordEncoder are managed by Maven. 

There are two sample programs: PasswordEncryption.java and WeBlog.java. 

## PasswordEncryption.java

The program shows how to use BCryptPasswordEncoder to encode passwords and how to authenticate user entered login password against the encoded password. 

This program depends on 

```
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-crypto</artifactId>
			<version>6.0.2</version>
        </dependency> 
```

which depends on the following two dependencies

```
   		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.20.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-jcl -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-jcl</artifactId>
			<version>2.20.0</version>
		</dependency>    
```       

Run the program and enter a password twice, it shows "authenticated" result. If you enter two different passwords, it shows "Failed authentication" output. 

## WeBlog.java

This program assumes a PostgreSQL server running on localhost with a student table. The connection information is hardcoded,

The program requires the following dependency: 

```
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.7.4</version>
			<scope>runtime</scope>
		</dependency>
```

The schema of the book table:

```
CREATE TABLE book ( 
    isbn varchar(13), 
    title varchar(100), 
    publisher varchar(50),
    genre varchar(25), 
    unit_price DECIMAL (10,2), 
    PRIMARY KEY (isbn)
);
```

This sample program also shows how to create, read, and write auto-increment attributes and how to read, write and display system time in db with PostgreSQL. 
