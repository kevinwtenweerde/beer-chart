--
-- default grants
--
grant usage on schema beer to beer;
alter default privileges in schema beer grant usage on sequences to beer;
alter default privileges in schema beer grant select, insert, delete, update on tables to beer;
grant select, insert, delete, update on beer.schema_version to beer;