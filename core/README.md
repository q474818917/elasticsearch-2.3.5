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
```

## elasticsearch 架构图
![image](https://note.youdao.com/yws/public/resource/11b88babe53bdada374c4355f425bf31/xmlnote/WEBRESOURCEa8ced9d265e6e3ccebc28bd349a53c05/7294)

## elasticsearch 源码解析
+ gateway:
+ 

