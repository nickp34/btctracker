-- more of what I would do for production database
-- would create user, but if we did this is what it woudl look like
-- flyway and not using hibernate
-- didn't check the syntax of this
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE coin (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  name TEXT UNIQUE,
  ticket TEXT UNIQUE
);

CREATE TABLE user (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  email TEXT UNIQUE
);

CREATE TABLE user_coin(
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  user_id UUID NOT NULL,
  coin_id UUID NOT NULL,
  address TEXT,
  balance BIGINT, -- more research on this type
  last_time_sync timestamp,
  CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES user(id),
  CONSTRAINT fk_coin FOREIGN KEY(coin_id) REFERENCES coin(id),
);

