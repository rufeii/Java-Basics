# JavaEE - Servlet / Filter / Listener 笔记

## 一、Servlet

### 1. 创建方式

#### 注解方式（推荐）
```java
@WebServlet("/test")
XML 配置方式
<servlet>
    <servlet-name>test</servlet-name>
    <servlet-class>com.example.TestServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>test</servlet-name>
    <url-pattern>/test</url-pattern>
</servlet-mapping>
2. 生命周期（快捷键：Alt + Insert）
init()      // 初始化
service()   // 处理请求（核心）
doGet()     // GET 请求
doPost()    // POST 请求
destroy()   // 销毁
3. 请求与响应处理
HttpServletRequest（请求）
getParameter(name)         // 获取单个参数
getParameterValues(name)   // 获取多个参数
HttpServletResponse（响应）
setCharacterEncoding() // 设置编码
setContentType()       // 设置响应类型
getWriter()            // 获取输出流
PrintWriter out = response.getWriter();
out.print("hello");
二、Filter（过滤器）
1. 概念

Filter 是用于拦截 Web 请求和响应的组件。

👉 本质：
在请求到达 Servlet 前 / 响应返回前进行处理

2. 常见用途
权限控制
XSS 检测
敏感词过滤
数据压缩
安全防护（红蓝对抗）
3. 创建方式
注解方式
@WebFilter("/xss")
XML 配置方式
<filter>
    <filter-name>xssFilter</filter-name>
    <filter-class>com.example.filter.xssFilter</filter-class>
</filter>

<filter-mapping>
    <filter-name>xssFilter</filter-name>
    <url-pattern>/xss</url-pattern>
</filter-mapping>
4. 生命周期方法
init()
doFilter()
destroy()
5. 执行流程
请求 → Filter → Servlet → Filter → 响应
6. 安全场景
Payload 检测
权限控制
内存马植入（红队）
内存马清理（蓝队）
三、Listener（监听器）
1. 概念

用于监听 Web 应用中的事件变化

2. 监听对象
ServletContext
HttpSession
ServletRequest
3. 监听内容
对象创建 / 销毁
属性变化
请求生命周期
4. 创建方式
注解方式
@WebListener
XML 配置方式
<listener>
    ...
</listener>
5. 常用方法

（根据不同 Listener 接口不同）

6. 执行流程
事件发生 → Listener 触发 → 执行逻辑
7. 安全场景
代码审计（分析触发链）
内存马植入（红队）
内存马清理（蓝队）
8. 示例
Session 创建监听
Session 销毁监听
