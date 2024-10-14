# ************************************************************
# Sequel Ace SQL dump
# Version 20075
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.32)
# Database: business-behavior-monitor
# Generation Time: 2024-10-14 14:19:25 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE database if NOT EXISTS `business-behavior-monitor` default character set utf8mb4 ;
use `business-behavior-monitor`;


# Dump of table monitor_data
# ------------------------------------------------------------

DROP TABLE IF EXISTS `monitor_data`;

CREATE TABLE `monitor_data` (
                                `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                `monitor_id` varchar(8) NOT NULL COMMENT '监控ID',
                                `monitor_name` varchar(64) DEFAULT NULL COMMENT '监控名称',
                                `monitor_node_id` varchar(8) NOT NULL COMMENT '节点ID',
                                `system_name` varchar(64) NOT NULL COMMENT '系统名称',
                                `clazz_name` varchar(256) NOT NULL COMMENT '类的名称',
                                `method_name` varchar(128) NOT NULL COMMENT '方法名称',
                                `attribute_name` varchar(32) NOT NULL COMMENT '属性名称',
                                `attribute_field` varchar(8) NOT NULL COMMENT '属性字段',
                                `attribute_value` varchar(128) NOT NULL COMMENT '属性的值',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='监控数据';



# Dump of table monitor_data_map
# ------------------------------------------------------------

DROP TABLE IF EXISTS `monitor_data_map`;

CREATE TABLE `monitor_data_map` (
                                    `id` int unsigned NOT NULL AUTO_INCREMENT,
                                    `monitor_id` varchar(8) NOT NULL COMMENT '监控ID',
                                    `monitor_name` varchar(64) NOT NULL COMMENT '监控名称',
                                    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
                                    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='监控数据地图配置';

LOCK TABLES `monitor_data_map` WRITE;
/*!40000 ALTER TABLE `monitor_data_map` DISABLE KEYS */;

INSERT INTO `monitor_data_map` (`id`, `monitor_id`, `monitor_name`, `create_time`, `update_time`)
VALUES
    (2,'129101','营销抽奖流程','2024-06-09 16:11:49','2024-10-14 22:13:38');

/*!40000 ALTER TABLE `monitor_data_map` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table monitor_data_map_node
# ------------------------------------------------------------

DROP TABLE IF EXISTS `monitor_data_map_node`;

CREATE TABLE `monitor_data_map_node` (
                                         `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                         `monitor_id` varchar(8) NOT NULL COMMENT '监控ID',
                                         `monitor_node_id` varchar(8) NOT NULL COMMENT '节点ID',
                                         `monitor_node_name` varchar(32) NOT NULL COMMENT '节点名称',
                                         `gather_system_name` varchar(64) NOT NULL COMMENT '采集，系统名称',
                                         `gather_clazz_name` varchar(256) NOT NULL COMMENT '采集，类的名称',
                                         `gather_method_name` varchar(128) NOT NULL COMMENT '采集，方法名称',
                                         `loc` varchar(32) NOT NULL COMMENT '渲染节点坐标',
                                         `color` varchar(8) NOT NULL DEFAULT '#2ECC40' COMMENT '节点颜色',
                                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='监控数据地图节点配置';

LOCK TABLES `monitor_data_map_node` WRITE;
/*!40000 ALTER TABLE `monitor_data_map_node` DISABLE KEYS */;

INSERT INTO `monitor_data_map_node` (`id`, `monitor_id`, `monitor_node_id`, `monitor_node_name`, `gather_system_name`, `gather_clazz_name`, `gather_method_name`, `loc`, `color`, `create_time`, `update_time`)
VALUES
    (5,'129101','1001','开始抽奖啦(启动)','marketo','ae.zerotone.marketo.trigger.http.RaffleActivityController','draw','120 50','#006400','2024-06-09 16:15:23','2024-10-14 22:07:43'),
    (7,'129101','10011','创建抽奖单(开始)','marketo','ae.zerotone.marketo.domain.activity.service.partake.AbstractRaffleActivityPartake','createOrder','120 180','#006400','2024-06-09 16:15:23','2024-10-14 22:07:43'),
    (8,'129101','10012','活动未开始(状态)','marketo','ae.zerotone.marketo.domain.activity.service.partake.AbstractRaffleActivityPartake','createOrder','350 230','#FF8C00','2024-06-09 16:15:23','2024-10-14 22:07:43'),
    (9,'129101','10013','活动未开始(时间)','marketo','ae.zerotone.marketo.domain.activity.service.partake.AbstractRaffleActivityPartake','createOrder','350 320','#FF8C00','2024-06-09 16:15:23','2024-10-14 22:07:43'),
    (10,'129101','10014','订单未消费(存在)','marketo','ae.zerotone.marketo.domain.activity.service.partake.AbstractRaffleActivityPartake','createOrder','350 140','#2E8B57','2024-06-09 16:15:23','2024-10-14 22:07:43'),
    (12,'129101','10015','创建抽奖单(完成)','marketo','ae.zerotone.marketo.domain.activity.service.partake.AbstractRaffleActivityPartake','createOrder','350 50','#2E8B57','2024-06-09 16:15:23','2024-10-14 22:07:43'),
    (13,'129101','1002','抽奖策略表(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.AbstractRaffleStrategy','performRaffle','770 50','#FF1493','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (14,'129101','10021','责任链策略(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.raffle.DefaultRaffleStrategy','raffleLogicChain','1230 50','#0000FF','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (15,'129101','100211','黑名单策略(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.rule.chain.impl.BlackListLogicChain','logic','1230 160','#1E90FF','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (16,'129101','100212','权重值策略(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain','logic','1230 260','#1E90FF','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (17,'129101','100213','兜底的策略(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.rule.chain.impl.DefaultLogicChain','logic','1230 360','#1E90FF','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (18,'129101','10031','抽奖规则树(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.raffle.DefaultRaffleStrategy','raffleLogicTree','770 260','#000000','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (19,'129101','100311','次数锁判断(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.rule.tree.impl.RuleLockLogicTreeNode','logic','1010 260','#2F4F4F','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (20,'129101','100312','扣库存处理(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.rule.tree.impl.RuleStockLogicTreeNode','logic','1010 160','#2F4F4F','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (21,'129101','100313','兜底类奖品(计算)','marketo','ae.zerotone.marketo.domain.strategy.service.rule.tree.impl.RuleLuckAwardLogicTreeNode','logic','1010 360','#2F4F4F','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (22,'129101','1004','中奖记录值(结果)','marketo','ae.zerotone.marketo.domain.award.service.AwardService','saveUserAwardRecord','120 340','#006400','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (23,'129101','10041','异步发奖品(结果)','marketo','ae.zerotone.marketo.trigger.listener.SendAwardCustomer','listener','120 450','#006400','2024-06-09 17:20:30','2024-10-14 22:07:43'),
    (24,'129101','10042','抽奖失败啦(结果)','marketo','ae.zerotone.marketo.trigger.http.RaffleActivityController','draw','350 450','#B22222','2024-06-09 17:20:30','2024-10-14 22:07:43');

/*!40000 ALTER TABLE `monitor_data_map_node` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table monitor_data_map_node_field
# ------------------------------------------------------------

DROP TABLE IF EXISTS `monitor_data_map_node_field`;

CREATE TABLE `monitor_data_map_node_field` (
                                               `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                               `monitor_id` varchar(8) NOT NULL COMMENT '监控ID',
                                               `monitor_node_id` varchar(8) NOT NULL COMMENT '节点ID',
                                               `log_name` varchar(64) NOT NULL COMMENT '日志名称；执行抽奖开始 userId',
                                               `log_index` int NOT NULL DEFAULT '0' COMMENT '解析顺序；第几个字段',
                                               `log_type` varchar(8) NOT NULL DEFAULT 'Object' COMMENT '字段类型；Object、String',
                                               `attribute_name` varchar(32) NOT NULL COMMENT '属性名称',
                                               `attribute_field` varchar(8) NOT NULL COMMENT '属性字段',
                                               `attribute_ognl` varchar(16) NOT NULL COMMENT '解析公式',
                                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='监控数据地图节点字段配置';

LOCK TABLES `monitor_data_map_node_field` WRITE;
/*!40000 ALTER TABLE `monitor_data_map_node_field` DISABLE KEYS */;

INSERT INTO `monitor_data_map_node_field` (`id`, `monitor_id`, `monitor_node_id`, `log_name`, `log_index`, `log_type`, `attribute_name`, `attribute_field`, `attribute_ognl`, `create_time`, `update_time`)
VALUES
    (7,'129101','1001','活动抽奖开始',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 16:26:18'),
    (8,'129101','10011','创建活动抽奖单开始',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 16:26:18'),
    (9,'129101','10012','创建活动抽奖单失败，活动状态未开启',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 16:29:45'),
    (10,'129101','10013','创建活动抽奖单失败，活动时间未开始',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 16:30:17'),
    (11,'129101','10014','创建参与活动订单存在',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 16:30:29'),
    (12,'129101','10015','创建活动抽奖单完成',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 16:30:34'),
    (13,'129101','1002','抽奖策略计算',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:32:37'),
    (14,'129101','10021','抽奖策略-责任链',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:33:29'),
    (15,'129101','100211','抽奖责任链-黑名单接管',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:52:15'),
    (16,'129101','100212','抽奖责任链-权重接管',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:52:40'),
    (17,'129101','100213','抽奖责任链-默认处理',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:34:18'),
    (18,'129101','10031','抽奖策略-规则树',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:35:04'),
    (19,'129101','100311','规则过滤-次数锁',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:35:13'),
    (20,'129101','100312','规则过滤-库存扣减',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:35:20'),
    (21,'129101','100313','规则过滤-兜底奖品',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:35:28'),
    (22,'129101','1004','中奖记录保存完成',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:32:37'),
    (23,'129101','10041','监听用户奖品发送消息，发奖完成',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:32:37'),
    (24,'129101','10042','活动抽奖失败',1,'String','用户ID','userId','userId','2024-06-09 16:26:18','2024-06-09 17:32:37');

/*!40000 ALTER TABLE `monitor_data_map_node_field` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table monitor_data_map_node_link
# ------------------------------------------------------------

DROP TABLE IF EXISTS `monitor_data_map_node_link`;

CREATE TABLE `monitor_data_map_node_link` (
                                              `id` int unsigned NOT NULL AUTO_INCREMENT,
                                              `monitor_id` varchar(8) NOT NULL COMMENT '监控ID',
                                              `from_monitor_node_id` varchar(8) NOT NULL COMMENT 'from 监控ID',
                                              `to_monitor_node_id` varchar(8) NOT NULL COMMENT 'to 监控ID',
                                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='监控数据地图节点链路配置';

LOCK TABLES `monitor_data_map_node_link` WRITE;
/*!40000 ALTER TABLE `monitor_data_map_node_link` DISABLE KEYS */;

INSERT INTO `monitor_data_map_node_link` (`id`, `monitor_id`, `from_monitor_node_id`, `to_monitor_node_id`, `create_time`, `update_time`)
VALUES
    (58,'129101','1001','10011','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (59,'129101','10011','10012','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (60,'129101','10011','10013','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (61,'129101','10011','10014','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (62,'129101','10011','10015','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (63,'129101','10015','1002','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (64,'129101','1002','10021','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (65,'129101','10021','100211','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (66,'129101','100211','100212','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (67,'129101','100212','100213','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (68,'129101','1002','10031','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (69,'129101','10031','100311','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (70,'129101','10031','100312','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (71,'129101','10031','100313','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (72,'129101','10011','1004','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (73,'129101','1004','10041','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (74,'129101','1004','10042','2024-06-09 18:41:29','2024-06-09 18:41:29'),
    (75,'129101','10014','1002','2024-06-09 18:41:29','2024-06-09 18:41:29');

/*!40000 ALTER TABLE `monitor_data_map_node_link` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
