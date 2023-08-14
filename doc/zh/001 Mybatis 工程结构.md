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
│               ├── package-info.java
│               ├── parsing
│               ├── plugin
│               ├── reflection
│               ├── scripting
│               ├── session
│               ├── transaction
│               ├── type
│               └── util
└── resources
    └── org
        └── apache
            └── ibatis
                └── builder
```

