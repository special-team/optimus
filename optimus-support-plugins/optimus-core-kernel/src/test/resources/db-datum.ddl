/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- ======== ======== ======== ========
-- sample data
-- ======== ======== ======== ========
INSERT INTO e_sample (id_, first_name_, last_name_, deleted_, created_, updated_) VALUES
    (1, 'sample1', 'sample1x', 0, now(), now()),
    (2, 'sample2', 'sample2x', 0, now(), now()),
    (3, 'sample3', 'sample3x', 1, now(), now());
