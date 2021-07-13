CREATE SCHEMA `library`;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


DROP TABLE IF EXISTS `book_details`;
CREATE TABLE IF NOT EXISTS `book_details` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `Book_name` varchar(200) COLLATE utf8_persian_ci DEFAULT NULL,
  `writer` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;
INSERT INTO `book_details` (`book_id`, `Book_name`, `writer`, `quantity`) VALUES
(1, 'Advanced Java Programing', 'Mr.Asadi', 2),
(2, 'Himself', 'Jess Kidd', 3),
(3, 'The Great Gatsby', 'F. Scott Fitzgerald', 1),
(4, 'War and Peace', 'Leo Tolstoy', 2);


DROP TABLE IF EXISTS `lending_book`;
CREATE TABLE IF NOT EXISTS `lending_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(100) COLLATE utf8_persian_ci NOT NULL,
  `student_id` int(11) NOT NULL,
  `student_name` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `return_book_datte` date DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_persian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;
INSERT INTO `lending_book` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `borrow_date`, `return_book_datte`, `status`) VALUES
(1, 1, 'Advanced Java Programing', 1, 'Mahdi', '2021-07-08', '2021-07-18', 'Returned');


DROP TABLE IF EXISTS `student_details`;
CREATE TABLE IF NOT EXISTS `student_details` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `cours` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `branch` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;
INSERT INTO `student_details` (`student_id`, `name`, `cours`, `branch`) VALUES
(1, 'Mahdi', 'MSC', 'IT'),
(2, 'Sina', 'PHD', 'ELECTRONICS'),
(3, 'M.Mahdi', 'MSC', 'PLAIN');


DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_persian_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_persian_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `contact` varchar(20) COLLATE utf8_persian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;
INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'mahdi', '1234', 'mahdi@gmail', '09339676754');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;