create table mlr_data.horizontal_datum
(horizontal_datum_id		integer not null
,code							text constraint horizontal_datum_code_ck check (code in ('urn:ogc:def:crs:OGC::CRS84'))
,name							text
,constraint horizontal_datum_pk
  primary key (horizontal_datum_id)
);
alter table mlr_data.horizontal_datum owner to mlr_data;