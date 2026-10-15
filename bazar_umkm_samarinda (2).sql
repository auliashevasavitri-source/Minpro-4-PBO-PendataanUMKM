-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3308
-- Generation Time: Oct 15, 2026 at 03:14 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pendataan_umkm`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id_event` int NOT NULL,
  `nama_event` varchar(100) NOT NULL,
  `lokasi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id_event`, `nama_event`, `lokasi`) VALUES
(1, 'Bazar UMKM Samarinda 2026', 'Samarinda');

-- --------------------------------------------------------

--
-- Table structure for table `umkm`
--

CREATE TABLE `umkm` (
  `id_umkm` int NOT NULL,
  `nama_usaha` varchar(100) NOT NULL,
  `nama_pemilik` varchar(100) NOT NULL,
  `jenis_usaha` varchar(50) NOT NULL,
  `id_event` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `umkm`
--

INSERT INTO `umkm` (`id_umkm`, `nama_usaha`, `nama_pemilik`, `jenis_usaha`, `id_event`) VALUES
(1, 'dapur cinta', 'aulia', 'Kuliner', 1),
(2, 'Samarinda Fashion', 'Rina', 'Fashion', 1),
(3, 'asinan ceria', 'asep', 'Kuliner', 1),
(4, 'jajanan viral', 'cina', 'Kuliner', 1),
(6, 'teh naik daon', 'susi', 'Kuliner', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`);

--
-- Indexes for table `umkm`
--
ALTER TABLE `umkm`
  ADD PRIMARY KEY (`id_umkm`),
  ADD KEY `id_event` (`id_event`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `umkm`
--
ALTER TABLE `umkm`
  ADD CONSTRAINT `umkm_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
