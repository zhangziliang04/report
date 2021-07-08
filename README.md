## 简介
&emsp;  &emsp;  AJ-Report是一个完全开源的BI平台，酷炫大屏展示，能随时随地掌控业务动态，让每个决策都有数据支撑。<br>
&emsp;  &emsp;  多数据源支持，内置mysql、elasticsearch、kudu驱动，支持自定义数据集省去数据接口开发，支持17种大屏组件，不会开发，照着设计稿也可以制作大屏。<br>
&emsp;  &emsp;  三步轻松完成大屏设计：配置数据源---->写SQL配置数据集---->拖拽配置大屏---->保存发布。欢迎体验。
## 在线体验
#### &emsp;  电脑在线体验: [https://report.anji-plus.com/index.html](https://report.anji-plus.com/index.html "链接")  &emsp;体验账号：guest  密码：guest
#### &emsp;  在线文档: [https://report.anji-plus.com/report-doc/](https://report.anji-plus.com/report-doc/ "doc")<br>
#### &emsp;  在线提问: [https://gitee.com/anji-plus/report/issues](https://gitee.com/anji-plus/report/issues "issue")<br>

## 发行版本
#### &emsp;  下载链接：[https://gitee.com/anji-plus/report/releases](https://gitee.com/anji-plus/report/releases "下载链接")<br>

## 功能概述
#### &emsp;  组件介绍
&emsp;&emsp; 大屏设计（AJ-Report）是一个可视化拖拽编辑的，直观，酷炫，具有科技感的图表工具全开源项目。
内置的基础功能包括数据源，数据集，报表管理，项目部分截图如下。<br>
**在线案例还在努力创造中，敬请期待！！！**
![操作](https://images.gitee.com/uploads/images/2021/0703/094742_c0243f70_1728982.gif "2021-07-03_09-43-50.gif")

## 数据流程图
![An image](https://images.gitee.com/uploads/images/2021/0630/160451_31bb9052_1728982.png)

## 打包目录
```
├── bin                                           启动命令脚本
│   ├── logs                                      启动日志目录
│   ├── cache                                     本地缓存目录
│   ├── startup.cmd
│   ├── shutdown.cmd
│   ├── startup.sh
│   └── shutdown.sh
├── config                                        配置文件目录
├── lib                                           自定义扩展包
├── target                                        report-core核心包
```

## 系统目录
```
├── doc                                           文档源码
│   ├── docs
│   ├── package.json
│   └── README.md
├── pom.xml                                       父pom，jar版本管理
├── report-core                                   java源码
│   ├── pom.xml                                   gaea父pom，jar版本管理
│   └── README.md
├── report-ui                                     前端vue源码
├── LICENSE
├── README.md
```

## 核心技术
### 后端
- [Spring Boot2.3.5.RELEASE](https://spring.io/projects/spring-boot/): Spring Boot是一款开箱即用框架，让我们的Spring应用变的更轻量化、更快的入门。 在主程序执行main函数就可以运行。你也可以打包你的应用为jar并通过使用java -jar来运行你的Web应用；
- [Mybatis-plus3.3.2](https://mp.baomidou.com/): MyBatis-plus（简称 MP）是一个 MyBatis (opens new window) 的增强工具。
- [flyway5.2.1](https://flywaydb.org/): 主要用于在你的应用版本不断升级的同时，升级你的数据库结构和里面的数据
### 前端
- [npm](https://www.npmjs.com/)：node.js的包管理工具，用于统一管理我们前端项目中需要用到的包、插件、工具、命令等，便于开发和维护。
- [webpack](https://webpack.docschina.org/)：用于现代 JavaScript 应用程序的_静态模块打包工具
- [ES6](https://es6.ruanyifeng.com/)：Javascript的新版本，ECMAScript6的简称。利用ES6我们可以简化我们的JS代码，同时利用其提供的强大功能来快速实现JS逻辑。
- [vue-cli](https://cli.vuejs.org/)：Vue的脚手架工具，用于自动生成Vue项目的目录及文件。
- [vue-router](https://router.vuejs.org/)： Vue提供的前端路由工具，利用其我们实现页面的路由控制，局部刷新及按需加载，构建单页应用，实现前后端分离。
- [element-ui](https://element.eleme.cn/#/zh-CN)：基于MVVM框架Vue开源出来的一套前端ui组件。
- [avue](https://www.avuejs.com/): 用该组件包裹后可以变成拖拽组件,采用相对于父类绝对定位;用键盘的上下左右也可以控制移动
- [vue-echarts](https://www.npmjs.com/package/vue-echarts/): vue-echarts是封装后的vue插件,基于 ECharts v4.0.1+ 开发
- [vue-superslide](https://www.npmjs.com/package/vue-super-slider/): Vue-SuperSlide(Github) 是 SuperSlide 的 Vue 封装版本
- [vuedraggable](https://github.com/SortableJS/Vue.Draggable/): 是一款基于Sortable.js实现的vue拖拽插件。

## 近期计划
-   完善地图插件
-   完善表格插件
-   丰富自定义框图、挂件
-   丰富更多图表组件

## 技术支持
**如有问题，请提交 [Issue](https://gitee.com/anji-plus/report/issues) <br>**
微信群：<br>
<img src="https://images.gitee.com/uploads/images/2021/0707/154657_c27241c3_1728982.jpeg" width = "200" height = "200" align=left/>
#### 开源不易，劳烦各位star ☺



