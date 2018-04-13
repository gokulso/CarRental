/*==============================================================*/
/* TABLE: USERTYPES                                             */
/*==============================================================*/

INSERT INTO USERTYPES VALUES ('ADMINISTRATOR'),('CLIENT')


/*==============================================================*/
/* TABLE: USERS                                                 */
/*==============================================================*/
INSERT INTO USERS (USERTYPE_ID, LOGIN, PASSWORD) VALUES
    ('1', 'ROOT',  'ROOT'),
    ('2', 'USER', 'USER'),
    ('2', 'PETROV', 'PETROVPASS'),
    ('2', 'SMITH',  'SMITHPASS');

/*==============================================================*/
/* TABLE: VEHICLES  -- SELECT * FROM VEHICLES                   */
/*==============================================================*/
INSERT INTO VEHICLES (MAKE, MODEL, AUTO_GEARBOX,
                      AIR_CONDITIONER, SEATS, DAILY_PRICE) VALUES
    ('AUDI',     'A4',   1,  1,  4, 50.00),
    ('AUDI',     'A6',   1,  1,  5, 70.00),
    ('MERCEDES', 'VITO', 0,  1, 7, 65.50),
    ('VW',       'GOLF', 1,  1,  4, 39.99),
    ('VW',       'POLO', 0,  0, 4, 29.99);

/*==============================================================*/
/* TABLE: PASSPORTS                                             */
/*==============================================================*/
INSERT INTO LICENCE (LAST_NAME, FIRST_NAME, PATRONYMIC,PHONE_NO, BIRTHDAY,
                       L_SERIES, L_NUMBER, WHO_ISSUED, ADDRESS, WHEN_ISSUED) VALUES
    (
    'Rahul',
    'Singh',
    'S',
	'9786532415',
    '1983-10-03',
    'MH12',
    '954326',
    'Pune RTO',
	'Sus Raod,Baner,Pune-411045',
    '1998-06-05'
    ),
    (
    'Tushar',
    'Shinde',
    'T',
	'8425364758',
    '1984-11-03',
    'MH12',
    '954347',
    'Pune RTO',
	'Baner Raod,Baner,Pune-411045',
    '1996-06-05'
    ),
    (
    'Vishal',
    'Deshmukh',
    'M',
	'9764313265',
    '1981-05-03',
    'MH12',
    '145369',
    'Pune RTO',
	'Pashan Raod,Pashan,Pune-411045',
    '1995-06-05'
    );

/*==============================================================*/
/* TABLE: ORDERS   SELECT * FROM ORDERS                         */
/*==============================================================*/
INSERT INTO ORDERS
(
    VEHICLE_ID,
    USER_ID,
    PASSPORT_ID,
    PICK_UP_DATE,
    DROP_OFF_DATE,
    RENT_COST,
    PROCESSED,
    REJECTED,
    REJECT_DESC,
    PICKED,
    RETURNED,
    DAMAGED,
    DAMAGE_DESC,
    DAMAGE_COST,
    PAID
)
VALUES
(
    '1',
    '2',
    '1',
    '2014-07-10 15:00:00',
    '2014-07-20 11:00:00',
    500.00,
    0,
    0,
    NULL,
    0,
    0,
    0,
    NULL,
    NULL,
    0
),
(
    '1',
    '3',
    '2',
    '2014-06-25 10:30:00',
    '2014-06-30 12:00:00',
    250.00,
    0,
    0,
    NULL,
    0,
    0,
    0,
    NULL,
    NULL,
    0
),
(
    '4',
    '4',
    '3',
    '2014-05-10 23:00:00',
    '2014-05-12 16:45:00',
    79.98,
    0,
    0,
    NULL,
    0,
    0,
    0,
    NULL,
    NULL,
    0
);	