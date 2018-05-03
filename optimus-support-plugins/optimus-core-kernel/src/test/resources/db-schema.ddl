/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

DROP TABLE IF EXISTS e_sample;

-- ======== ======== ======== ========
-- sample
-- ======== ======== ======== ========
CREATE TABLE e_sample (
    id_         BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    first_name_ VARCHAR(50) NOT NULL COMMENT '名称1',
    last_name_  VARCHAR(50) NOT NULL COMMENT '名称2',
    mail_       VARCHAR(50) NULL COMMENT '邮箱',
    deleted_    INT         NOT NULL COMMENT '记录状态[0:有效|1:无效]',
    created_    DATETIME    NOT NULL COMMENT '记录创建时间',
    updated_    DATETIME    NOT NULL COMMENT '记录更新时间',
    CONSTRAINT sample_pk PRIMARY KEY (id_),
    CONSTRAINT sample_uk_name UNIQUE (first_name_, last_name_)
);
