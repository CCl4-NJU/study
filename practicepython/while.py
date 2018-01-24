#!/usr/bin/python
# -*- coding: UTF-8 -*-
count = 0;
while(count <9):
	print "The count is:" , count;
	count = count + 1 ;

for i in 'python':
	if i == 'h':
		pass                                 #什么也不进行直接跳过
		print '这是pass模块'
	print '当前字母',i;

fruits = ['banana','apple','mango'];
for fruit in fruits:
	print '当前水果',fruit;