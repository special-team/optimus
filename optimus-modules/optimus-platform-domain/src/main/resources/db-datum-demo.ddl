/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- ======== ======== ======== ========
-- group
-- ======== ======== ======== ========
INSERT INTO e_platform_group (id_, name_, short_name_, deleted_, created_, updated_) VALUES
    (10, '魏国', '魏', 0, now(), now()),
    (20, '蜀国', '蜀', 0, now(), now()),
    (30, '吴国', '吴', 0, now(), now());

-- ======== ======== ======== ========
-- role
-- ======== ======== ======== ========
INSERT INTO e_platform_role (id_, name_, deleted_, created_, updated_) VALUES
    (10, '君主', 0, now(), now()),
    (20, '文官', 0, now(), now()),
    (30, '武官', 0, now(), now());

-- ======== ======== ======== ========
-- account
-- ======== ======== ======== ========
INSERT INTO e_platform_account (id_, username_, password_, nickname_, role_id_, group_id_, type_, salt_, deleted_, created_, updated_) VALUES
    (1011, 'user1', '$2a$08$Q.sEn3Ey190/Gh17GWoV.uJm0bayX3jNNR95CbFViSywzt/3fZppW', '曹操孟德', 10, 10, 1, '*', 0, now(), now()),
    (1021, 'user2', '$2a$08$Q.sEn3Ey190/Gh17GWoV.uJm0bayX3jNNR95CbFViSywzt/3fZppW', '刘备玄德', 10, 20, 1, '*', 0, now(), now()),
    (1031, 'user3', '$2a$08$Q.sEn3Ey190/Gh17GWoV.uJm0bayX3jNNR95CbFViSywzt/3fZppW', '孙权仲谋', 10, 30, 1, '*', 0, now(), now());

-- ======== ======== ======== ========
-- role resource
-- ======== ======== ======== ========
-- INSERT INTO e_platform_role_resource (role_id_, function_id_) VALUES
--     (1, 111),
--     (1, 112),
--     (1, 113);

-- ======== ======== ======== ========
-- account resource
-- ======== ======== ======== ========
-- INSERT INTO e_platform_account_resource VALUES (2, 111);
-- INSERT INTO e_platform_account_resource VALUES (2, 112);
-- INSERT INTO e_platform_account_resource VALUES (2, 113);
