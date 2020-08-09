# teste_Batch
Teste usando java batch para insert no banco de dados myslq

Banco de dados:

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

-- Table structure for table `Tb_customer_account`
--

CREATE TABLE `Tb_customer_account` (
`id_customer` int(15) NOT NULL,
  `cpf_cnpj` varchar(50) NOT NULL,
  `nm_customer` varchar(50) NOT NULL,
  `is_active` char(1) NOT NULL,
  `vl_total` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Tb_customer_account`
--
ALTER TABLE `Tb_customer_account`
 ADD PRIMARY KEY (`id_customer`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Tb_customer_account`
--
ALTER TABLE `Tb_customer_account`
MODIFY `id_customer` int(15) NOT NULL AUTO_INCREMENT;

