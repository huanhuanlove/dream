1、docker安装与配置加速器
	#卸载系统之前的docker 
	sudo yum remove docker \
					  docker-client \
					  docker-client-latest \
					  docker-common \
					  docker-latest \
					  docker-latest-logrotate \
					  docker-logrotate \
					  docker-engine			  
					  
	sudo yum install -y yum-utils
	# 配置镜像
	sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
	sudo yum install docker-ce docker-ce-cli containerd.io
	sudo systemctl start docker
	# 设置开机自启动
	sudo systemctl enable docker
	docker -v
	sudo docker images
	# 配置镜像加速
	sudo mkdir -p /etc/docker
	sudo tee /etc/docker/daemon.json <<-'EOF'
	{
	  "registry-mirrors": ["https://89ky7yd5.mirror.aliyuncs.com"]
	}
	EOF
	sudo systemctl daemon-reload
	sudo systemctl restart docker
	
	
2、安装mysql
	sudo docker pull mysql:5.7
	
	#配置启动需要的一些映射路径
	mkdir -p /usr/datas/mysql/mydata/log
	mkdir -p /usr/datas/mysql/mydata/data
	mkdir -p /usr/datas/mysql/mydata/conf
	vim /usr/datas/mysql/mydata/conf/my.conf
		输入：	[client]
				default-character-set=utf8
				[mysql]
				default-character-set=utf8
				[mysqld]
				init_connect='SET collation_connection = utf8_unicode_ci'
				init_connect='SET NAMES utf8'
				character-set-server=utf8
				collation-server=utf8_unicode_ci
				skip-character-set-client-handshake
				skip-name-resolve

	# --name指定容器名字 -v目录挂载 -p指定端口映射  -e设置mysql参数 -d后台运行
	sudo docker run -p 3306:3306 --name mysql \
	-v /usr/datas/mysql/mydata/log:/var/log/mysql \
	-v /usr/datas/mysql/mydata/data:/var/lib/mysql \
	-v /usr/datas/mysql/mydata/conf:/etc/mysql \
	-e MYSQL_ROOT_PASSWORD=root \
	-d mysql:5.7
	
	#设置mysql容器在docker启动的时候启动
	docker update mysql --restart=always
	
	#进入容器 - (无需操作，可尝试进入)
	sudo docker exec -it mysql /bin/bash
	
	#通过win连接mysql
	主机地址为 -> 虚拟机ip, 用户名 -> root， 密码 -> root(上面指定的密码)

3、安装Redis
	mkdir -p /usr/datas/redis/mydata/data
	vim /usr/datas/redis/mydata/conf/redis.conf
		输入：appendonly yes    #开启aof持久化
	docker pull redis
	docker run -p 6379:6379 --name redis \
	-v /usr/datas/redis/mydata/data:/data \
	-v /usr/datas/redis/mydata/conf/redis.conf:/etc/redis/redis.conf \
	-d redis redis-server /etc/redis/redis.conf
	
	#设置redis容器在docker启动的时候启动
	docker update redis --restart=always
	
	#通过win连接redis
	主机地址为 -> 虚拟机ip, 端口8379， 密码 -> 无密码(默认)
	
4、安装nginx
	mkdir -p /usr/datas/nginx/mydata/
	cd /usr/datas/nginx/mydata/
	docker pull nginx:1.10
	# 随便启动一个nginx实例，只是为了复制出配置，放到docker里作为镜像的统一配置
	docker run -p 80:80 --name nginx -d nginx:1.10
	docker container cp nginx:/etc/nginx .    #此时 /usr/datas/nginx/mydata/nginx/ 会有一堆文件
	mv /usr/datas/nginx/mydata/nginx /usr/datas/nginx/mydata/conf
	mkdir -p /usr/datas/nginx/mydata/html
	mkdir -p /usr/datas/nginx/mydata/logs
	
	# 停掉nginx
	docker stop nginx
	docker rm nginx
	# 创建新的nginx
	docker run -p 80:80 --name nginx \
	-v /usr/datas/nginx/mydata/html:/usr/share/nginx/html \
	-v /usr/datas/nginx/mydata/logs:/var/log/nginx \
	-v /usr/datas/nginx/mydata/conf:/etc/nginx \
	-d nginx:1.10
	# 注意一下这个路径映射到了/usr/share/nginx/html，我们在nginx配置文件中是写/usr/share/nginx/html，不是写/usr/datas/nginx/mydata/html
	
	#设置nginx容器在docker启动的时候启动
	docker update nginx --restart=always
	
	#通过win连接访问
	cd /usr/datas/nginx/mydata/html
	vim index.html
	随便写写
	测试 http://虚拟机ip:80
	
	

