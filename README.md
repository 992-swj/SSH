# SSH(Struts+Spring+Hibernate)项目整合
- 资源下载（如果需要源码，首先你要能打开githib官网）

jar地址：https://pan.baidu.com/s/1W9sPHBLf3Auqzw0m9nZQBg

提取码：qanq

源码项目：<https://github.com/992-swj/SSH>


+ 步骤
    1. 创建项目
    2. 加入jar文件
    3. 通过Myeclipse的反向工程创建实体类、配置文件等

配置applicationContext.xml

+ Spring必备头文件
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.1.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">
```
+ Spring详细内容讲解
1. 配置数据源database.properties
```xml
<!-- 配置数据源 -->
<context:property-placeholder location="classpath:database.properties" />
```
2. 配置dataSource连接池
```xml
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="${driver}"></property>
		<property name="url" value="${url}">
		</property>
		<property name="username" value="${uid}"></property>
		<property name="password" value="${pwd}"></property>
	</bean>
```
3. 配置sqlsessionfactiry，创建session工厂,配置连接Oracle数据库的各种信息
```xml
<bean id="sessionFactory"
		class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
        <!--连接池-->
		<property name="dataSource">
			<ref bean="dataSource" />
		</property>
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">
					org.hibernate.dialect.Oracle9Dialect
				</prop>
				<prop key="hibernate.show_sql">
					true
				</prop>
			</props>
		</property>
         <!--
            mappingResources:通过完全限定获取到Hibernate的bean配置文件
        -->
		<!--<property name="mappingResources">
			<list>
				<value>com/swj/bean/Bookinfo.hbm.xml</value>
				<value>com/swj/bean/Userinfo.hbm.xml</value>
			</list>
		</property>-->
         <!--
            mappingLocations:通过扫描包的方式查找bean下面*所有的hibernate的配置文件
        -->
		 <property name="mappingLocations">
		 	<value>classpath:com/swj/bean/*.hbm.xml</value>
		 </property>
	</bean>
```
4. 处理事务问题
```xml
<bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"></property>
		<property name="dataSource" ref="dataSource"></property>
	</bean>
```
5. web.xml配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">
<!-- 加载Spring配置 -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<!-- 配置Spring的上下文加载监听器 -->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<!-- 配置Hibernate Session自动开启 -->
<filter>
    <filter-name>OpenSessionInViewFilter</filter-name>
    <filter-class>org.springframework.orm.hibernate3.support.OpenSessionInViewFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>OpenSessionInViewFilter</filter-name>
    <url-pattern>*.action</url-pattern>
</filter-mapping>
<!-- 配置Struts2入口-->
<filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
</web-app>
```
6. 编写实体类
7. dao层
8. daoimpl层（继承HibernateDaoSupport，可以直接this.getSession()获取到session，记得关闭session.close()）
9. service层
10. serviceimpl层（未使用注解）

使该类可以访问dao层

```java
private BookInfoDao bookdao;
public BookInfoDao getBookdao() {
		return bookdao;
}

	public void setBookdao(BookInfoDao bookdao) {
		this.bookdao = bookdao;
}
```
11. 配置action，Struts控制层
```java
private BookInfoService services;
	public BookInfoService getServices() {
		return services;
	}


	public void setServices(BookInfoService services) {
		this.services = services;
	}
......(省略业务代码)
```
12. 配置applicationContext.xml，配置bookdao、services,完成三层架构
```xml
<!--获取dao的实现类-->
<bean id="dao" class="com.swj.dao.impl.UserInfoDaoImpl">
    <!--如果不配置sessionFactory,在daoimpl中继承HibernateDaoSupport获取不到session-->
		<property name="sessionFactory" ref="sessionFactory"></property>
</bean>
<!--service-->
<bean id="service" class="com.swj.service.impl.UserInfoServiceImpl">
		<property name="infoDao" ref="dao"></property>
</bean>
<!--action-->
<bean id="action" class="com.swj.action.LoginAction">
		<property name="service" ref="service"></property>
</bean>
```
13. 配置Struts.xml
```xml
<struts>
	<package name="default" namespace="/"  extends="struts-default">
        ......(省略action)
    </package>
</struts>  
```
