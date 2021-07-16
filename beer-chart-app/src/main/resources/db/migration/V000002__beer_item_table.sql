create table beer.beer_items
(
    id            serial not null primary key,
    name          varchar(30),
    style         varchar(30),
    abv           numeric,
    bottling_date date,
    ebc           int,
    ibu           int,
    description   varchar(2555)
);