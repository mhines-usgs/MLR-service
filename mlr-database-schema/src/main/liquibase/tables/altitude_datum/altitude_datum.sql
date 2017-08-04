create table mlr_data.altitude_datum
(altitude_datum_id		integer not null
,code							text constraint altitude_datum_code_ck check (code in ('NGVD29', 'NAVD88'))
,name							text
,constraint altitude_datum_pk
  primary key (altitude_datum_id)
);
alter table mlr_data.altitude_datum owner to mlr_data;