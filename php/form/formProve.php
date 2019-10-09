<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>表单验证</title>
</head>
<body>
    <?php
    $nameError = $addressError = '';
    $name = $email = $address = $beizhu =$sex = '';
    if($_SERVER["REQUEST_METHOD"] == 'POST'){    //必须用大写
        $name = $_POST['name'];
        $email = $_POST['email'];
        $address = $_POST['address'];
        $beizhu = $_POST['beizhu'];
        $sex = $_POST['sex'];
    }
    if(empty($nameError)){         //验证是否为空
        $nameError = '姓名是必须的';
    }
    if(!preg_match('/^[a-zA-Z ]*$/',$name)){  //int preg_match ( string $pattern , string $subject [, array $matches [, int $flags ]] )
        // 在 subject 字符串中搜索与 pattern 给出的正则表达式相匹配的内容。如果提供了 matches ，则其会被搜索的结果所填充。$matches[0] 将包含与整个模式匹配的文本，$matches[1] 将包含与第一个捕获的括号中的子模式所匹配的文本，以此类推。
        $nameError = '只允许字母和空格';
    }
    if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$address)) {  //验证url
        $addressError = "非法的 URL 的地址";
    }
    ?>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">   <!--交到本页面-->
        姓名：
        <input type="text" name="name"> <?php echo $nameError;?><br>
        E-mail:
        <input type="email" name="email"><br>   <!--type = email 验证是否为email-->
        网址：
        <input type="text" name="address"><?php echo $addressError;?><br>
        备注：
        <textarea name="beizhu" id="" cols="30" rows="10"></textarea><br>
        性别：
        <input type="radio" value="男" name="sex">男
        <input type="radio" value="女" name="sex">女<br>
        <button type="submit">submit</button>
    </form>


</body>
</html>