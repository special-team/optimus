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
    (1011, '曹操', '{noop}123456', '孟德', 10, 10, 11, '*', 0, now(), now()),
    (1021, '刘备', '{noop}123456', '玄德', 10, 20, 11, '*', 0, now(), now()),
    (1031, '孙权', '{noop}123456', '仲谋', 10, 30, 11, '*', 0, now(), now());

-- ======== ======== ======== ========
-- role resource
-- ======== ======== ======== ========
INSERT INTO e_platform_role_resource (role_id_, function_id_) VALUES
    (10, 111);

-- ======== ======== ======== ========
-- account resource
-- ======== ======== ======== ========
INSERT INTO e_platform_account_resource VALUES (1011, 112);
INSERT INTO e_platform_account_resource VALUES (1011, 113);
