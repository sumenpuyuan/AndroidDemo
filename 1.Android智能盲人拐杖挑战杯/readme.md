这个东西是参加院挑战杯时做的一个东西，push的时候有80多兆，大部分都是素材，而且没用，但是我不舍得删，所以留下来了。然而院赛都没过（其中发生了很多不好的事情，唉，成长）
有几个可以改进的地方，先记录下来

## 1. 获取盲人数据部分 ##
	自己获取盲人坐标位置，是用户一打开软件然后主线程向服务器发送请求，实际应用应该是每隔一段时间进行更新数据。
## 2.地图显示盲人坐标问题 ##
    自己是一拿到坐标，然后在地图上做标记，然而盲人是可能动的，所以标记也应该随之跟着移动
## 3.坐标转换问题 ##
   宇航他们硬件给我的数据是gps坐标，高德的是人家自己的坐标，他们的转换需要用到高德提供的web api，然而这个最多调用几万次，实际是我们每隔几秒就需要调一次，次数根本不够用。（服务端目录里提供服务端代码）
Android启动引导页参考的这里[http://jaeger.itscoder.com/android/2015/11/18/android-splash.html](http://jaeger.itscoder.com/android/2015/11/18/android-splash.html)

服务端文件说明

getAddress.php获取盲人坐标

updateAddress.php设置盲人坐标

server.php和服务器建立socket连接，然后通过坐标转换api，字符串处理存到数据库里。
<img src="Gaode/images/3.jpg" width="320"><br>
<img src="Gaode/images/2.jpg" width="320"><br>
<img src="Gaode/images/1.jpg" width="320">
