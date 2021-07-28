CREATE TABLE department
   (
      id         UUID NOT NULL,
      name       VARCHAR(255),
      PRIMARY KEY (id)
   );

  CREATE TABLE designation
     (
        id         UUID NOT NULL,
        name       VARCHAR(255),
        PRIMARY KEY (id)
     );


CREATE TABLE employee
  (
     id         UUID NOT NULL,
     name       VARCHAR(255),
     email       VARCHAR(255),
     salary      INT4 NOT NULL,
     hikePercentage      INT4 NOT NULL,
     department_id UUID REFERENCES department(id),
     designation_id UUID REFERENCES designation(id),
     PRIMARY KEY (id)
  );



