-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 12-Abr-2016 às 06:34
-- Versão do servidor: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `urnaeletronica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

CREATE TABLE `candidato` (
  `cpf` int(110) NOT NULL,
  `nome` text NOT NULL,
  `end` text NOT NULL,
  `titulo` text NOT NULL,
  `senha` text NOT NULL,
  `RG` int(100) NOT NULL,
  `num` int(110) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `candidato`
--

INSERT INTO `candidato` (`cpf`, `nome`, `end`, `titulo`, `senha`, `RG`, `num`) VALUES
(21321, 'candidato1', 'akkowakow', '321321', 'amtheus10', 321321, 122),
(21321421, 'madsakosko', 'daskodasok', '412321', 'daokokdasko', 421321, 32321),
(0, 'nulo', 'null', 'null', 'null', 0, 0),
(2221113, 'teste1', 'addawwdasaa', '32132132', 'dsadsadw', 3213213, 12233),
(213214211, 'teste2', 'qewqqdwq', '421321312', 'dsadasdw', 421321321, 142123),
(42121321, 'teste3 ', 'wqewqewq', '421132', '21321321', 5421421, 421232);

-- --------------------------------------------------------

--
-- Estrutura da tabela `eleitor`
--

CREATE TABLE `eleitor` (
  `cpf` int(11) NOT NULL,
  `nome` text NOT NULL,
  `end` text NOT NULL,
  `titulo` text NOT NULL,
  `senha` text NOT NULL,
  `RG` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `eleitor`
--

INSERT INTO `eleitor` (`cpf`, `nome`, `end`, `titulo`, `senha`, `RG`) VALUES
(123212, 'Matheus', 'kowaokawko', '21321321', 'matheus10', 21321321);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `cpf` int(100) NOT NULL,
  `nome` text NOT NULL,
  `senha` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`cpf`, `nome`, `senha`) VALUES
(123212, 'Matheus', 'matheus10'),
(21321, 'candidato1', 'amtheus10'),
(21321421, 'madsakosko', 'daokokdasko'),
(2221113, 'teste1', 'dsadsadw'),
(213214211, 'teste2', 'dsadasdw'),
(42121321, 'teste3 ', '21321321');

-- --------------------------------------------------------

--
-- Estrutura da tabela `quemvotou`
--

CREATE TABLE `quemvotou` (
  `titulo` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `quemvotou`
--

INSERT INTO `quemvotou` (`titulo`) VALUES
(0),
(0),
(0),
(0),
(0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `votacao`
--

CREATE TABLE `votacao` (
  `nome` text NOT NULL,
  `num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `votacao`
--

INSERT INTO `votacao` (`nome`, `num`) VALUES
('candidato1', 122),
('candidato1', 122),
('candidato1', 122),
('candidato1', 122),
('madsakosko', 32321),
('madsakosko', 32321),
('madsakosko', 32321),
('madsakosko', 32321),
('candidato1', 122),
('madsakosko', 32321),
('candidato1', 122),
('candidato1', 122),
('madsakosko', 32321),
('madsakosko', 32321),
('candidato1', 122),
('madsakosko', 32321),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('teste1', 12233),
('teste2', 142123),
('teste3 ', 421232),
('teste1', 12233),
('teste1', 12233),
('teste1', 12233),
('teste1', 12233),
('teste1', 12233),
('teste1', 12233),
('teste1', 12233),
('teste1', 12233),
('madsakosko', 32321),
('madsakosko', 32321),
('madsakosko', 32321),
('madsakosko', 32321),
('candidato1', 122),
('nulo', 0),
('nulo', 0),
('nulo', 0),
('madsakosko', 32321),
('candidato1', 122);

-- --------------------------------------------------------

--
-- Estrutura da tabela `voto`
--

CREATE TABLE `voto` (
  `num` int(100) NOT NULL,
  `branco` varchar(1) NOT NULL,
  `nulo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `voto`
--

INSERT INTO `voto` (`num`, `branco`, `nulo`) VALUES
(122, 'F', 'F'),
(122, 'F', 'F'),
(122, 'F', 'F'),
(0, 'V', 'F'),
(32321, 'F', 'F'),
(32321, 'F', 'F'),
(32321, 'F', 'F'),
(122, 'F', 'F'),
(32321, 'F', 'F'),
(122, 'F', 'F'),
(122, 'F', 'F'),
(32321, 'F', 'F'),
(32321, 'F', 'F'),
(122, 'F', 'F'),
(32321, 'F', 'F'),
(0, 'V', 'F'),
(0, 'F', 'V'),
(0, 'F', 'V'),
(0, 'V', 'F'),
(0, 'F', 'V'),
(0, 'V', 'F'),
(0, 'F', 'V'),
(0, 'V', 'F'),
(0, 'V', 'F'),
(0, 'F', 'V'),
(0, 'V', 'F'),
(0, 'F', 'V'),
(0, 'F', 'V'),
(0, 'V', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(12233, 'F', 'F'),
(32321, 'F', 'F'),
(32321, 'F', 'F'),
(32321, 'F', 'F'),
(32321, 'F', 'F'),
(122, 'F', 'F'),
(0, 'V', 'F'),
(0, 'V', 'F'),
(0, 'F', 'V'),
(32321, 'F', 'F'),
(122, 'F', 'F');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
