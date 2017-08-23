## springboot脚手架程序

### 基本信息
 - 初始程序在https://start.spring.io/ 生成主框架，slected Depandencies为DevTools,Web
 - 基于Spring Boot Version 1.5.4和Java8
 
### 目前具有的功能
 - 集成了druid双数据库连接池
 - 集成了druid数据库连接池监控功能
 - 集成了logback日志系统，支持生成运行日志文件、错误日志文件、控制台打印日志。
 - 集成了mybatis
 - 集成了模板框架freemarker
 - 集成了ojdbc6，mysql-connector-java分别适配oracle和mysql
 - 集成了fastjson
 - test，prd，pre分环境配置,运行时指定环境
 - 根据操作环境分windows和Linux生成日志存放路径
 
 ### 启动
 - idea：控制台下输入mvn clean spring-boot:run