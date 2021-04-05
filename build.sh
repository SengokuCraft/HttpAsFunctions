#!/bin/bash

# build all
pwd
if [[ $1 =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
    echo "Replacing @version in java code...."
    sed -i -e "s/\
^ \* @version [0-9]\+\.[0-9]\+\.[0-9]\+\
/ * @version ${1}/gm" $( \
        grep -lr --include="*.java" \
          "^ \* @version [0-9]\+\.[0-9]\+\.[0-9]\+" \
          src/main/java \
      )
    echo "Replaced files:"
    grep -lr --include="*.java" \
      "^ \* @version [0-9]\+\.[0-9]\+\.[0-9]\+" \
      src/main/java
    echo "Replacing version in pom.xml...."
    sed -i -e "1,/\
<[[:space:]]*version[[:space:]]*>\
[[:space:]]*[0-9]\+\.[0-9]\+\.[0-9]\+[[:space:]]*\
<[[:space:]]*\/[[:space:]]*version[[:space:]]*>\
/s/\
<[[:space:]]*version[[:space:]]*>\
[[:space:]]*[0-9]\+\.[0-9]\+\.[0-9]\+[[:space:]]*\
<[[:space:]]*\/[[:space:]]*version[[:space:]]*>\
/<version>${1}<\/version>/m" pom.xml
    echo "Replaced pom.xml."
    echo "Cleaning build directory...."
    mvn clean
    echo "Cleaned build directory."
    echo "Starting building...."
    mvn package
    echo "Finished building."
    echo -n \
"Do you want to make repository and generate javadoc? [Y/n]: "
    read genRepoAndDoc
    case $genRepoAndDoc in
        "" | [Yy]* )
            echo "Starting making repository...."
            mvn deploy
            echo "Finished making repository."
            echo "Starting generating javadoc...."
            mvn javadoc:javadoc
            echo "Finished generating javadoc."
            ;;
        * )
            echo "Building has been cancelled."
            ;;
    esac
elif [ -z $1 ]; then
    echo "Please append version."
else
    echo \
"Version should be in [number].[number].[number] format."
fi
