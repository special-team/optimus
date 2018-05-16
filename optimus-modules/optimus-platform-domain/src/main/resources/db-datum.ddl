/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- ======== ======== ======== ========
-- setting
-- ======== ======== ======== ========
INSERT INTO e_platform_setting (id_, config_key_, config_value_, deleted_, created_, updated_) VALUES
    (1, 'ACCOUNT_DEFAULT_PASSWORD', '123456', 0, now(), now());

-- ======== ======== ======== ========
-- module
-- ======== ======== ======== ========
INSERT INTO e_platform_module (id_, name_, icon_, ordinal_, deleted_, created_, updated_) VALUES
    (100, 'module.system', 'icon-layers', 1, 0, now(), now());

-- ======== ======== ======== ========
-- function
-- ======== ======== ======== ========
-- @formatter:off
INSERT INTO e_platform_function (id_, name_, code_, module_id_, parent_, url_, type_, display_, is_lock_, ordinal_, deleted_, created_, updated_) VALUES
    (101, 'function.cache.browse', 'cache:browse', 100, 0,  '/portal/admin/cache', 1, 1, 1, 111, 0, now(), now()),
    (111, 'function.group.browse', 'group:browse', 100, 0, '/portal/group/browse', 1, 1, 1, 111, 0, now(), now()),
    (112, 'function.group.create', 'group:create', 100, 0, '/portal/group/create', 1, 0, 1, 112, 0, now(), now()),
    (113, 'function.group.update', 'group:update', 100, 0, '/portal/group/update', 1, 0, 1, 113, 0, now(), now()),
    (114, 'function.group.detail', 'group:detail', 100, 0, '/portal/group/detail', 1, 0, 1, 114, 0, now(), now()),
    (121, 'function.role.browse',   'role:browse', 100, 0,  '/portal/role/browse', 1, 1, 1, 121, 0, now(), now()),
    (122, 'function.role.create',   'role:create', 100, 0,  '/portal/role/create', 1, 0, 1, 122, 0, now(), now()),
    (123, 'function.role.update',   'role:update', 100, 0,  '/portal/role/update', 1, 0, 1, 123, 0, now(), now()),
    (124, 'function.role.detail',   'role:detail', 100, 0,  '/portal/role/detail', 1, 0, 1, 124, 0, now(), now()),
    (131, 'function.user.browse',   'user:browse', 100, 0,  '/portal/user/browse', 1, 1, 1, 131, 0, now(), now()),
    (132, 'function.user.create',   'user:create', 100, 0,  '/portal/user/create', 1, 0, 1, 132, 0, now(), now()),
    (133, 'function.user.update',   'user:update', 100, 0,  '/portal/user/update', 1, 0, 1, 133, 0, now(), now()),
    (134, 'function.user.detail',   'user:detail', 100, 0,  '/portal/user/detail', 1, 0, 1, 134, 0, now(), now());
-- @formatter:on

-- ======== ======== ======== ========
-- account
-- ======== ======== ======== ========
INSERT INTO e_platform_account (id_, username_, password_, nickname_, type_, salt_, deleted_, created_, updated_) VALUES
    (1, 'god', '{noop}123456', '超级管理员', 1, '*', 0, now(), now()),
    (10, 'admin', '{noop}123456', '管理员', 10, '*', 0, now(), now());
