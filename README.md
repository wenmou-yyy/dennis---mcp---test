# AI Mock Bank 1 项目文档

## 项目概述
AI Mock Bank 1 是一个模拟银行服务的项目，提供股票管理、交易记录管理和账户管理等功能。

## 项目结构
```plaintext
.gitignore
pom.xml
src/
  main/
    java/
    resources/
  test/
    java/
```

## 核心服务接口
### 股票服务接口
`StockService.java` 提供以下核心接口：
- `getAllStocks()`: 获取所有股票列表。
- `getStock(Integer stockID)`: 根据股票 ID 获取单个股票信息，若股票不存在则抛出异常。

###