# TwirlingPlayerSDK
==========
这是时代拓灵全景视频播放器AndroidSDK的文档及使用方法
# 最新版本 version-1.5.6
	运行环境：Android 4.4（API level 19）及其以上版本。
	开发工具：推荐Android Studio 2.0版本及以上
##1. 目录介绍
	1) SDK：SDK所需的文件。
	如果开发者重新建立工程或将播放器集成到自己工程，请将该目录下所有文件拷贝到工程对应目录下。
	2) Demo：播放器sourcecode：
	此demo是一个module，导入project后使用。
	SimpleVrVideoActivity.java:播放器各种功能的实现。
	HLSActivity.java:直播播放器功能的实现。
	FragmentOnline.java：在线播放和下载页面。
	FragmentDownload.java：本地文件播放。
##2. 接口介绍：
[![](https://jitpack.io/v/xieqiupeng/TwirlingPlayerSDK.svg)](https://jitpack.io/#xieqiupeng/TwirlingPlayerSDK)
##3. 项目展示：
![image](https://github.com/xieqiupeng/TwirlingPlayerSDK/blob/master/images/0.png)
![image](https://github.com/xieqiupeng/TwirlingPlayerSDK/blob/master/images/1.png)
##3. 工程配置：
第一步：在工程app/libs目录下放入aar包。
--------
第二步：导入aar包。<br/>
--------
菜单栏选择File->Project Structor->Modules->Dependencies,点击+号，
选择File dependency，选择jar包导入。
如果导入失败可以找到moudle下的build.gradle文件进行修改：<br/>
	<code>repositories {</code><br/>
	<code>			flatDir {<br/></code><br/>
	<code>			dirs 'libs'</code><br/>
	<code>			}</code><br/>
	<code>}</code><br/>
	<p></p>
<code>dependencies {</code><br/>
<code>	compile fileTree(dir: 'libs', include: ['*.jar'])</code><br/>
<code>	compile(name: 'videowidget', ext: 'aar')</code><br/>
<code>	compile(name: 'common', ext: 'aar')</code><br/>
<code>	compile(name: 'commonwidget', ext: 'aar')</code><br/>
<code>}</code><br/>
<p></p>
###第三步：修改AndroidManifest.xml文件，在里面加入：<br/>
<code>\<!-- These permissions are used by Google VR SDK to get the best Google VR headset profiles. !--></code><br/>
<code>\<uses-permission android:name="android.permission.INTERNET" /></code><br/>
<code>\<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /></code><br/>
<code>\<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" /></code><br/>
<code>\<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /></code><br/>
<code>\<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /></code><br/>
<code>\<uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/></code><br/>
在你的\<intent-filter>里添加：<br/>
----------
<code>\<category android:name="com.google.intent.category.CARDBOARD" /></code><br/>
##4. issue<br/>
如果有bug反馈或者建议，欢迎在issues里讨论。<br/>
