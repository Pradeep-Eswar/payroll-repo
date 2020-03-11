# Webserver - Payroll System
Restfull API  Payroll System for a Employee based on JAX-RS using Eclipse Jersey

Implementation of a webserver which exposes an API to communicate with the payroll system. The implementation is based on Java with Java API for RESTful Web Services (JAX-RS) specification using Eclipse Jersey framework. 

The application is a simple payroll and accounting system accessible via an API. The domain of this system
contains staff members, which have an ID and a name. IDs will increase consecutively. There are be endpoints to add, remove, update and list staff members.

The system should allow getting payrolls for an employee for a certain period. A payroll can be of type fixed salary or hourly salary, which should be stored as attribute of the staff member. For hourly employees there should be an API to add a worklog and to set the hourly wage. For fixed employees it is possible to set the amount for the monthly salary.

Finally one can retrieve a json object with information about the money that should be paid out to an employee in a certain period.

UML Class diagram is added below which provides information about various classes.

![Payroll System for Staff Member](Payroll.jpg)
