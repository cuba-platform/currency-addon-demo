-- begin CURRENCYADDONDEMO_TRADE_ITEM
alter table CURRENCYADDONDEMO_TRADE_ITEM add constraint FK_CURRENCYADDONDEMO_TRADE_ITEM_ON_COST foreign key (COST_ID) references CURRADDON_CURRENCY(ID)^
create index IDX_CURRENCYADDONDEMO_TRADE_ITEM_ON_COST on CURRENCYADDONDEMO_TRADE_ITEM (COST_ID)^
-- end CURRENCYADDONDEMO_TRADE_ITEM
