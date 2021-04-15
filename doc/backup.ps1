
Copy-Item C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud20210413\* C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\ -recurse -Force

Copy-Item -path C:\Users\JinTweebaa\Documents\tweebaa\cloud\backup.ps1 -destination C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\ -recurse -Force

Copy-Item C:\Users\JinTweebaa\Documents\tweebaa\cloud\spring-cloud-log.txt C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\ -recurse -Force

Copy-Item C:\Users\JinTweebaa\Documents\tweebaa\cloud\test-sql.sql C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\ -recurse -Force

mkdir C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\

git status
git add .
git commit -m "first module"
git push
