<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>魔术变量</title>
</head>
<body>
	<?php  //“.”相当于js中的“+”
		echo "这是第". __LINE__.'行'.'<br>';       //自动输出当前的行数
		echo '该文件位于"'.__FILE__.'"'.'<br>';           //输出文件的目录，到自己的名字
		echo '该文件位于"'.__DIR__.'"<br>';				//输出文件目录，并不输出自己的名字
		function add($x,$y){
			echo '函数名为"'.__FUNCTION__.'"<br>';   //输出函数名称  类似于_METHOD_
			return $x+$y;
		}
		echo '1+2的和为'.add(1,2).'<br>';

		class ClassName{
			var $t1;           //声明成员变量
			function ClassName_function(){
				echo '类的名字为'.__CLASS__.'"<br>';
			}
		}
		$t = new ClassName();
		$t->ClassName_function();      //必须用指针
	?>
</body>
</html>