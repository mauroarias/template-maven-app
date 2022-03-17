#!/bin/bash

move_package () {
	mkdir -p temp
	cp -rf src/$1/java/org/mauro/templateapp/* temp/
	mkdir -p src/$1/java/org/mauro/$packageDir
	cp -rf temp/* src/$1/java/org/mauro/$packageDir/
	rm -rf src/$1/java/org/mauro/templateapp
	rm -rf temp
	find "src/$1/java/org/mauro/$packageDir" -type f -name "*.java" -exec sed -i'' -e "s/templateapp/$packageName/g" {} +
}

spinal_to_upper () {
    IFS=- read -ra str <<<"$1"
    printf '%s' "${str[@]^}"
}

appName=$(echo "$1" | sed -e 's/\(.*\)/\L\1/')
packageName=$(echo $appName | sed -r "s/-/./g")
packageDir=$(echo $appName | sed -e "s/-/\//g")
mainClassName=$(spinal_to_upper $appName)
appNameCamel=$(echo $mainClassName | sed -e 's/./\L&/')
test=$(spinal_to_upper $appName)

echo "entry $1"
echo "appName $appName"
echo "packageName $packageName"
echo "package $packageDir"
echo "mainClassName $mainClassName"
echo "appNameCamel $appNameCamel"

cd $1
sed -i "s!template-maven-app!$appName!g" pom.xml Dockerfile README.md
sed -i "s!templateApp!$appNameCamel!g" Dockerfile

move_package test
move_package main

mv "src/main/java/org/mauro/$packageDir/TemplateApp.java" "src/main/java/org/mauro/$packageDir/${mainClassName}App.java"
sed -i "s/TemplateApp/${mainClassName}App/g" "src/main/java/org/mauro/$packageDir/${mainClassName}App.java"
sed -i "s!template-app!$appName!g" "src/main/resources/application.yml"

mvn clean package

cd ..