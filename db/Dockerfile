FROM postgres:9.5

MAINTAINER Tom Wadeson <tom@tomwadeson.com>

ARG CRUDDY_SIMPLE_DB_NAME=cruddysimple
ARG CRUDDY_SIMPLE_DB_USER=cruddysimple
ARG CRUDDY_SIMPLE_DB_PASS=password

ENV POSTGRES_DB=$CRUDDY_SIMPLE_DB_NAME
ENV POSTGRES_USER=$CRUDDY_SIMPLE_DB_USER
ENV POSTGRES_PASSWORD=$CRUDDY_SIMPLE_DB_PASS

# Set locale to en_GB
RUN localedef -i en_GB -c -f UTF-8 -A /usr/share/locale/locale.alias en_GB.UTF-8
ENV LANG en_GB.utf8

# Allow remote connections
RUN echo "host  all all 0.0.0.0/0   md5" >> /var/lib/postgresql/data/pg_hba.conf
RUN echo "listen_addresses='*'" >> /var/lib/postgresql/data/postgresql.conf
