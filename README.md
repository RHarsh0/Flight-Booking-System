# Flight Booking System
This is the fight booking application used to book the flight customer. It also has the backend side with Admin handeling it.

![logo](https://github.com/RHarsh0/mute-death-5036/assets/119388397/38c1d7b4-0e87-42a3-8b32-af6b8f2fa041)


## Tech Stacks
- Java
- Spring Framework
- MySQL

## Workflow Diagram
![Flight_Booking_System workflow diagram](https://github.com/RHarsh0/mute-death-5036/assets/119388397/ef0a08ce-8db1-4049-9544-2d3b6662d786)

+------------------------------------+
| Tables_in_flight_management_system |
+------------------------------------+
| admin                              |
| booking                            |
| cancelbooking                      |
| customer                           |
| flight                             |
+------------------------------------+


ADMIN
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| AdminId    | int          | NO   | PRI | NULL    | auto_increment |
| EmployeeId | int          | NO   |     | NULL    |                |
| Name       | varchar(255) | YES  |     | NULL    |                |
| Password   | varchar(255) | YES  |     | NULL    |                |
| Position   | varchar(255) | YES  |     | NULL    |                |
| Username   | varchar(255) | YES  |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+


FLGIHT
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| FlightNumber  | varchar(255) | NO   | PRI | NULL    |       |
| Arrival       | datetime(6)  | YES  |     | NULL    |       |
| ArrivalCity   | varchar(255) | YES  |     | NULL    |       |
| Departure     | datetime(6)  | YES  |     | NULL    |       |
| DepartureCity | varchar(255) | YES  |     | NULL    |       |
| price         | double       | NO   |     | NULL    |       |
| view          | bit(1)       | NO   |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+


booking
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| BookingId    | int          | NO   | PRI | NULL    | auto_increment |
| CustomerId   | int          | YES  | MUL | NULL    |                |
| FlightNumber | varchar(255) | YES  | MUL | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+


CANCELED BOOKING
+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| CancelationId | int          | NO   | PRI | NULL    | auto_increment |
| BookingId     | int          | NO   |     | NULL    |                |
| CustomerId    | int          | YES  | MUL | NULL    |                |
| FlightNumber  | varchar(255) | YES  | MUL | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+


CUSTOMER
+-------------+-------------------------------------+------+-----+---------+----------------+
| Field       | Type                                | Null | Key | Default | Extra          |
+-------------+-------------------------------------+------+-----+---------+----------------+
| CustomerId  | int                                 | NO   | PRI | NULL    | auto_increment |
| Age         | int                                 | NO   |     | NULL    |                |
| Name        | varchar(255)                        | YES  |     | NULL    |                |
| Nationality | varchar(255)                        | YES  |     | NULL    |                |
| Password    | varchar(255)                        | YES  |     | NULL    |                |
| Username    | varchar(255)                        | YES  | UNI | NULL    |                |
| gender      | enum('FEMALE','MALE')               | YES  |     | NULL    |                |
| kota        | enum('DISABILITY','NONE','STUDENT') | YES  |     | NULL    |                |
| view        | bit(1)                              | NO   |     | NULL    |                |
+-------------+-------------------------------------+------+-----+---------+----------------+
