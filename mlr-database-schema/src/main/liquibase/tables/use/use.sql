create table mlr_data.use
(use_id		integer not null
,rank							text
,code							text
,name							text
,constraint use_pk
  primary key (use_id)
);
alter table mlr_data.use owner to mlr_data;