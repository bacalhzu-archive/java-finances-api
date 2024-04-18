CREATE TABLE t_transaction (
    id UUID PRIMARY KEY,
    value INTEGER NOT NULL,
    description VARCHAR(255) NOT NULL,
    moment TIMESTAMP(6) WITH TIME ZONE,
    incoming BOOL NOT NULL
)