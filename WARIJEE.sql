-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mar 16 Mars 2021 à 20:45
-- Version du serveur :  5.7.33-0ubuntu0.18.04.1
-- Version de PHP :  7.3.17-1+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `WARIJEE`
--

-- --------------------------------------------------------

--
-- Structure de la table `Compte`
--

CREATE TABLE `Compte` (
  `idC` int(11) NOT NULL,
  `numerCompte` varchar(255) NOT NULL,
  `solde` int(11) NOT NULL,
  `idP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Compte`
--

INSERT INTO `Compte` (`idC`, `numerCompte`, `solde`, `idP`) VALUES
(1, '123456789', 15000, 1),
(2, '78945123', 20000, 2),
(3, '654233555', 100000, 1),
(4, '', 0, 1),
(5, '', 0, 1),
(6, '', 15, 1),
(10, '12568', 10000, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Depot`
--

CREATE TABLE `Depot` (
  `idD` int(11) NOT NULL,
  `montant` int(11) NOT NULL,
  `dateDepot` date NOT NULL,
  `idC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Depot`
--

INSERT INTO `Depot` (`idD`, `montant`, `dateDepot`, `idC`) VALUES
(1, 20000, '2021-01-01', 1),
(2, 15000, '2021-01-20', 1),
(3, 1500000, '2021-03-16', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Partenaire`
--

CREATE TABLE `Partenaire` (
  `idP` int(11) NOT NULL,
  `ninea` varchar(256) NOT NULL,
  `prenom` varchar(256) NOT NULL,
  `nom` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `telephone` varchar(256) NOT NULL,
  `adresse` varchar(256) NOT NULL,
  `raisonsociale` varchar(256) NOT NULL,
  `statut` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Partenaire`
--

INSERT INTO `Partenaire` (`idP`, `ninea`, `prenom`, `nom`, `email`, `telephone`, `adresse`, `raisonsociale`, `statut`) VALUES
(1, 'AS1994', 'Awa', 'Sall', 'sallawa622@gmail.com', '777503987', 'thiaroye', 'MultiService', 'actif'),
(2, 'IN1994', 'Ibrahima', 'Ndao', 'ibou05@gmail.com', '778083808', 'parcelles', 'warima', 'actif'),
(3, 'fall02', 'kouna', 'fall', 'kounafall@gmail.com', '777503987', 'castor', 'kounaservice', 'actif');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `idU` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Compte`
--
ALTER TABLE `Compte`
  ADD PRIMARY KEY (`idC`),
  ADD KEY `idP` (`idP`);

--
-- Index pour la table `Depot`
--
ALTER TABLE `Depot`
  ADD PRIMARY KEY (`idD`),
  ADD KEY `idC` (`idC`);

--
-- Index pour la table `Partenaire`
--
ALTER TABLE `Partenaire`
  ADD PRIMARY KEY (`idP`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`idU`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Compte`
--
ALTER TABLE `Compte`
  MODIFY `idC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `Depot`
--
ALTER TABLE `Depot`
  MODIFY `idD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Partenaire`
--
ALTER TABLE `Partenaire`
  MODIFY `idP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `idU` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Compte`
--
ALTER TABLE `Compte`
  ADD CONSTRAINT `Compte_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `Partenaire` (`idP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Depot`
--
ALTER TABLE `Depot`
  ADD CONSTRAINT `Depot_ibfk_1` FOREIGN KEY (`idC`) REFERENCES `Compte` (`idC`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
