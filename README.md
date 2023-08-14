
# jorm
An ORM framework written in Java.

[English Doc]()  |  [中文文档]()
___________________________

# architecture design

![simple-architecture-diagram](https://github.com/PansonPanson/jorm/blob/main/doc/zh/001picture/simple-architecture-diagram.png?raw=true)

# MyBatis sourcecode reading
Mybatis 的源码行数不算多，用 IDEA 插件 statistics 统计 main 包下 Java 代码的行数为两万多行。本文主要侧重讲解 Mybatis 的工程结构。
以下为 main 包下的目录结构：
```
├── java
│   └── org
│       └── apache
│           └── ibatis
│               ├── annotations
│               ├── binding
│               ├── builder
│               ├── cache
│               ├── cursor
│               ├── datasource
│               ├── exceptions
│               ├── executor
│               ├── io
│               ├── jdbc
│               ├── lang
│               ├── logging
│               ├── mapping
│               ├── parsing
│               ├── plugin
│               ├── reflection
│               ├── scripting
│               ├── session
│               ├── transaction
│               ├── type
│               └── util
│               ├── package-info.java
└── resources
    └── org
        └── apache
            └── ibatis
                └── builder
```

为了页面更直观，我将直接在目录结构上增加说明，如下：
```
├── java
│   └── org
│       └── apache
│           └── ibatis
│               ├── annotations：支持以注解形式配置 sql，而非以 xml 形式配置 sql 
│               ├── binding：将 Mapper 接口与映射配置文件关联起来
│               ├── builder：支持配置解析
│               ├── cache：支持一级缓存和二级缓存
│               ├── cursor：sql 执行结果的游标
│               ├── datasource：数据源相关
│               ├── exceptions：异常处理
│               ├── executor：支持 sql 执行
│               ├── io：资源加载模块，主要是对类加载器进行封装，确定类加载器的使用顺序，并提供了加载类文件以及其他资源文件的功能 
│               ├── jdbc：JDBC 相关
│               ├── lang：语言相关
│               ├── logging：日志模块，集成第三方日志框架
│               ├── mapping：支持 sql 操作解析后的映射
│               ├── parsing：支持配置文件解析
│               ├── plugin：支持插件开发
│               ├── reflection：封装 JDK 的反射，提供更友好的反射 API
│               ├── scripting：解析并拼接sql
│               ├── session：提供 SqlSession 接口
│               ├── transaction：事务模块
│               ├── type：支持别名机制、JDBC 类型与 Java 类型之间的相互转换
│               └── util：功能包
└── resources
    └── org
        └── apache
            └── ibatis
                └── builder
```

