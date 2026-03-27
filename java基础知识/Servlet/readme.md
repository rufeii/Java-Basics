不知道怎么写！
放点东西就行了

# Servlet & JavaEE 核心知识点
参考链接：
- https://mp.weixin.qq.com/s/c_4fOTBKDcByv8MZ9ayaRg
- https://blog.csdn.net/qq_52173163/article/details/121110753

---

## 一、Servlet 概念解释
Servlet 是运行在 Web 服务器或应用服务器上的程序，它是作为来自 Web 浏览器或其他 HTTP 客户端的请求和 HTTP 服务器上的数据库或应用程序之间的中间层。

使用 Servlet 可以：
- 收集网页表单用户输入
- 展示数据库 / 其他数据源记录
- 动态创建网页

本章为 JavaEE 开发核心重点。

---

## 二、JavaEE-IDEA 开发环境
1.  安装 IDEA 并激活，安装开发插件
2.  安装 JDK、Tomcat
3.  新建项目并完成环境配置

---

## 三、创建和使用 Servlet
1.  创建类继承 `HttpServlet`
2.  `web.xml` 配置 Servlet 路由
3.  `@WebServlet` 注解配置路由

### Servlet 生命周期
快捷键：`Alt+Insert`
内置核心方法：
- `init()`
- `service()` / `doGet()` / `doPost()`
- `destroy()`

---

## 四、请求接收与响应回显
### HttpServletRequest（ServletRequest 子接口）
- `getParameter(name)`：根据 name 获取单值 `String`
- `getParameterValues(name)`：根据 name 获取多值 `String[]`

### HttpServletResponse（ServletResponse 子接口）
- `setCharacterEncoding()`：设置编码
- `setContentType()`：设置解析语言类型
- `getWriter()`：获取 `PrintWriter` 输出流
- `PrintWriter`：输出各类响应数据

---

## 五、JavaEE 过滤器 Filter
Filter 用于拦截 Web 资源，处理 Request/Response 后转交后续组件；可实现权限控制、敏感词过滤、响应压缩等功能。

### 1. 使用流程
1.  创建过滤器类
2.  内置方法：`init` / `doFilter` / `destroy`
3.  配置方式
    - 注解：
      ```java
      @WebFilter("/xss")

xml 配置：
xml
<filter>
    <filter-name>xssFilter</filter-name>
    <filter-class>com.example.filter.xssFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>xssFilter</filter-name>
    <url-pattern>/xss</url-pattern>
</filter-mapping>
2. 安全场景
Payload 检测、权限访问控制
红队：内存马植入
蓝队：内存马清理
内存马参考：https://mp.weixin.qq.com/s/hev4G1FivLtqKjt0VhHKmw
3. 案例
XSS 攻击检测
后台页面 Cookie 权限校验
六、JavaEE 监听器 Listener
参考：https://blog.csdn.net/qq_52797170/article/details/124023760
监听 ServletContext/HttpSession/ServletRequest 域对象创建与销毁
监听域对象属性修改事件
事件前后自定义处理逻辑
1. 使用流程
创建监听器
实现内置监听方法
配置注册
注解：
java
运行
@WebListener
xml 配置：
xml
<listener>
    <listener-class>com.example.xxxListener</listener-class>
</listener>
2. 安全场景
代码审计逻辑分析
红队：内存马植入
蓝队：内存马排查清理
3. 案例演示
Session 状态监听
