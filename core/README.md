## elasticsearch 源码编译
+ 1、依赖编译，可能中央仓库没有该依赖
```$xslt
cd dev-tools 
mvn clean install -Dmaven.test.skip=true

cd rest-api-spec
mvn clean install -Dmaven.test.skip=true

cd core
mvn clean compile -Dmaven.test.skip=true
```
+ 可能会存在的问题：
```$xslt
jar hell:产生的原因是jar包冲突，UserJvmOptionsService->ant-javafx.jar,packager.jar，解决办法：Project Structure 中将ant-javafx.jar重命名
```
+ 参考文档：
```$xslt
1、http://www.opscoder.info/es_discover.html
2、https://blog.csdn.net/thomas0yang/article/category/6361353
3、https://blog.csdn.net/weixin_36564655/article/details/82736327
```

## elasticsearch 启动流程
+ 启动：Elasticsearch -> Bootstrap -> Node
+ guice依赖注入***Module，包括实例化
+ 启动各个Service，Service的状态在Lifecycle存储，状态由INITIALIZED -> STARTED

## elasticsearch 索引流程


## elasticsearch 架构图
![image](https://note.youdao.com/yws/public/resource/11b88babe53bdada374c4355f425bf31/xmlnote/WEBRESOURCEa8ced9d265e6e3ccebc28bd349a53c05/7294)

## elasticsearch 源码解析
+ Discovery: Node的发现，以及master的选举，默认实现ZenDiscovery
```$xslt
选master的流程：涉及ZenPingService、UnicastZenPing类
1、先ping cluster中的node，排序nodes
2、找出所有可能的master node
3、选取出第一个可能的master node
```

+  Transport:默认实现NettyTransport
```$xslt
1、node之间需要相互通信，每个node都需要启动clientBootstrap和serverBootstrap
2、todo，后面再详细
```

+ 
