CREATE TABLE `tbUser` (
  `tbUser_id` int NOT NULL AUTO_INCREMENT,
  `tbUser_name` varchar(250) NOT NULL,
  `tbUser_username` varchar(64) NOT NULL,
  `tbUser_password` varchar(64) NOT NULL,
  `tbUser_type` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tbUser_id`),
  UNIQUE KEY `unique_tbUser_username` (`tbUser_username`),
  KEY `idx_tbUser_username` (`tbUser_username`),
  CONSTRAINT `chk_tbUser_type` CHECK ((`tbUser_type` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO tbUser (tbUser_name, tbUser_username, tbUser_password, tbUser_type)
VALUES ('Administrador Teste', 'adminroot','adminho300',0),
("Romildo",'romildo','romildo',1);


CREATE TABLE `tbBook` (
  `tbBook_id` int NOT NULL AUTO_INCREMENT,
  `tbBook_name` varchar(300) NOT NULL,
  `tbBook_date` date DEFAULT NULL,
  `tbBook_author` varchar(250) DEFAULT NULL,
  `tbBook_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tbBook_id`),
  CONSTRAINT `chk_tbBook_status` CHECK ((`tbBook_status` in (1,2,3)))
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO tbBook(tbBook_id,tbBook_name,tbBook_author,tbBook_date,tbBook_status)
VALUES (NULL,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','2011-08-11',1)
,(NULL,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','2011-08-11',1)
,(NULL,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','2011-08-11',3)
,(NULL,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','2011-08-11',1)
,(NULL,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','2011-08-11',2)
,(NULL,'Fluent Python: Clear, Concise, and Effective Programming','Luciano Ramalho','2022-04-10',2)
,(NULL,'Fluent Python: Clear, Concise, and Effective Programming','Luciano Ramalho','2022-04-10',2)
,(NULL,'Fluent Python: Clear, Concise, and Effective Programming','Luciano Ramalho','2022-04-10',1)
,(NULL,'Fluent Python: Clear, Concise, and Effective Programming','Luciano Ramalho','2022-04-10',3)
,(NULL,'Fluent Python: Clear, Concise, and Effective Programming','Luciano Ramalho','2022-04-10',1)
,(NULL,'IDA Pro Book','Chris Eagle','2011-06-07',1)
,(NULL,'IDA Pro Book','Chris Eagle','2011-06-07',2)
,(NULL,'Practical Binary Analysis','Dennis Andriesse','2018-12-11',1)
,(NULL,'Practical Binary Analysis','Dennis Andriesse','2018-12-11',1)
,(NULL,'Practical Binary Analysis','Dennis Andriesse','2018-12-11',1)
,(NULL,'Ching Liu Junzu full crack password','Liu Jun Zu','2013-11-01',2)
,(NULL,'Ching Liu Junzu full crack password','Liu Jun Zu','2013-11-01',2)
,(NULL,'Ching Liu Junzu full crack password','Liu Jun Zu','2013-11-01',1)
,(NULL,'The Hardware Hacking Handbook','Jasper Van Woudenberg','2021-12-21',1)
,(NULL,'The Hardware Hacking Handbook','Jasper Van Woudenberg','2021-12-21',2)
,(NULL,'The Hardware Hacking Handbook','Jasper Van Woudenberg','2021-12-21',1)
,(NULL,'The Hardware Hacking Handbook','Jasper Van Woudenberg','2021-12-21',2)
,(NULL,'Linux Basics for Hackers','OccupyTheWeb','2018-12-04',1)
,(NULL,'Linux Basics for Hackers','OccupyTheWeb','2018-12-04',2)
,(NULL,'Linux Basics for Hackers','OccupyTheWeb','2018-12-04',2)
,(NULL,'Linux Basics for Hackers','OccupyTheWeb','2018-12-04',1)
,(NULL,'Introdução à Linguagem SQL','Thomas Nield','2016-04-22',1)
,(NULL,'Introdução à Linguagem SQL','Thomas Nield','2016-04-22',1)
,(NULL,'Introdução à Linguagem SQL','Thomas Nield','2016-04-22',1)
,(NULL,'Introdução à Linguagem SQL','Thomas Nield','2016-04-22',1)
,(NULL,'Rootkits and Bootkits','Alex Matrosov','2019-04-03',1)
,(NULL,'Rootkits and Bootkits','Alex Matrosov','2019-04-03',2)
,(NULL,'Rootkits and Bootkits','Alex Matrosov','2019-04-03',1)
,(NULL,'Rootkits and Bootkits','Alex Matrosov','2019-04-03',1)
,(NULL,'Hacking the Xbox','Andrew Huang','2003-06-03',1)
,(NULL,'Hacking the Xbox','Andrew Huang','2003-06-03',1)
,(NULL,'Hacking the Xbox','Andrew Huang','2003-06-03',2)
,(NULL,'Hacking the Xbox','Andrew Huang','2003-06-03',1)
,(NULL,'Hacking the Xbox','Andrew Huang','2003-06-03',1)
,(NULL,'The Information','James Gleick','2011-03-01',2)
,(NULL,'The Information','James Gleick','2011-03-01',1)
,(NULL,'The Information','James Gleick','2011-03-01',1)
,(NULL,'The Information','James Gleick','2011-03-01',2)
,(NULL,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','Clay Shirky','2015-10-13',1)
,(NULL,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','Clay Shirky','2015-10-13',1)
,(NULL,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','Clay Shirky','2015-10-13',2)
,(NULL,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','Clay Shirky','2015-10-13',1)
,(NULL,'The Huawei Model','Yun Wen','2020-11-02',1)
,(NULL,'The Huawei Model','Yun Wen','2020-11-02',2)
,(NULL,'The Huawei Model','Yun Wen','2020-11-02',1);