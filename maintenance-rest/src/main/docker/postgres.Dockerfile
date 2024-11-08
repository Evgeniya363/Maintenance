FROM postgres:16.1-alpine
COPY *.sql /docker-entrypoint-initdb.d/