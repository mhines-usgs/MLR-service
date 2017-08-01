create table mlr_data.monitoring_location
(monitoring_location_id			integer not null
,primary_agency_id				integer not null
,name							character varying(50) not null
,location_number				character varying(15)
,type_id						integer
,feature_id						integer
,country_id						integer
,state_id						integer
,county_id						integer
,minor_civil_division_id		integer
,hydrologic_unit_id				integer
,national_aquifer_id			integer
,aquifer_id						integer
,create_date					timestamp
,create_user					character varying(20)
,last_update_date				timestamp
,last_update_user				character varying(20)
,constraint monitoring_location_id_pk
  primary key (monitoring_location_id)
);
alter table mlr_data.monitoring_location owner to mlr_data;