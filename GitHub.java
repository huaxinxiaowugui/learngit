1:集中式与分布式
	CVS和SVN都是集中式的版本控制系统和SVN都是集中式的版本控制系统
	Git是分布式版本控制系统

	先说集中式版本控制系统，版本库是集中存放在中央服务器的，而干活的时候，用的都是自己的电脑，所以要先从中央服务器取得最新的版本，然后开始干活，干完活了，再把自己的活推送给中央服务器。中央服务器就好比是一个图书馆，你要改一本书，必须先从图书馆借出来，然后回到家自己改，改完了，再放回图书馆。
	
	集中式版本控制系统最大的毛病就是必须联网才能工作，如果在局域网内还好，带宽够大，速度够快，可如果在互联网上，遇到网速慢的话，可能提交一个10M的文件就需要5分钟，这还不得把人给憋死啊。
	
	分布式版本控制系统根本没有“中央服务器”，每个人的电脑上都是一个完整的版本库，这样，你工作的时候，就不需要联网了，因为版本库就在你自己的电脑上。既然每个人电脑上都有一个完整的版本库，那多个人如何协作呢？比方说你在自己电脑上改了文件A，你的同事也在他的电脑上改了文件A，这时，你们俩之间只需把各自的修改推送给对方，就可以互相看到对方的修改了。
	
	和集中式版本控制系统相比，分布式版本控制系统的安全性要高很多，因为每个人电脑里都有完整的版本库，某一个人的电脑坏掉了不要紧，随便从其他人那里复制一个就可以了。而集中式版本控制系统的中央服务器要是出了问题，所有人都没法干活了。
	
2:git命令
	注册用户名:
	git config --global user.name "Your Name"
	注册邮箱:
	git config --global user.mail "email@example.com"
	
	创建仓库	git init 
	添加文件	git add 文件名(带后缀)
	提交文件	git commit -m "提交说明"
	查看状态	git status
	比较内容	git diff
	查看提交日志	git log		以便确定要回退到哪个版本。
	简明日志	git log --pretty=oneline
		前面的字符串为commit id
	查看命令历史	git reflog 以便确定要回到未来的哪个版本。
	时光机穿梭	git reset --hard commit_id
	回退上一版本	git reset --hard HEAD^
		HEAD指向的版本就是当前版本
	
	
3:工作区与暂存区
	stage	暂存区
		git add 就是将文件添加到暂存区
	master	分支
		git commit 就是将文件提交到当前分支
	HEAD	指向master的一个指针
	
	我们修改文件时,可以将修改的文件添加到暂存区,之后一起提交到分支上
	
	查看工作区和版本库里面最新版本的区别
		git diff HEAD -- readme.txt	
		
4:撤消修改  删除

	git checkout -- file 撤销修改
		让文件回到最近一次Git commit或git add时的状态
	
	git reset HEAD file  撤消修改
		把暂存区的修改撤销掉(unstage),重新返回工作区
		
	git rm file		从版本中删除文件
	git commit -m "提交说明"	删除并提交
	如果删错了,版本库还是有的
		git checkout -- file
			将误删的文件恢复到最新版本
	
5:关联远程库
	
	1.申请一个github账号
	2.在本地创建ssh key:
		ssh-keygen -t rsa -C "邮箱地址"	
		邮箱地址改为你在github上注册的邮箱，之后会要求确认路径和输入密码，我们这使用默认的一路回车就行。成功的话会在用户目录下生成.ssh文件夹,进去,打开id_rsa.pub,复制里面的key。
		
		回到github上，进入Account Settings（账户配置）,左边选择SSH Keys,Add SSH Key,title随便填,粘贴在你电脑上生成的key。
	3.验证是否成功
		ssh -T git@github.com
		
		如果是第一次的会提示是否continue,输入yes就会看到:You've successfully authenticated,but GitHub does not provide shell access .这就表示已成功连上github. 
	4.创建一个远程仓库
	5.本地关联远程仓库
		git remote add origin git@github.com:用户名/远程地址
	6.本地文件提交
		git push origin master
		把本地master分支的最新修改推送至GitHub
	
6:分支管理

	从远程库克隆一个本地库
		git clone git@github.com:用户名/远程地址
	从本地库克隆一个本地库
		git clone 地址

	创建与合并分支
		git checkout -b dev		创建dev分支并切换到dev分支
			-b参数表示创建并切换,相当于两条命令:
			git branch dev  创建分支
			git checkout dev 切换分支
		
		git add		添加文件
		git commit	提交文件
		git checkout master	切换master分支
		git marge dev 	dev分支合并到master分支上
		git branch -d dev	删除分支
		git branch 	查看分支(前面有*,代表当前分支)
		
		git log --graph --pretty=oneline --abbrev-commit
			展示分支的合并情况(分支合并图)
	
	
	
	
	
	
	
	
	
	