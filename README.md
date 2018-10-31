# currency-addon-demo

This project is example of using [currency-addon](https://github.com/cuba-platform/currency-addon) component.

To view example we can create/edit entity Trade Item on screen **Trade Items**.
On create/edit screen we can exchange **sell amount** of **Trade Item** between USD/EUR/BTC/RUB currencies. 

## Project Customization


### Added Currency Descriptors
* Bitcoin (BTC)
* Euro (EUR)
* Russian Ruble (RUB)


### Added Demo Entity

[Trade Item](modules/global/src/com/company/addon/currency_demo/entity/TradeItem.java)


### Added Rate Samples
[SQL script](modules/core/db/init/postgres/30.create-db.sql)


### Added Trade Item Samples
[SQL script](modules/core/db/init/postgres/30.create-db.sql)


### Added Screens
* List of Trade Items
* Create / Edit Trade Item