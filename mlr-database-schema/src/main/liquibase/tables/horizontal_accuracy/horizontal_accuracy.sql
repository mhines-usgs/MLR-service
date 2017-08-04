create table mlr_data.horizontal_accuracy
(horizontal_accuracy_id		integer not null
,code							text constraint horizontal_accuracy_code_ck check (code in ('H', '1', '5', 'S', 'R', 'F', 'T', 'M', 'U'))
,name							text
,constraint horizontal_accuracy_pk
  primary key (horizontal_accuracy_id)
);
alter table mlr_data.horizontal_accuracy owner to mlr_data;