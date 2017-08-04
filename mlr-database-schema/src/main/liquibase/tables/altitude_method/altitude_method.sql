create table mlr_data.altitude_method
(altitude_method_id		integer not null
,code							text constraint altitude_method_code_ck check (code in ('A', 'D', 'G', 'L', 'M', 'N', 'R', 'U'))
,name							text
,constraint altitude_method_pk
  primary key (altitude_method_id)
);
alter table mlr_data.altitude_method owner to mlr_data;