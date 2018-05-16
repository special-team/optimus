/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

DROP TABLE IF EXISTS e_platform_setting;
DROP TABLE IF EXISTS e_platform_module;
DROP TABLE IF EXISTS e_platform_function;
DROP TABLE IF EXISTS e_platform_role;
DROP TABLE IF EXISTS e_platform_group;
DROP TABLE IF EXISTS e_platform_account;
DROP TABLE IF EXISTS e_platform_role_resource;
DROP TABLE IF EXISTS e_platform_account_resource;
DROP TABLE IF EXISTS e_platform_privilege;
DROP TABLE IF EXISTS e_platform_message;

-- ======== ======== ======== ========
-- config
-- ======== ======== ======== ========
CREATE TABLE e_platform_setting (
    id_           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    config_key_   VARCHAR(64)     NULL COMMENT '配置KEY',
    config_value_ VARCHAR(64)     NULL COMMENT '配置VALUE',
    deleted_      INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_      DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_      DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT setting_pk PRIMARY KEY (id_),
    CONSTRAINT setting_uk_config_key UNIQUE KEY (config_key_)
);

-- ======== ======== ======== ========
-- module
-- ======== ======== ======== ========
CREATE TABLE e_platform_module (
    id_      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    name_    VARCHAR(20)     NOT NULL COMMENT '模块名称',
    icon_    VARCHAR(100)    NULL COMMENT '图标',
    ordinal_ INT             NULL COMMENT '顺序编号',
    deleted_ INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_ DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_ DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT module_pk PRIMARY KEY (id_),
    CONSTRAINT module_uk_name UNIQUE KEY (name_)
);

-- ======== ======== ======== ========
-- function
-- ======== ======== ======== ========
CREATE TABLE e_platform_function (
    id_        BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    name_      VARCHAR(50)     NOT NULL COMMENT '功能名称',
    code_      VARCHAR(50)     NULL COMMENT '功能编码',
    module_id_ BIGINT UNSIGNED NULL COMMENT '所属模块',
    parent_    BIGINT UNSIGNED NULL COMMENT '父级功能',
    url_       VARCHAR(100)    NOT NULL COMMENT '地址',
    icon_      VARCHAR(20)     NULL COMMENT '图标',
    type_      VARCHAR(10)     NOT NULL COMMENT '类型',
    display_   INT             NULL COMMENT '显示[1:菜单显示|2:快捷显示|3:菜单和快捷显示]',
    is_lock_   INT             NULL COMMENT '是否锁定',
    ordinal_   INT             NULL COMMENT '顺序编号',
    deleted_   INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_   DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_   DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT function_pk PRIMARY KEY (id_),
    CONSTRAINT function_fk_module FOREIGN KEY (module_id_) REFERENCES e_platform_module (id_)
);
-- //CONSTRAINT function_uk_name UNIQUE (name_),

-- ======== ======== ======== ========
-- role
-- ======== ======== ======== ========
CREATE TABLE e_platform_role (
    id_      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    name_    VARCHAR(150)    NOT NULL COMMENT '角色名称',
    deleted_ INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_ DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_ DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT role_pk PRIMARY KEY (id_),
    CONSTRAINT role_uk_name UNIQUE KEY (name_)
);

-- ======== ======== ======== ========
-- group
-- ======== ======== ======== ========
CREATE TABLE e_platform_group (
    id_          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    name_        VARCHAR(50)     NOT NULL COMMENT '名称',
    short_name_  VARCHAR(50)     NULL COMMENT '简称',
    superior_id_ BIGINT UNSIGNED NULL COMMENT '上级',
    deleted_     INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_     DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_     DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT group_pk PRIMARY KEY (id_),
    CONSTRAINT group_uk_name UNIQUE KEY (name_),
    CONSTRAINT group_fk_superior FOREIGN KEY (superior_id_) REFERENCES e_platform_group (id_)
);

-- ======== ======== ======== ========
-- account
-- ======== ======== ======== ========
CREATE TABLE e_platform_account (
    id_                 BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    username_           VARCHAR(200)    NOT NULL COMMENT '用户名',
    password_           VARCHAR(200)    NOT NULL COMMENT '密码',
    nickname_           VARCHAR(200)    NULL COMMENT '昵称',
    certificate_type_   INT             NULL COMMENT '证件类型',
    certificate_number_ VARCHAR(50)     NULL COMMENT '证件号码',
    mobile_             VARCHAR(50)     NULL COMMENT '手机',
    email_              VARCHAR(50)     NULL COMMENT '邮箱',
    role_id_            BIGINT UNSIGNED NULL COMMENT '角色',
    group_id_           BIGINT UNSIGNED NULL COMMENT '组',
    type_               INT             NOT NULL COMMENT '用户标识[1:普通 | 9:系统管理员][NORMAL | ADMIN]',
    salt_               VARCHAR(32)     NOT NULL COMMENT 'SALT',
    deleted_            INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_            DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_            DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT account_pk PRIMARY KEY (id_),
    CONSTRAINT account_uk_username UNIQUE KEY (username_),
    CONSTRAINT account_fk_role FOREIGN KEY (role_id_) REFERENCES e_platform_role (id_),
    CONSTRAINT account_fk_group FOREIGN KEY (group_id_) REFERENCES e_platform_group (id_)
);

-- ======== ======== ======== ========
-- role resource
-- ======== ======== ======== ========
CREATE TABLE e_platform_role_resource (
    role_id_     BIGINT UNSIGNED NOT NULL COMMENT '角色',
    function_id_ BIGINT UNSIGNED NOT NULL COMMENT '功能',
    CONSTRAINT role_resource_pk PRIMARY KEY (role_id_, function_id_),
    CONSTRAINT role_resource_fk_role FOREIGN KEY (role_id_) REFERENCES e_platform_role (id_),
    CONSTRAINT role_resource_fk_function FOREIGN KEY (function_id_) REFERENCES e_platform_function (id_)
);

-- ======== ======== ======== ========
-- account resource
-- ======== ======== ======== ========
CREATE TABLE e_platform_account_resource (
    account_id_  BIGINT UNSIGNED NOT NULL COMMENT '账号',
    function_id_ BIGINT UNSIGNED NOT NULL COMMENT '功能',
    CONSTRAINT account_resource_pk PRIMARY KEY (account_id_, function_id_),
    CONSTRAINT account_resource_fk_account FOREIGN KEY (account_id_) REFERENCES e_platform_account (id_),
    CONSTRAINT account_resource_fk_function FOREIGN KEY (function_id_) REFERENCES e_platform_function (id_)
);

-- ======== ======== ======== ========
-- privilege 数据权限
-- ======== ======== ======== ========
CREATE TABLE e_platform_privilege (
    id_         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    group_id_   BIGINT          NULL COMMENT '组',
    role_id_    BIGINT          NULL COMMENT '角色',
    entity_     VARCHAR(100)    NULL COMMENT '实体',
    field_      VARCHAR(100)    NULL COMMENT '属性',
    operator_   VARCHAR(100)    NULL COMMENT '关系运算',
    value_      VARCHAR(100)    NULL COMMENT '取值[{uid}|{rid}|{gid}]',
    restricted_ VARCHAR(999)    NULL COMMENT '受限属性',
    deleted_    INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_    DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_    DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT privilege_pk PRIMARY KEY (id_),
    CONSTRAINT privilege_fk_role FOREIGN KEY (role_id_) REFERENCES e_platform_role (id_),
    CONSTRAINT privilege_fk_group FOREIGN KEY (group_id_) REFERENCES e_platform_group (id_)
);

-- ======== ======== ======== ========
-- message
-- ======== ======== ======== ========
CREATE TABLE e_platform_message (
    id_      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    title_   VARCHAR(100)    NULL COMMENT '标题',
    content_ VARCHAR(999)    NULL COMMENT '内容',
    from_    BIGINT UNSIGNED NOT NULL COMMENT '发件人',
    to_      BIGINT UNSIGNED NOT NULL COMMENT '收件人',
    deleted_ INT             NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_ DATETIME        NOT NULL COMMENT '记录创建时间',
    updated_ DATETIME        NOT NULL COMMENT '记录更新时间',
    CONSTRAINT message_pk PRIMARY KEY (id_)
);
