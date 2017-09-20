DROP SEQUENCE IF EXISTS hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

CREATE TABLE authority (
  authority_id INT8 NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (authority_id)
);

CREATE TABLE member (
  member_id INT8 NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  email VARCHAR(255) NOT NULL,
  full_name VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  wallet_wallet_id INT8,
  PRIMARY KEY (member_id)
);

CREATE TABLE user_authority (
  member_id INT8 NOT NULL,
  authority_id INT8 NOT NULL
);

CREATE TABLE wallet (
  wallet_id INT8 NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  address VARCHAR(255),
  PRIMARY KEY (wallet_id)
);

ALTER TABLE authority
  ADD CONSTRAINT UQ_constraint_authority_name UNIQUE (name);

ALTER TABLE member
  ADD CONSTRAINT UQ_constraint_member_email UNIQUE (email);

ALTER TABLE member
  ADD CONSTRAINT FK_constraint_member_wallet
FOREIGN KEY (wallet_wallet_id)
REFERENCES wallet;

ALTER TABLE user_authority
  ADD CONSTRAINT FK_constraint_user_authority_authority
FOREIGN KEY (authority_id)
REFERENCES authority;

ALTER TABLE user_authority
  ADD CONSTRAINT FK_constraint_user_authority_member
FOREIGN KEY (member_id)
REFERENCES member;
