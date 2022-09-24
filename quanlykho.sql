-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 13, 2022 at 04:27 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlykho`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhmuchang`
--

CREATE TABLE `danhmuchang` (
  `MaLoaiHang` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenLoaiHang` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `danhmuchang`
--

INSERT INTO `danhmuchang` (`MaLoaiHang`, `TenLoaiHang`) VALUES
('BK ', 'Bánh Kẹo'),
('test1', 'test1'),
('test2', 'test2'),
('test3', 'test3'),
('TP ', 'Thực phẩm'),
('VS ', 'Đồ dùng cá nhân');

-- --------------------------------------------------------

--
-- Table structure for table `hanghoa`
--

CREATE TABLE `hanghoa` (
  `MaHang` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenHang` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DonViTinh` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DonGia` float DEFAULT NULL,
  `MaLoaiHang` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hanghoa`
--

INSERT INTO `hanghoa` (`MaHang`, `TenHang`, `DonViTinh`, `DonGia`, `MaLoaiHang`) VALUES
('BA001', 'Bánh gạo', 'Gói', 15000, 'BK '),
('BA002', 'Bánh chocolate', 'Gói', 50000, 'BK '),
('KE001', 'Kẹo 500k', 'Gói', 10000, 'BK '),
('MI001', 'Mì tôm Hảo Hảo', 'Thùng', 120000, 'TP '),
('MI002', 'Mì tôm Kokomi', 'Thùng', 100000, 'TP '),
('RA001', 'Kem đánh răng Closeup', 'Tuýp', 30000, 'VS ');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HoTenKH` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DiaChiKH` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `SdtKH` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HoTenKH`, `DiaChiKH`, `SdtKH`) VALUES
('2 ', '2', '2', '2 '),
('3', '2', '2', '2 '),
('KH001', 'Nguyễn Văn A', 'Hồ Chí Minh', '0111111111'),
('KH002', 'Trương Văn B', 'Hà Nội', '0333333333'),
('KH003', 'Nguyễn Thị C', 'Lào Cai', '0888888888'),
('KH004', 'Lê Văn D', 'Huế', '0666666666'),
('KH005', 'Phạm Văn E', 'Nha Trang', '0999999999');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNCC` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DiaChiNCC` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `SdtNCC` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MailNCC` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChiNCC`, `SdtNCC`, `MailNCC`) VALUES
('12 ', '122', '122', '122', '122'),
('BK001', 'Công ty CP Bánh kẹo Hải Hà', 'Hà Nội', '0987654321', 'hh@gmail.com'),
('TP001', 'Công ty CP ChinsuFood', 'Đà Nẵng', '0986541231', 'cs@gmail.com'),
('TP002', 'Công ty thực phẩm Thiên Hưng', 'Hồ Chí Minh', '0123456789', 'tg@gmail.com'),
('VS001', 'Công ty giấy Đại Thanh', 'Huế', '0876548912', 'dk@gmail.com'),
('VS002', 'Công ty CP CloseUp', 'Thái Nguyên', '0321456789', 'tn@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`ID`, `Ten`) VALUES
(1, 'Admin'),
(2, 'Nhân viên'),
(3, 'Người dùng');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` int(5) NOT NULL,
  `NgayNhap` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `NgayNhap`) VALUES
(1, '2022-01-04'),
(2, '2022-10-31'),
(3, '2022-04-17'),
(4, '2022-04-17'),
(5, '2011-01-11'),
(6, '2022-08-12'),
(10, '2022-08-12'),
(12, '2022-04-13');

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPX` int(5) NOT NULL,
  `NgayXuat` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPX`, `NgayXuat`) VALUES
(1, '2021-10-10'),
(2, '2021-11-09'),
(4, '2021-11-09'),
(6, '2022-08-13');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TaiKhoan` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IdQuyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`ID`, `Ten`, `TaiKhoan`, `MatKhau`, `IdQuyen`) VALUES
(5, 'admin', 'admin', 'admin', 1),
(6, 'Nhân viên', 'staff', 'staff', 2),
(29, 'test1', 'test1', 'test1', 2),
(32, 'test2', 'test2', 'test2', 3);

-- --------------------------------------------------------

--
-- Table structure for table `ttphieunhap`
--

CREATE TABLE `ttphieunhap` (
  `ID` int(11) NOT NULL,
  `MaPN` int(5) NOT NULL,
  `MaNCC` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaHang` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SLNhap` int(11) DEFAULT NULL,
  `DGNhap` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ttphieunhap`
--

INSERT INTO `ttphieunhap` (`ID`, `MaPN`, `MaNCC`, `MaHang`, `SLNhap`, `DGNhap`) VALUES
(3, 3, 'TP001', 'MI002', 100, 70000),
(4, 4, 'TP002', 'MI002', 100, 70000),
(6, 1, 'BK001', 'BA001', 100, 50000),
(8, 5, '12 ', 'RA001', 100, 50),
(9, 3, 'TP001', 'MI002', 100, 70000),
(10, 12, 'TP001', 'KE001', 123, 23),
(20, 1, 'VS001', 'RA001', 50, 99999),
(21, 1, 'VS001', 'RA001', 50, 99999),
(22, 1, 'VS001', 'RA001', 50, 99999),
(23, 2, 'VS001', 'RA001', 50, 99999),
(24, 2, 'VS001', 'RA001', 50, 99999),
(27, 12, '12 ', 'BA001', 300, 6666);

-- --------------------------------------------------------

--
-- Table structure for table `ttphieuxuat`
--

CREATE TABLE `ttphieuxuat` (
  `ID` int(11) NOT NULL,
  `MaKH` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaHang` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SLXuat` int(11) DEFAULT NULL,
  `DGXuat` float DEFAULT NULL,
  `MaPX` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ttphieuxuat`
--

INSERT INTO `ttphieuxuat` (`ID`, `MaKH`, `MaHang`, `SLXuat`, `DGXuat`, `MaPX`) VALUES
(1, 'KH001', 'BA001', 30, 100000, 1),
(5, 'KH002', 'BA001', 200, 50000, 2),
(7, 'KH003', 'RA001', 55, 688888, 1),
(8, 'KH003', 'RA001', 56, 688888, 1),
(10, 'KH003', 'RA001', 55, 688888, 2),
(11, 'KH003', 'RA001', 55, 688888, 2),
(12, 'KH002', 'BA001', 66, 4444440, 2),
(13, 'KH005', 'RA001', 22, 222222, 4),
(14, 'KH005', 'RA001', 22, 222222, 4),
(15, 'KH005', 'RA001', 22, 222222, 4),
(16, 'KH003', 'KE001', 22, 222222, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhmuchang`
--
ALTER TABLE `danhmuchang`
  ADD PRIMARY KEY (`MaLoaiHang`);

--
-- Indexes for table `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD PRIMARY KEY (`MaHang`),
  ADD KEY `MaLoaiHang` (`MaLoaiHang`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPX`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IdQuyen` (`IdQuyen`);

--
-- Indexes for table `ttphieunhap`
--
ALTER TABLE `ttphieunhap`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MaPN` (`MaPN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaHang` (`MaHang`);

--
-- Indexes for table `ttphieuxuat`
--
ALTER TABLE `ttphieuxuat`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaHang` (`MaHang`),
  ADD KEY `MaPX` (`MaPX`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPN` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `MaPX` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `ttphieunhap`
--
ALTER TABLE `ttphieunhap`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `ttphieuxuat`
--
ALTER TABLE `ttphieuxuat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD CONSTRAINT `hanghoa_ibfk_1` FOREIGN KEY (`MaLoaiHang`) REFERENCES `danhmuchang` (`MaLoaiHang`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`IdQuyen`) REFERENCES `phanquyen` (`ID`);

--
-- Constraints for table `ttphieunhap`
--
ALTER TABLE `ttphieunhap`
  ADD CONSTRAINT `ttphieunhap_ibfk_3` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`),
  ADD CONSTRAINT `ttphieunhap_ibfk_4` FOREIGN KEY (`MaHang`) REFERENCES `hanghoa` (`MaHang`),
  ADD CONSTRAINT `ttphieunhap_ibfk_5` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`);

--
-- Constraints for table `ttphieuxuat`
--
ALTER TABLE `ttphieuxuat`
  ADD CONSTRAINT `ttphieuxuat_ibfk_3` FOREIGN KEY (`MaHang`) REFERENCES `hanghoa` (`MaHang`),
  ADD CONSTRAINT `ttphieuxuat_ibfk_4` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  ADD CONSTRAINT `ttphieuxuat_ibfk_5` FOREIGN KEY (`MaPX`) REFERENCES `phieuxuat` (`MaPX`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
