# bikestore
spring data security mvc

ERD
===================
![ERD](https://github.com/iilkevych/bikestore/blob/master/doc/erd.png)


In addition data model contais one trigger. It checks updates on VOTES table and signals SQLSTATE '45000' if update is executed after 11am. (Optimistic strategy)