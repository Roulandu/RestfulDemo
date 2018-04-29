数据库创建请参照demo.sql

查询操作：HTTP.GET
1.查询对应id的 address:8080/demo/book/getBook/{id}		例如:192.168.1.101:8080/demo/book/getBook/1
2.查询所有的 address:8080/demo/book/getBooks			例如:192.168.1.101:8080/demo/book/getBooks

添加操作：HTTP.POST
参数格式:JSON HTTP请求头信息Content-Type=application/json
address:8080/demo/book/addBook
例如:
192.168.1.101:8080/demo/book/addBook
参数：{"bookName":"《机器学习》","bookAuthor":"周志华","bookPress":"清华出版社","bookPrice":"66.2"}

修改操作：HTTP.PUT
参数格式:JSON HTTP请求头信息Content-Type=application/json
address:8080/demo/book/updateBook/{id}
例如:
192.168.1.101:8080/demo/book/updateBook/3
参数：{"bookName":"《机器学习》","bookAuthor":"周志华","bookPress":"没有出版社","bookPrice":"100.34"}

删除操作：HTTP.DELETE
address:8080/demo/book/deleteBook/{id}		例如:192.168.1.101:8080/demo/book/deleteBook/3	
