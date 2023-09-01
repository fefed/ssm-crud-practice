CREATE TABLE `tbl_emp` (
                           `emp_id` int(11) NOT NULL AUTO_INCREMENT,
                           `emp_name` varchar(255) DEFAULT NULL,
                           `gender` char(1) DEFAULT NULL,
                           `email` varchar(255) DEFAULT NULL,
                           `d_id` int(11) DEFAULT NULL,
                           PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE `tbl_dept` (
                            `dept_id` int(11) NOT NULL AUTO_INCREMENT,
                            `dept_name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;