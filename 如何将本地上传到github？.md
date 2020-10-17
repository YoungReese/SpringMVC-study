==**如何将本地上传到github？**==

1、首先本地建立仓库，并提交代码（不提交代码无法自动创建分支）

```bash
git init
git add .
git commit -m "description of ur commit"
```

2、github远程仓库建立

手动在github上new一个repository

3、建立本仓库与远程仓库的连接（git@github.com:YoungReese/SpringMVC-study.git是你的github仓库地址）

```bash
git remote add origin git@github.com:YoungReese/SpringMVC-study.git
```

4、获取远程仓库代码（第一次远程仓库新建了README.md和.gitignore文件，可以把它拿下来）

```bash
git pull origin master
```

5、把本地代码push到远程仓库（如果第一次push不成功，可以使用-f强制push上去，第一次以后的操作直接用第一句即可）

```bash
git push origin master

git push -f origin master
```







**额外技巧（可以不使用）**：如果想通过git pull和git push进行操作，还有需要进行set-upatream

有两种设置upstream的方法

1、在`push`的时候指定（==**推荐**==）

语法：

```bash
git push --set-upstream origin my_remote_branch_name
```

在当前环境下的使用

```bash
git push --set-upstream origin master
```

2、在新建分支的时候指定

语法：

```bash
git branch --set-upstream my_local_branch_name origin/my_remote_branch_name
```







**注意**：

当前日期：2020-10-18，由于人权运动，GitHub的默认分支是main分支，而本地分支初始分支名仍然是master，虽然不影响使用，当管理的项目较多的时候，容易记混，需要每次查看下或者push失败时重新push（没有set upstream），因此建议将GitHub上的默认分支名手动改成master。