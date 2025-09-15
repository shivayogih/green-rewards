@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if ""%1"" == """" goto main
@if "%1" == "--help" goto main
@if "%1" == "-h" goto main
@if "%1" == "-?" goto main
@if "%1" == "help" goto main

:main
@echo off
setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass any JVM options to Gradle.
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
_echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
echo.
goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

set JAVA_EXE=%JAVA_HOME%/jre/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
echo.
goto fail

:init
rem Grab all arguments
set CMD_LINE_ARGS=%*

rem Use the maximum available, or set MAX_FD != -1 to use that value.
set MAX_FD=maximum

rem Add wiring for remote debugging.
if not "%GRADLE_OPTS%" == "" (
    echo %GRADLE_OPTS% | findstr /I "jdwp" > NUL
    if "%ERRORLEVEL%" == "0" (
        rem Get the attach port.
        for /f "usebackq tokens=1,2 delims==" %%a in (`"%JAVA_EXE%" -cp "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain --get-attach-port %CMD_LINE_ARGS%`) do (
            if "%%a" == "org.gradle.daemon.port" set ATTACH_PORT=%%b
        )
        if not "%ATTACH_PORT%" == "" (
            rem The daemon is running. Attach to the daemon.
            echo Attaching to the Gradle daemon at port %ATTACH_PORT%
            set GRADLE_OPTS=-agentlib:jdwp=transport=dt_socket,server=n,address=127.0.0.1:%ATTACH_PORT% %GRADLE_OPTS%
        ) else (
            rem The daemon is not running. Attach directly to the new process.
            set GRADLE_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 %GRADLE_OPTS%
        )
    )
)

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

rem Split up the JVM options only if the JDK is IBM's
"%JAVA_EXE%" -version 2>&1 | findstr /I "IBM" > NUL
if not "%ERRORLEVEL%" == "0" (
    set JAVA_OPTS=%DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS%
    goto run
)

rem The following four lines are to support the IBM JDK.
set JAVA_OPTS_1=%DEFAULT_JVM_OPTS%
set JAVA_OPTS_2=%JAVA_OPTS%
set JAVA_OPTS_3=%GRADLE_OPTS%
set JAVA_OPTS=%JAVA_OPTS_1% %JAVA_OPTS_2% %JAVA_OPTS_3%

:run
rem Execute Gradle
"%JAVA_EXE%" %JAVA_OPTS% -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%

:end
rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable GRADLE_EXIT_CONSOLE if you need the _script exit code instead of the launcher exit code.
if not "%GRADLE_EXIT_CONSOLE%" == "" (
    exit /b 1
) else (
    exit 1
)

:mainEnd
if "%GRADLE_EXIT_CONSOLE%" == "" (
    exit /b %ERRORLEVEL%
) else (
    exit %ERRORLEVEL%
)
