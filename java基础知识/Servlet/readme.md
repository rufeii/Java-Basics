📌 一、Servlet 概念

Servlet 是运行在 Web 服务器或应用服务器上的程序，它充当：

👉 Web 浏览器（客户端）
👉 与 HTTP 服务器 / 数据库 / 应用程序之间的 中间层

主要作用
接收网页表单的用户输入
调用数据库或其他资源
动态生成网页内容

👉 属于 JavaEE 开发核心内容（重点）

🛠️ 二、JavaEE - IDEA 开发环境
环境准备
安装 IDEA（并激活）
安装开发插件
安装 JDK
安装 Tomcat
项目创建
新建 Java Web 项目
配置 Tomcat
配置 JDK
🚀 三、创建和使用 Servlet
方式一：继承 HttpServlet
public class TestServlet extends HttpServlet {
}
方式二：web.xml 配置路由
<servlet>
    <servlet-name>test</servlet-name>
    <servlet-class>com.example.TestServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>test</servlet-name>
    <url-pattern>/test</url-pattern>
</servlet-mapping>
方式三：注解配置（推荐）
@WebServlet("/test")
🔄 四、Servlet 生命周期
常用快捷键

Alt + Insert

生命周期方法
init()       // 初始化
service()    // 处理请求（核心）
doGet()      // 处理 GET 请求
doPost()     // 处理 POST 请求
destroy()    // 销毁
📥 五、请求处理与回显
1️⃣ HttpServletRequest（请求）
getParameter(name)         // 获取单个参数
getParameterValues(name)   // 获取多个参数
2️⃣ HttpServletResponse（响应）
setCharacterEncoding() // 设置编码
setContentType()       // 设置响应类型
getWriter()            // 获取输出流
PrintWriter out = response.getWriter();
out.print("hello");
🧱 六、Filter（过滤器）
📌 概念

Filter 是用于 拦截 Web 请求和响应 的组件。

👉 本质：在请求到达 Servlet 前 / 响应返回前进行处理

📌 常见用途
权限控制
XSS 检测
敏感词过滤
数据压缩
安全防护（红蓝对抗）
📌 创建过滤器
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
📌 生命周期方法
init()
doFilter()
destroy()
📌 执行流程
请求 → Filter → Servlet → Filter → 响应
📌 安全场景
Payload 检测
权限控制
内存马植入（红队）
内存马清理（蓝队）
🎧 七、Listener（监听器）
📌 概念

用于监听 Web 应用中的 事件变化

📌 监听对象
ServletContext
HttpSession
ServletRequest
📌 监听内容
对象创建 / 销毁
属性变化
请求生命周期
📌 创建方式
注解方式
@WebListener
XML 配置
<listener>
    ...
</listener>
📌 常用方法

（根据不同 Listener 接口不同）

📌 执行流程
事件发生 → Listener 触发 → 执行逻辑
📌 安全场景
代码审计（分析触发链）
内存马植入（红队）
内存马清理（蓝队）
📌 示例
Session 创建监听
Session 销毁监听
