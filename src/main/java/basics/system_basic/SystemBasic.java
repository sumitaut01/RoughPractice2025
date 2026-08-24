package basics.system_basic;

public class SystemBasic {

    public static void main(String[] args) {


        System.setProperty("first", "valueofFirst");

        System.out.println(System.getProperty("first"));//valueofFirst
        System.out.println(System.getProperty("firstNonExisting"));//null

        System.out.println(System.getenv());//map
        //{USERDOMAIN_ROAMINGPROFILE=WORK, PROCESSOR_LEVEL=6, EFC_8560_1262719628=1, SESSIONNAME=Console, ALLUSERSPROFILE=C:\ProgramData, PROCESSOR_ARCHITECTURE=AMD64, EFC_8560_4126798990=1, ANDROID_HOME=C:\Users\sumit\AppData\Local\Android\Sdk, PSModulePath=C:\Program Files\WindowsPowerShell\Modules;C:\WINDOWS\system32\WindowsPowerShell\v1.0\Modules, SystemDrive=C:, MAVEN_HOME=D:\Softwares\apache-maven-3.9.11-bin\apache-maven-3.9.11, MOZ_PLUGIN_PATH=C:\Program Files (x86)\Foxit Software\Foxit PDF Reader\plugins\, USERNAME=sumit, ProgramFiles(x86)=C:\Program Files (x86), FPS_BROWSER_USER_PROFILE_STRING=Default, PATHEXT=.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC;.PY;.PYW, DriverData=C:\Windows\System32\Drivers\DriverData, OneDriveConsumer=C:\Users\sumit\OneDrive, IntelliJ IDEA Community Edition=D:\InstalledSoftwares\IntelliJ IDEA Community Edition 2023.1.2\bin;, JENKINS_HOME=D:\Softwares\JenkinsData, ProgramData=C:\ProgramData, ProgramW6432=C:\Program Files, __PSLockDownPolicy=0, HOMEPATH=\Users\sumit, PROCESSOR_IDENTIFIER=Intel64 Family 6 Model 140 Stepping 1, GenuineIntel, ProgramFiles=C:\Program Files, PUBLIC=C:\Users\Public, windir=C:\WINDOWS, =::=::\, ZES_ENABLE_SYSMAN=1, OPENSSL_CONF=D:\Program Files\etc\openssl.cnf, LOCALAPPDATA=C:\Users\sumit\AppData\Local, ChocolateyLastPathUpdate=134005986972654920, USERDOMAIN=WORK, FPS_BROWSER_APP_PROFILE_STRING=Internet Explorer, LOGONSERVER=\\WORK, JAVA_HOME=D:\Softwares\jdk-21_windows-x64_bin\jdk-21.0.8, EFC_8560_2283032206=1, OneDrive=C:\Users\sumit\OneDrive, APPDATA=C:\Users\sumit\AppData\Roaming, EFC_8560_2775293581=1, ChocolateyInstall=C:\ProgramData\chocolatey, CommonProgramFiles=C:\Program Files\Common Files, Path=C:\Users\sumit\AppData\Local\Programs\Python\Python313\Scripts\;C:\Users\sumit\AppData\Local\Programs\Python\Python313\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Users\sumit\AppData\Local\Android\Sdk\platform-tools;C:\Program Files\Graphviz\bin;C:\Users\sumit\AppData\Local\Programs\Python\Python313\Lib\site-packages\androguard;D:\Program Files\nodejs\;C:\ProgramData\chocolatey\bin;C:\Program Files\PuTTY\;C:\Program Files\Git\cmd;D:\Kubernetes;C:\Users\sumit\AppData\Local\Microsoft\WindowsApps;D:\InstalledSoftwares\IntelliJ IDEA Community Edition 2023.1.2\bin;C:\Users\sumit\AppData\Local\Programs\Microsoft VS Code\bin;C:\Users\sumit\AppData\Local\Microsoft\WinGet\Links;C:\Users\sumit\AppData\Local\Programs\Ollama;C:\Users\sumit\AppData\Local\Microsoft\WinGet\Packages\Genymobile.scrcpy_Microsoft.Winget.Source_8wekyb3d8bbwe\scrcpy-win64-v3.1;C:\Users\sumit\AppData\Local\GitHubDesktop\bin;C:\Users\sumit\AppData\Local\Microsoft\WindowsApps;C:\Users\sumit\AppData\Roaming\npm;D:\Softwares\jdk-21_windows-x64_bin\jdk-21.0.8\bin;D:\Softwares\apache-maven-3.9.11-bin\apache-maven-3.9.11\bin;D:\Program Files\JetBrains\PyCharm 2025.2.2\bin;C:\Users\sumit\AppData\Local\Microsoft\WinGet\Packages\Anthropic.ClaudeCode_Microsoft.Winget.Source_8wekyb3d8bbwe;, PyCharm=D:\Program Files\JetBrains\PyCharm 2025.2.2\bin, EFC_8560_1592913036=1, OS=Windows_NT, COMPUTERNAME=WORK, EFC_8560_3789132940=1, PROCESSOR_REVISION=8c01, CommonProgramW6432=C:\Program Files\Common Files, ComSpec=C:\WINDOWS\system32\cmd.exe, SystemRoot=C:\WINDOWS, TEMP=C:\Users\sumit\AppData\Local\Temp, HOMEDRIVE=C:, USERPROFILE=C:\Users\sumit, TMP=C:\Users\sumit\AppData\Local\Temp, CommonProgramFiles(x86)=C:\Program Files (x86)\Common Files, NUMBER_OF_PROCESSORS=8, IDEA_INITIAL_DIRECTORY=C:\WINDOWS\system32}


        System.out.println(System.getProperties());
        /*



         */
        System.out.println(System.lineSeparator());
        //Returns the platform-specific line separator (\n on Linux/Mac, \r\n on Windows) — preferred over hardcoding "\n" for portability.



       // Q: How do you pass a custom system property to a running Java application?
         //       A: Via the -D JVM flag at startup, e.g. java -Dmyapp.env=staging -jar app.jar, then read it with System.getProperty("myapp.env").

        System.exit(200);//Process finished with exit code 200
        //no further execution



        System.out.println("Exited");

    }
}
