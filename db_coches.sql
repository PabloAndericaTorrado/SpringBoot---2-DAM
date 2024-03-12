-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-02-2024 a las 19:03:28
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_coches`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `create_at` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `apellido`, `create_at`, `email`, `foto`, `nombre`) VALUES
(1, 'Andérica', '2023-08-01', 'pabloat@iescastelar.com', 'https://randomuser.me/api/portraits/men/1.jpg', 'Pablo'),
(2, 'Martínez', '2022-08-02', 'carlos.martinez@gmail.com', 'https://randomuser.me/api/portraits/women/2.jpg', 'Carlos'),
(3, 'Martínez', '2022-08-03', 'juan.martinez@gmail.com', 'https://randomuser.me/api/portraits/men/3.jpg', 'Juan'),
(4, 'García', '2022-08-04', 'maria.garcia@gmail.com', 'https://randomuser.me/api/portraits/women/4.jpg', 'María'),
(5, 'Pérez', '2022-08-05', 'roberto.perez@gmail.com', 'https://randomuser.me/api/portraits/men/5.jpg', 'Roberto'),
(6, 'López', '2017-08-06', 'elena.lopez@gmail.com', 'https://randomuser.me/api/portraits/women/6.jpg', 'Elena'),
(7, 'Hernández', '2017-08-07', 'ricardo.hernandez@gmail.com', 'https://randomuser.me/api/portraits/men/7.jpg', 'Ricardo'),
(8, 'Díaz', '2017-08-08', 'rafael.diaz@gmail.com', 'https://randomuser.me/api/portraits/women/8.jpg', 'Rafael'),
(9, 'Gutiérrez', '2017-08-09', 'jose.gutierrez@gmail.com', 'https://randomuser.me/api/portraits/men/9.jpg', 'José'),
(10, 'Ramírez', '2017-08-10', 'jaime.ramirez@gmail.com', 'https://randomuser.me/api/portraits/women/10.jpg', 'Jaime'),
(11, 'León', '2017-08-11', 'bruno.leon@gmail.com', 'https://randomuser.me/api/portraits/men/11.jpg', 'Bruno'),
(12, 'Sánchez', '2017-08-12', 'jose.sanchez@gmail.com', 'https://randomuser.me/api/portraits/women/12.jpg', 'José'),
(13, 'Rojas', '2017-08-13', 'juan.rojas@gmail.com', 'https://randomuser.me/api/portraits/men/13.jpg', 'Juan'),
(14, 'Gómez', '2017-08-14', 'ana.gomez@gmail.com', 'https://randomuser.me/api/portraits/women/14.jpg', 'Ana'),
(15, 'Díaz', '2017-08-15', 'roberto.diaz@gmail.com', 'https://randomuser.me/api/portraits/men/15.jpg', 'Roberto'),
(16, 'Rojas', '2017-08-16', 'javier.rojas@gmail.com', 'https://randomuser.me/api/portraits/women/16.jpg', 'Javier'),
(17, 'González', '2017-08-17', 'pedro.gonzalez@gmail.com', 'https://randomuser.me/api/portraits/men/17.jpg', 'Pedro'),
(18, 'Navarro', '2017-08-18', 'sergio.navarro@gmail.com', 'https://randomuser.me/api/portraits/women/18.jpg', 'Sergio'),
(19, 'Vidal', '2017-08-19', 'santiago.vidal@gmail.com', 'https://randomuser.me/api/portraits/men/19.jpg', 'Santiago'),
(20, 'Alvarez', '2017-08-20', 'luis.alvarez@gmail.com', 'https://randomuser.me/api/portraits/women/20.jpg', 'Luis'),
(21, 'Rojas', '2017-08-21', 'sara.rojas@gmail.com', 'https://randomuser.me/api/portraits/men/1.jpg', 'Sara'),
(22, 'Suárez', '2017-08-22', 'javier.suarez@gmail.com', 'https://randomuser.me/api/portraits/women/2.jpg', 'Javier'),
(23, 'López', '2017-08-23', 'joaquin.lopez@gmail.com', 'https://randomuser.me/api/portraits/men/3.jpg', 'Joaquín'),
(24, 'Sanz', '2017-08-24', 'juan.sanz@gmail.com', 'https://randomuser.me/api/portraits/women/4.jpg', 'Juan'),
(25, 'Rojas', '2017-08-25', 'roberto.rojas@gmail.com', 'https://randomuser.me/api/portraits/men/5.jpg', 'Roberto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coches`
--

CREATE TABLE `coches` (
  `id` bigint(20) NOT NULL,
  `anio_fabricacion` int(11) DEFAULT NULL,
  `create_at` date NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `kilometraje` double DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `coches`
--

INSERT INTO `coches` (`id`, `anio_fabricacion`, `create_at`, `foto`, `kilometraje`, `marca`, `matricula`, `modelo`, `precio`) VALUES
(1, 2019, '2017-08-25', 'https://www.flexicar.es/images/903000000072115/2373LND_01_front-right-1440x856.jpg', 30000, 'Toyota', 'ABC123', 'Corolla', 15000),
(2, 2018, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/13/1001/3e9901767de90ad1f6381b198665945fef6f5d19.jpeg', 25000, 'Honda', 'XYZ456', 'Civic', 18000),
(3, 2020, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/10/1988/bd3946deebe9f27d887354b5fc250affb6c68a46.jpeg', 10000, 'Ford', 'DEF789', 'Focus', 20000),
(4, 2017, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/12/1905/219577e1a161f7b2d3c2c2055fe0ad9481c41841.jpeg', 40000, 'Volkswagen', 'GHI012', 'Golf', 17000),
(5, 2019, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/1223/14/8627101/8627101-0-2073902673657ac1c67d1fe4.86026903.jpeg', 35000, 'Chevrolet', 'JKL345', 'Cruze', 16000),
(6, 2017, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/0124/30/11805886/11805886-0-240913149965b9492e656d00.18803612.jpeg', 20000, 'Toyota', 'MNO678', 'Yaris', 12000),
(7, 2018, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/03/1827/c9015f9735f3f87d5c1443b054a02388cfd51f11.jpeg', 18000, 'Nissan', 'PQR901', 'GT-R', 15000),
(8, 2021, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/06/1766/fae0c7450ecbcebbecabb84c5e43ee331c0ce728.jpeg', 5000, 'Hyundai', 'STU234', 'Elantra', 22000),
(9, 2019, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/0124/24/11931299/11931299-0-280928989965b0adeabd9749.75494343.jpeg', 25000, 'Honda', 'VWX567', 'Accord', 18000),
(10, 2017, '2017-08-25', 'https://images0.autocasion.com/unsafe/820x461/ad/06/1572/098ff96e825355cf620719b12134f79b44d90315.jpeg', 30000, 'Ford', 'YZA890', 'Fusion', 16000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `id` bigint(20) NOT NULL,
  `create_at` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_items`
--

CREATE TABLE `factura_items` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `coche_id` bigint(20) DEFAULT NULL,
  `factura_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `coches`
--
ALTER TABLE `coches`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1qiuk10rfkovhlfpsk7oic0v8` (`cliente_id`);

--
-- Indices de la tabla `factura_items`
--
ALTER TABLE `factura_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs1s0tjowvy3enk3qdyx6y54ra` (`coche_id`),
  ADD KEY `FKbxqeprxeke07pfqbym8wy6m2n` (`factura_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `coches`
--
ALTER TABLE `coches`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura_items`
--
ALTER TABLE `factura_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `FK1qiuk10rfkovhlfpsk7oic0v8` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `factura_items`
--
ALTER TABLE `factura_items`
  ADD CONSTRAINT `FKbxqeprxeke07pfqbym8wy6m2n` FOREIGN KEY (`factura_id`) REFERENCES `facturas` (`id`),
  ADD CONSTRAINT `FKs1s0tjowvy3enk3qdyx6y54ra` FOREIGN KEY (`coche_id`) REFERENCES `coches` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
