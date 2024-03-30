# Postgres setup
## Creating the databases:

Enter the DB CLI:

```zsh
kubectl exec -it postgres-0 -- psql -U faroc -d store
```
Run PSQL queries:

```sql
-- Create DBs:
create database customer;
create database fraud;
create database notification;
-- List the DBs:
\l
-- Quit:
\q
```