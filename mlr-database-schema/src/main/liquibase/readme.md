The inital setup for a non-containerized postgres:

1. Create database
```
-- Database: mlr

-- DROP DATABASE mlr;

CREATE DATABASE mlr
  WITH OWNER = mlr
       CONNECTION LIMIT = -1;
```

2. Create application-level admin user:

```
-- Role: mlr

-- DROP ROLE mlr;

CREATE ROLE mlr LOGIN
  ENCRYPTED PASSWORD <whatever you want>
  NOSUPERUSER INHERIT NOCREATEDB CREATEROLE NOREPLICATION;
GRANT mlr_data TO mlr;
GRANT mlr_user TO mlr;
```

cd to src/main/liquibase, then:

3. As postgres superuser, run `postgres/changeLog.yml`

4. As mlr admin user, run `roles/changeLog.yml`
	4a. Run as `java -DMLR_DATA_PASSWORD=<whatever you want> -DMLR_USER_PASSWORD=<whatever you want>` plus however you usually run liquibase.  Need to inject those password params in for some of the scripts.

5. As mlr admin user, run `changeLog.yml`