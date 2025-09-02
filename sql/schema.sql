DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `idade` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipoCliente` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `emprestimo`;
CREATE TABLE `emprestimo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataDevolucao` varchar(255) DEFAULT NULL,
  `dataEmprestimo` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `livro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6n4khp9r51vk81ksiq1cx5bg0` (`cliente_id`),
  KEY `FKr28cw763ed3nukppb96wofho5` (`livro_id`),
  CONSTRAINT `FK6n4khp9r51vk81ksiq1cx5bg0` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKr28cw763ed3nukppb96wofho5` FOREIGN KEY (`livro_id`) REFERENCES `livros` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `exemplares`;

CREATE TABLE `exemplares` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `tipoExemplar` int(11) NOT NULL,
  `livro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeyn9hfbeywno43rxa2kplmtrl` (`livro_id`),
  CONSTRAINT `FKeyn9hfbeywno43rxa2kplmtrl` FOREIGN KEY (`livro_id`) REFERENCES `livros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `livros`;

CREATE TABLE `livros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `edicao` int(11) NOT NULL,
  `editora` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


