<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Array</title>
</head>
<body>
    <?php
        $array1 = array(     //自动分配 ID 键的多维数组
            'array1[0]'=>array(
                'array1[0][0]',
                'array1[0][1]'
            ),
            'array1[1]'=>array(
                'array1[1][0]',
                'array1[1][1]',
                'array1[1][2]'
            )

        );
        echo '<pre>';     //格式化输出
        print_r($array1);    //输出多维数组
        echo '</pre>';
    ?>
</body>
</html>