# Example for backing up to a custom format
# Ensure PGPASSWORD is set securely or .pgpass is configured
PGPASSWORD="postgres" 
pg_dump -h localhost -p 5432 -U postgres -F c -b -v -f db_dump.sql test
