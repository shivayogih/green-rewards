#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass any JVM options to Gradle without entering them in this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
darwin=false
linux=false
case "`uname`" in
    CYGWIN*)        cygwin=true        ;;
    Darwin*)        darwin=true        ;;
    Linux)          linux=true         ;;
esac

# For Cygwin, ensure paths are in UNIX format before anything is touched.
if ${cygwin} ; then
    [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
    [ -n "$GRADLE_HOME" ] && GRADLE_HOME=`cygpath --unix "$GRADLE_HOME"`
fi

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done

APP_HOME=`dirname "$PRG"`

# Absolutize APP_HOME
APP_HOME=`cd "$APP_HOME" > /dev/null && pwd`

# Set APP_CLASSPATH
APP_CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME\n\nPlease set the JAVA_HOME variable in your environment to match the\nlocation of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.\n\nPlease set the JAVA_HOME variable in your environment to match the\nlocation of your Java installation."
fi

# Increase the maximum number of open files
if ! ${cygwin} && ! ${darwin} ; then
    if [ "$MAX_FD" = "maximum" ] || [ "$MAX_FD" = "max" ] ; then
        # Use the maximum available.
        MAX_FD_LIMIT=`ulimit -H -n`
        if [ $? -eq 0 ] ; then
            if [ "$MAX_FD_LIMIT" != "unlimited" ] ; then
                ulimit -n $MAX_FD_LIMIT
            fi
        else
            warn "Could not query maximum file descriptor limit"
        fi
    else
        ulimit -n $MAX_FD
    fi
fi

# Add wiring for remote debugging.
if [ -n "$GRADLE_OPTS" ] && `echo "$GRADLE_OPTS" | grep "jdwp" >/dev/null`; then
    # Use the same JDK as Gradle to get the attach port.
    "$JAVACMD" -cp "$APP_CLASSPATH" org.gradle.wrapper.GradleWrapperMain --get-attach-port "$@" 2>/dev/null
    if [ $? -eq 0 ]; then
        ATTACH_PORT=`cat "$APP_HOME/gradle/wrapper/gradle-wrapper.properties" | grep "org.gradle.daemon.port" | cut -d'=' -f2`
        if [ -z "$ATTACH_PORT" ]; then
            # The daemon is not running. Attach directly to the new process.
            GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 $GRADLE_OPTS"
        else
            # The daemon is running. Attach to the daemon.
            echo "Attaching to the Gradle daemon at port $ATTACH_PORT"
            GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=n,address=127.0.0.1:$ATTACH_PORT $GRADLE_OPTS"
        fi
    else
        # Could not get the attach port. Attach directly to the new process.
        GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 $GRADLE_OPTS"
    fi
fi

# For Cygwin, switch paths to Windows format before running java
if ${cygwin} ; then
    APP_HOME=`cygpath --path --windows "$APP_HOME"`
    APP_CLASSPATH=`cygpath --path --windows "$APP_CLASSPATH"`
    [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --path --windows "$JAVA_HOME"`
    [ -n "$GRADLE_HOME" ] && GRADLE_HOME=`cygpath --path --windows "$GRADLE_HOME"`
fi

# Split up the JVM options only if the JDK is IBM's
if `"$JAVACMD" -version 2>&1 | grep "IBM" >/dev/null`; then
    JVM_OPTS=($DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS)
else
    JVM_OPTS="$DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS"
fi

exec "$JAVACMD" $JVM_OPTS -cp "$APP_CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
