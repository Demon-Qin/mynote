# git

### git 基础设置

1.查看方式 Git Bash

2.姓名邮箱git config  --global  user.

3.创建文件  git init 看文件位置

4.git status 查看

5.git add “文件名”添加

6.git commit -m"备注"提交

7.git status

8.查看 git log      git log --pretty=oneline（记前面6-7位d73776c）

<img src="C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600308901885.png" alt="1600308901885" style="zoom:50%;" />

9.撤回 git  reset --hard d73776c

10.修改之后查看修改  git diff

### git 与idea

1.setting      V C    添加GitHub账号

2.Terminal       git init      git add .(添加所有文件) 有空格

​    git config core.autocrlf true

git status     git add .   git commit

推送  git push -u origin master

![1600410422150](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600410422150.png)

git pull  把远程操作在本地修改

### git 在本地上传到github

git clone +github那个网址

cd  +要上传到 的github项目名称

git status 查看

git add “文件名”添加

git commit -m"备注"提交



![1600423971455](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600423971455.png)

### git分支

git pull 

git branch 查看

git checkout +支部名称   切换

修改之后 add commit push



git merge dev合并分支 

然后 add commit push



git branch -d dev 删除分支

git branch 

git branch -r -d origin/dev  删除远程（GitHub上的）dev

git push origin ：dev

![1600505366374](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600505366374.png)

（这样算删除成功）

