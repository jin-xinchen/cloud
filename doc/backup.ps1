
Copy-Item C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud20210413\* C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\ -recurse -Force

Copy-Item -path C:\Users\JinTweebaa\Documents\tweebaa\cloud\backup.ps1 -destination C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\ -recurse -Force

Copy-Item C:\Users\JinTweebaa\Documents\tweebaa\cloud\spring-cloud-log.txt C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\ -recurse -Force

Copy-Item C:\Users\JinTweebaa\Documents\tweebaa\cloud\test-sql.sql C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\ -recurse -Force

# done
# mkdir C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\doc\

Remove-Item -Path "C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-api-commons\target" -recurse -Force
Remove-Item -Path "C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-api-commons\*.iml" -recurse -Force
Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-consumer-order80\target -recurse -Force
Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-consumer-order80\*.iml -recurse -Force

Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-eureka-server7001\target -recurse -Force
Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-eureka-server7001\*.iml -recurse -Force

Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-eureka-server7002\target -recurse -Force
Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-eureka-server7002\*.iml -recurse -Force

Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-provider-payment8001\target -recurse -Force
Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-provider-payment8001\*.iml -recurse -Force

Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-provider-payment8002\target -recurse -Force
Remove-Item -Path C:\Users\JinTweebaa\Documents\tweebaa\cloud\cloud202104github\cloud\cloud-provider-payment8002\*.iml -recurse -Force

cd C:/Users/JinTweebaa/Documents/tweebaa/cloud/cloud202104github/cloud

git status
git add .
git commit -m "first module"
git push
