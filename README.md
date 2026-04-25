# 商品后台管理后端系统
 
## 项目介绍
 
这是一个基于Spring Boot的商品后台管理后端系统，提供了完整的商品管理、用户管理、订单管理、分类管理和售后服务等功能。系统采用了现代化的技术栈，具有良好的可扩展性和维护性。
 
## 技术栈
 
- **后端框架**: Spring Boot 3.5.13
- **编程语言**: Java 17
- **数据库**: MySQL
- **ORM框架**: MyBatis-Plus
- **认证方式**: JWT
- **工具库**: Lombok
 
## 项目结构
 
```
shop/
├── src/
│   ├── main/
│   │   ├── java/com/project/shop/
│   │   │   ├── common/        # 通用响应结构
│   │   │   ├── config/         # 配置类
│   │   │   ├── controller/     # 控制器
│   │   │   ├── entity/         # 实体类
│   │   │   │   ├── dto/        # 数据传输对象
│   │   │   │   └── pojo/       # 持久化对象
│   │   │   ├── interceptors/   # 拦截器
│   │   │   ├── mapper/         # 数据访问层
│   │   │   ├── service/        # 服务层
│   │   │   │   └── impl/       # 服务实现
│   │   │   ├── util/           # 工具类
│   │   │   └── ShopApplication.java # 应用入口
│   │   └── resources/
│   │       └── application.yml  # 配置文件
│   └── test/                   # 测试代码
├── pom.xml                     # Maven依赖管理
└── README.md                   # 项目说明
```
 
## 功能模块
 
### 1. 用户管理 (User)
- 用户注册、登录
- 用户信息管理
- JWT认证
 
### 2. 商品管理 (Goods)
- 商品列表查询
- 商品详情查询
- 商品创建和更新
 
### 3. 分类管理 (Category)
- 分类列表查询
- 分类创建和更新
 
### 4. 订单管理 (Order)
- 订单创建
- 订单状态管理
- 订单查询
 
### 5. 订单商品管理 (Order_item)
- 订单商品关联管理
 
### 6. 售后服务 (AfterSales)
- 售后申请管理
- 售后状态更新
 
## 快速开始
 
### 环境要求
 
- JDK 17+
- Maven 3.6+
- MySQL 5.7+

### 安装和运行
 
1. 克隆项目到本地
 
```bash
git clone <项目地址>
cd shop
```
 
2. 构建项目
 
```bash
mvn clean install
```
 
3. 运行应用
 
```bash
mvn spring-boot:run
```
 
或者直接运行 `ShopApplication.java` 类
 
### 访问接口
 
应用启动后，API接口可通过以下地址访问：
 
```
http://localhost:8082/api
```
 
## API接口说明
 
### 用户相关
- `POST /api/user/login` - 用户登录
- `POST /api/user/register` - 用户注册
- `GET /api/user/info` - 获取用户信息
 
### 商品相关
- `GET /api/goods` - 获取商品列表
- `GET /api/goods/{id}` - 获取商品详情
- `POST /api/goods` - 创建商品
- `PUT /api/goods/{id}` - 更新商品
 
### 分类相关
- `GET /api/category` - 获取分类列表
- `POST /api/category` - 创建分类
- `PUT /api/category/{id}` - 更新分类
 
### 订单相关
- `GET /api/order` - 获取订单列表
- `POST /api/order` - 创建订单
- `PUT /api/order/{id}` - 更新订单状态
 
### 售后服务相关
- `GET /api/afterSales` - 获取售后列表
- `POST /api/afterSales` - 创建售后申请
- `PUT /api/afterSales/{id}` - 更新售后状态
 
## 系统架构
 
### 核心流程
 
1. **用户认证流程**
   - 用户登录 → 验证 credentials → 生成 JWT token → 返回给客户端
   - 后续请求携带 token → 拦截器验证 token → 处理请求
 
2. **订单流程**
   - 创建订单 → 生成订单号 → 关联商品 → 更新库存 → 返回订单信息
 
3. **售后流程**
   - 提交售后申请 → 审核 → 处理 → 完成
 
### 安全措施
 
- JWT token 认证
- 密码加密存储
- CORS 跨域配置
 
## 注意事项
 
1. 本项目使用 JWT 进行认证，登录成功后会返回 token，请在后续请求的 Header 中携带 `Authorization: Bearer {token}`
 
2. 数据库连接信息需要根据实际环境进行修改
 
3. 项目默认端口为 8082，上下文路径为 /api
 
