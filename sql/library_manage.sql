-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 11, 2021 at 08:47 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

CREATE SCHEMA `library`;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_manage`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

DROP TABLE IF EXISTS `book_details`;
CREATE TABLE IF NOT EXISTS `book_details` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `Book_name` varchar(200) COLLATE utf8_persian_ci DEFAULT NULL,
  `writer` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_id`, `Book_name`, `writer`, `quantity`) VALUES
(1, 'java', 'asadi', 2),
(2, 'python', 'sina', 3),
(3, 'php', 'mahdijalili', 1),
(4, 'matlab', 'mahdidiaromidi', 2);

-- --------------------------------------------------------

--
-- Table structure for table `lending_book`
--

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

--
-- Dumping data for table `lending_book`
--

INSERT INTO `lending_book` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `borrow_date`, `return_book_datte`, `status`) VALUES
(1, 1, 'java', 1, 'sinamalmir', '2021-07-08', '2021-07-18', 'Returned'),
(2, 1, 'java', 3, 'mahdidiaromidi', '2021-07-11', '2021-07-21', 'pending'),
(3, 3, 'php', 1, 'sinamalmir', '2021-07-09', '2021-07-20', 'Returned'),
(4, 4, 'matlab', 2, 'mahdijalili', '2021-07-10', '2021-07-20', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
CREATE TABLE IF NOT EXISTS `student_details` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `cours` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `branch` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `name`, `cours`, `branch`) VALUES
(1, 'sinamalmir', 'MSC', 'IT'),
(2, 'mahdijalili', 'PHD', 'ELECTRONICS'),
(3, 'mahdidiaromidi', 'MSC', 'PLAIN');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_persian_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_persian_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_persian_ci DEFAULT NULL,
  `contact` varchar(20) COLLATE utf8_persian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'sina', '12', 'sina@gmail', '093535'),
(2, 'sinamalmir', '12', 'sinamalmir@gmail', '09353535'),
(3, 'test', 'test', 'test@gmail.com', '0935353535'),
(5, 'test', 'test', 'test@gmail.com', '09353535'),
(6, 'ahmad', 'dd', 'dd@gmail.com', '123455'),
(7, 's', 'ss', 'sina@gmail.com', '123565768'),
(8, 'test', '12', 're@gmail.com', '1234'),
(9, 'test', 'test', 'test@gmail.com', '123433333'),
(10, 'test', 'test', 'test@gmail.com', '903912903'),
(11, 'reza', 'test', 'test@gmail.com', '903912903'),
(12, 'test', 'test', 'test@gmail.com', '90353535'),
(13, 'ali', 'ali', 'ali@gmail.com', '10093909u2402'),
(14, 'test', 'ali', 'ali@gmail.com', '1232450-t'),
(15, 'abasboazar', 'abas', 'abas@gmail.com', '19329094040924'),
(16, 'test', 'twst', 'test@gmail.com', '123293409904'),
(17, 'mamad', 'test', 'test@gmail.com', '12948248'),
(18, 'abasboazar2', 'test', 'test@gmail.com', '12948248'),
(19, 'abas', 'abas', 'abas@gmail.com', '1-093094'),
(20, 'z', 'z', 'z@gamil.com', '29932924'),
(21, 'e', 'e', 'e@gmail.com', '2939');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
