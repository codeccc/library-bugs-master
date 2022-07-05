# 使用`FastJSON`遇到的问题

## 简介

如果实体类的字段中使用`is`开头，在使用相关JSON解析库时，可能会遇到序列化与反序列化异常的问题。

## 具体描述

因为is开头的字段，生成的**get**方法是`is_xxx（）`形式，生成的**set**方法是`set_xxx`形式，而不是以 **get/set**开头，由此产生一些问题。



#### 总结

1. is开头的非boolean类型字段，使用getIsXXX方法，序列化后字段名不变
2. is开头的非boolean类型字段，使用isXXX方法，序列化之后消失
3. is开头的boolean类型字段，使用getIsXXX方法，序列化之后字段名不变
4. is开头的boolean类型字段，使用isXXX方法，序列化之后字段名前的is被去除

## 解决办法

### 1. 手动添加get/set开头的方法

模仿编辑器自动生成的get、set方法，手动给is开头的字段添加get/set方法。

### 2. 字段名注意不要以is开头

需要前后端统一，避免使用is开头字段

### 3.修改编辑器的字段生成模板



![image.png](https://img-blog.csdnimg.cn/img_convert/afbe3bfd8e6100d6cd726e4caf8601c1.png)