/*
 * Copyright (c) 2023 Vincent Dao.
 */

INSERT INTO "EMPLOYEE" ("VISA", "FIRST_NAME", "LAST_NAME", "BIRTH_DATE", "VERSION")
VALUES
    ('QMV', 'Giles', 'Posture', '1995-10-08', 0),
    ('HTV', 'Parsley', 'Montana', '1999-11-14', 0),
    ('QKP', 'Indigo', 'Violet', '1990-05-08', 0),
    ('MKN', 'Gibson', 'Montgomery-Gibson', '1979-11-06', 0),
    ('TQP', 'Hilary', 'Ouse', '1995-11-26', 0),
    ('HNH', 'Justin', 'Case', '1995-01-17', 0),
    ('NQN', 'Sir', 'Cumference', '1985-02-17', 0),
    ('PLH', 'Chauffina', 'Carr', '1991-03-26', 0),
    ('HNL', 'Girth', 'Wiedenbauer', '1989-09-17', 0),
    ('TBH', 'Thomas R.', 'Toe', '1986-06-02', 0),
    ('TDN', 'Druid', 'Wensleydale', '1980-08-26', 0),
    ('APL', 'Jason', 'Response', '1996-03-05', 0),
    ('XHP', 'Fleece', 'Marigold', '1977-08-01', 0),
    ('HPN', 'Quiche', 'Hollandaise', '2000-06-28', 0),
    ('HUN', 'Gunther', 'Beard', '2003-09-01', 0),
    ('BNN', 'Fergus', 'Douchebag', '1990-10-08', 0),
    ('PNH', 'Shequondolisa', 'Bivouac', '1986-05-30', 0),
    ('VVT', 'Norman', 'Gordon', '1988-11-04', 0);

INSERT INTO "GROUP" ("GROUP_LEADER_ID", "VERSION")
VALUES
    (1, 0),
    (6, 0);

INSERT INTO "PROJECT" ("GROUP_ID", "PROJECT_NUMBER", "NAME", "CUSTOMER", "STATUS", "START_DATE", "END_DATE", "VERSION")
VALUES
    (1, 9013, 'EFV', 'LoreWare', 'NEW', '2023-06-29', NULL, 0),
    (1, 9367, 'CXTRANET', 'Mycube', 'PLA', '2023-06-29', NULL, 0),
    (1, 7935, 'CRYSTAL BALL', 'APOLLO Soft Works', 'INP', '2023-05-11', '2024-01-01', 0),
    (2, 7966, 'IOC CLIENT EXTRANET', 'ASPEXO', 'FIN', '2022-12-06', '2023-06-01', 0),
    (2, 6612, 'KSTA MIGRATION', 'Syndro', 'INP', '2023-01-15', '2023-08-09', 0);

INSERT INTO "PROJECT_EMPLOYEE" ("PROJECT_ID", "EMPLOYEE_ID")
VALUES
    (1, 5),
    (1, 6),
    (1, 7),
    (2, 8),
    (2, 9),
    (3, 10),
    (3, 11),
    (4, 14),
    (4, 15),
    (4, 16),
    (4, 17),
    (5, 1),
    (5, 18);