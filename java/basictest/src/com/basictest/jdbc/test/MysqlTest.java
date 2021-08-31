package com.basictest.jdbc.test;

import com.basictest.jdbc.utils.ConnMysql;

import java.sql.*;

/**
 * Created in 2021/3/29 16:36
 *
 * @author: huxingxin
 */
public class MysqlTest {

    public static void main(String[] args) throws SQLException {
        String createTable="CREATE TABLE if not exists `sp_user` (\n" +
                "  `USER_ID` varchar(40) NOT NULL COMMENT '用户ID',\n" +
                "  `USER_NAME` varchar(50) DEFAULT NULL COMMENT '用户名,不重复,可中文',\n" +
                "  `PASSWORD` varchar(64) DEFAULT NULL COMMENT 'shiro MD5密码32位',\n" +
                "  `STATE` int(1) DEFAULT NULL COMMENT '1启用0停用',\n" +
                "  `seller_id` varchar(100) DEFAULT NULL COMMENT '商户ID',\n" +
                "  `name` varchar(80) DEFAULT NULL COMMENT '公司名称',\n" +
                "  `nick_name` varchar(50) DEFAULT NULL COMMENT '店铺名称',\n" +
                "  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',\n" +
                "  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',\n" +
                "  `CREATE_BY` varchar(40) DEFAULT NULL COMMENT '创建用户',\n" +
                "  `CREATE_DEPT` varchar(40) DEFAULT NULL COMMENT '创建部门',\n" +
                "  `UPDATE_BY` varchar(40) DEFAULT NULL COMMENT '更新用户',\n" +
                "  `DEPT_ID` varchar(40) DEFAULT NULL COMMENT '部门ID',\n" +
                "  PRIMARY KEY (`USER_ID`) USING BTREE,\n" +
                "  KEY `FK_Reference_24` (`DEPT_ID`) USING BTREE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;";

        String addUser = "INSERT INTO `sp_user` VALUES ('018d748bedcf4327b22e5349df7265a2', '13851969112', 'f9569ca7dc9ba87f9df0fc8fe8fed6de', 1, '13851969112', '南京冠铭城电脑科技有限公司', '南京冠铭城', NULL, NULL, NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('025a21b400774be28b497de95692ad6e', 'wandu', '3f723090e9b2bfbf61024e65314e57b1', 1, 'wandu', 'wandu', '万度商城', '2019-05-31 17:12:05', '2019-11-22 16:14:25', NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('030afc1401374feca1784ba87efe1403', 'keleme', 'e8f9a4abce7d552e74cfc040371d9651', 1, 'keleme', '渴了么中国有限公司', '渴了么店铺', '2019-05-31 17:12:12', '2019-05-31 17:12:00', NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('03922f74d5c540b3b734ff7c7189d34e', 'bokecx', 'ea8e35a4532a15b456f1bbdb90c714ed', 1, NULL, '青丝缠雪', NULL, '2019-12-24 16:05:29', NULL, NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('154a8c96b250411fb5b7839adb63b04f', 'frl7906', '86eb5a8ccd9df693e53c4857f7ae9431', 1, NULL, NULL, NULL, '2020-07-07 10:36:10', NULL, NULL, NULL, NULL, 'dbd0205069a74e9985167655e9db5eaa');\n" +
                "INSERT INTO `sp_user` VALUES ('1bdd499c69fc483eb8a300c125f5e8de', 'xiaomi', '57c64260de3109c2a260351c0157303b', 1, 'xiaomi', '小米中国有限公司', '小米商城', '2019-05-31 17:12:12', '2019-05-31 17:12:00', NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('22268773888749f28e46cbca736d51a8', 'vas9781', 'eb1637bb3fb9ec0fdb5e3b40bfa79b5b', 1, NULL, NULL, NULL, '2020-09-01 15:12:38', NULL, NULL, NULL, NULL, 'dbd0205069a74e9985167655e9db5eaa');\n" +
                "INSERT INTO `sp_user` VALUES ('2f57a69f63404af9a3c40852187c8c6e', 'damai', 'd5ef3c9dc084c4965138c48b005f2f2f', 1, 'damai', '大麦中国有限公司', '大麦商城', '2019-05-31 17:12:13', '2019-05-31 17:12:00', NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('418c483c2f7b4c7690c48b4eca9fed64', 'admin', 'b67440a5a73bd0045b24fc11718d836d', 1, NULL, '超级管理员', NULL, '2019-05-31 17:12:13', '2020-11-20 13:15:10', NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('65b1d0fff68f4a718fa6d5ae9ec1a65e', '冠铭城', 'f4bfe81a040437a1ba20c7b87a3bb78a', 1, NULL, '渠道网', NULL, NULL, '2020-11-20 11:00:14', NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('949cff69f42c4d11a9e174f0878493ef', 'bokenn', 'e95cb9a4a61f2cbe5c4616e9fb69202a', 1, NULL, '鼻涕妞妞', NULL, '2019-12-24 16:06:12', NULL, NULL, NULL, NULL, NULL);\n" +
                "INSERT INTO `sp_user` VALUES ('cb8db64569c54720849837ab547e6c89', 'ijitao', 'df5a988a349c85b7e03757c12a564547', 1, NULL, NULL, NULL, '2020-06-13 17:21:59', NULL, NULL, NULL, NULL, 'dbd0205069a74e9985167655e9db5eaa');\n" +
                "INSERT INTO `sp_user` VALUES ('dc86404e698d4705993514753b032315', 'qianxi', '322d4e719c137edc7ce39520b372f88e', 1, 'qianxi', '千禧中国有限公司', '千禧店铺', '2019-05-31 17:12:18', '2019-05-31 17:12:00', NULL, NULL, NULL, NULL);";

        String query = "SELECT * FROM `sp_user`";

        String dropTable = "drop table  if exists sp_user";

        String truncateTable = "truncate sp_user";

//        ConnMysql.update(createTable);
//        ConnMysql.update(addUser);
//          ConnMysql.execute(addUser);
//          ConnMysql.execute(truncateTable);
        ConnMysql.query(query);

    }


}
