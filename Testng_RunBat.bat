set projectLocation=D:\Automation\Linga_BO_Revamp
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\jarfiles\*
java org.testng.TestNG %projectLocation%\testng.xml
pause
