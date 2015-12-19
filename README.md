# bikestore
spring data security mvc

ERD
===================
![ERD](https://github.com/iilkevych/bikestore/blob/master/doc/erd.png)

\+ Trigger Before Update on VOTES. It signals SQLSTATE '45000' if update is executed after 11am. (Optimistic strategy).

\+ ON DELETE CASCADE:
- ACCOUNT_ROLES.USER_ID > ACCOUNTS.ID
- MENUS.REST_ID > RESTAURANTS.ID
- DISHES.MENU_ID > MENU.ID
- VOTES.MENU_ID > MENU.ID
- VOTES.ACCOUNT_ID > ACCOUNTS.ID

JSON API
=========
/menus GET in-restaurantId out-List<Menu>
/menu POST in-Menu out-Status, DELETE in-menu out-Status
/top GET out-List<Menu>
/vote GET in-menuId out-Status
/restaurants GET out-List<Restaurant>
/restaurant POST in-Restaurant out-Status, DELETE in-RestaurandId out Status

#Notes
- Create users using test AccountServiceTest
- /login GET
- put X-CSRF-TOKEN into request header to test API
