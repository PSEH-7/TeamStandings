DROP TABLE IF EXISTS CountryTable;
 
CREATE TABLE CountryTable (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
 
INSERT INTO CountryTable (name) VALUES
  ('India'),
  ('Brazil'),
  ('Germany'),
  ('England'),
  ('USA'),
  ('France'),
  ('Italy'),
  ('JApan');
  
  DROP TABLE IF EXISTS TeamTable;
 
CREATE TABLE TeamTable (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
 
INSERT INTO TeamTable (name) VALUES
  ('TeamA'),
  ('TeamB'),
  ('TeamC');
  
  
DROP TABLE IF EXISTS LeagueTable;
 
CREATE TABLE LeagueTable (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
 
INSERT INTO LeagueTable (name) VALUES
  ('NationalLevelLeague'),
  ('StatewideLeague'),
  ('SummerLeague');