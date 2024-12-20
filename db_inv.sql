-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2024 at 03:43 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_inv`
--

-- --------------------------------------------------------

--
-- Table structure for table `barangkeluar`
--

CREATE TABLE `barangkeluar` (
  `NoFaktur` varchar(100) NOT NULL,
  `Tanggal` text NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barangkeluar`
--

INSERT INTO `barangkeluar` (`NoFaktur`, `Tanggal`, `Total`) VALUES
('BK0001', '20-11-2024', 1050000);

-- --------------------------------------------------------

--
-- Table structure for table `barangmasuk`
--

CREATE TABLE `barangmasuk` (
  `NoFaktur` varchar(100) NOT NULL,
  `Tanggal` text NOT NULL,
  `idDST` varchar(100) NOT NULL,
  `NamaDST` text NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barangmasuk`
--

INSERT INTO `barangmasuk` (`NoFaktur`, `Tanggal`, `idDST`, `NamaDST`, `Total`) VALUES
('BM0001', '20-11-2024', 'DST0003', 'PT.Thnkpad Tbk', 250000);

-- --------------------------------------------------------

--
-- Table structure for table `databarang`
--

CREATE TABLE `databarang` (
  `Kode_Barang` varchar(100) NOT NULL,
  `Kode_Jenis` varchar(100) NOT NULL,
  `Nama_Jenis` varchar(100) NOT NULL,
  `Nama_Barang` text NOT NULL,
  `Satuan` text NOT NULL,
  `Harga` varchar(100) NOT NULL,
  `Stock` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `databarang`
--

INSERT INTO `databarang` (`Kode_Barang`, `Kode_Jenis`, `Nama_Jenis`, `Nama_Barang`, `Satuan`, `Harga`, `Stock`) VALUES
('A1', 'K10', 'Semen', 'Gresik', 'Sak', '25000', '10'),
('A2', 'K20', 'Pipa', 'Rucika', 'meter', '40000', '12'),
('A4', 'K40', 'Paku', 'Paku Payung', 'Pcs', '1000', '100'),
('A3', 'K30', 'Besi', 'Ceker Ayam', 'Pcs', '30000', '20'),
('A5', 'K50', 'Kabel', 'UTP', 'meter', '12000', '300'),
('A5', 'K50', 'Kabel', 'Tiang Listrik', 'meter', '10000', '12');

-- --------------------------------------------------------

--
-- Table structure for table `datadistributor`
--

CREATE TABLE `datadistributor` (
  `ID_Distributor` varchar(100) NOT NULL,
  `Nama` text NOT NULL,
  `No_Telp` varchar(100) NOT NULL,
  `Alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datadistributor`
--

INSERT INTO `datadistributor` (`ID_Distributor`, `Nama`, `No_Telp`, `Alamat`) VALUES
('DST0001', 'PT. Hoosa Jaya Timur', '0213459876', 'Jl.Raya Gatot Subroto'),
('DST0002', 'PT. Citra Kusuma TBK', '02134567890', 'Jl.Raya Cikarang Utara'),
('DST0003', 'PT.Thnkpad Tbk', '021347632', 'Jl.Raya Poncol Utara');

-- --------------------------------------------------------

--
-- Table structure for table `detailbarangkeluar`
--

CREATE TABLE `detailbarangkeluar` (
  `NoFaktur` varchar(100) NOT NULL,
  `Kode_Barang` varchar(100) NOT NULL,
  `Nama_Barang` text NOT NULL,
  `Harga` double NOT NULL,
  `Jumlah` varchar(100) NOT NULL,
  `Subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailbarangkeluar`
--

INSERT INTO `detailbarangkeluar` (`NoFaktur`, `Kode_Barang`, `Nama_Barang`, `Harga`, `Jumlah`, `Subtotal`) VALUES
('BK0001', 'A1', 'Gresik', 25000, '10', 250000),
('BK0001', 'A2', 'Rucika', 40000, '20', 800000);

-- --------------------------------------------------------

--
-- Table structure for table `detailbarangmasuk`
--

CREATE TABLE `detailbarangmasuk` (
  `NoFaktur` varchar(100) NOT NULL,
  `Kode_Barang` varchar(100) NOT NULL,
  `Nama_Barang` text NOT NULL,
  `Harga` double NOT NULL,
  `Jumlah` varchar(100) NOT NULL,
  `Subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailbarangmasuk`
--

INSERT INTO `detailbarangmasuk` (`NoFaktur`, `Kode_Barang`, `Nama_Barang`, `Harga`, `Jumlah`, `Subtotal`) VALUES
('BM0001', 'A5', 'UTP', 12000, '20', 240000),
('BM0001', 'A4', 'Paku Payung', 1000, '10', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `jenisbarang`
--

CREATE TABLE `jenisbarang` (
  `Kode_Barang` varchar(100) NOT NULL,
  `Kode` varchar(100) NOT NULL,
  `Nama_Barang` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jenisbarang`
--

INSERT INTO `jenisbarang` (`Kode_Barang`, `Kode`, `Nama_Barang`) VALUES
('A1', 'K10', 'Semen'),
('A2', 'K20', 'Pipa'),
('A3', 'K30', 'Besi'),
('A4', 'K40', 'Paku'),
('A5', 'K50', 'Kabel');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
