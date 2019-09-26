create table userdetails(
	id int not null primary key, #主键
	username varchar(50) not null, #姓名
  	password varchar(50) not null, # 密码
  	sex char(1) not null,  # 性别1--男，0--女
  	hobby varchar(200),   # 爱好
  	address varchar(100), # 地址
  	degree varchar(50),   # 年级
  	remark varchar(500)  # 备注
);

insert into userdetails(id,username,password,sex) values(1,'zhansan','zs123',1);
insert into userdetails(id,username,password,sex) values(2,'lisi','lisi123',1);
insert into userdetails(id,username,password,sex) values(3,'wangwu','ww123',1);
insert into userdetails(id,username,password,sex) values(4,'maliu','ml123',1);
insert into userdetails(id,username,password,sex) values(5,'linghc','lhc123',1);
insert into userdetails(id,username,password,sex) values(6,'zhaokl','zkl123',1);