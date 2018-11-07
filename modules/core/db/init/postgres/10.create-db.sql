-- begin CURRENCYADDONDEMO_TRADE_ITEM
create table CURRENCYADDONDEMO_TRADE_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DATE_ date not null,
    COST_ID uuid not null,
    --
    primary key (ID)
)^
-- end CURRENCYADDONDEMO_TRADE_ITEM
