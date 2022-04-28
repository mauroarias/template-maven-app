#!/bin/bash

serviceName=$1

move_package () {
	package2Move=$1
	mkdir -p temp
	cp -rf src/$package2Move/java/org/mauro/templateapp/* temp/
	mkdir -p src/$package2Move/java/org/mauro/$packageDir
	cp -rf temp/* src/$package2Move/java/org/mauro/$packageDir/
	rm -rf src/$package2Move/java/org/mauro/templateapp
	rm -rf temp
	find "src/$$package2Move/java/org/mauro/$packageDir" -type f -name "*.java" -exec sed -i'' -e "s/templateapp/$packageName/g" {} +
}

spinal_to_upper () {
    IFS=- read -ra str <<<"$serviceName"
    printf '%s' "${str[@]^}"
}

appName=$(echo "$serviceName" | sed -e 's/\(.*\)/\L\1/')
packageName=$(echo $appName | sed -r "s/-/./g")
packageDir=$(echo $appName | sed -e "s/-/\//g")
mainClassName=$(spinal_to_upper $appName)
appNameCamel=$(echo $mainClassName | sed -e 's/./\L&/')
test=$(spinal_to_upper $appName)

echo "entry $serviceName"
echo "appName $appName"
echo "packageName $packageName"
echo "package $packageDir"
echo "mainClassName $mainClassName"
echo "appNameCamel $appNameCamel"

sed -i "s!template-maven-app!$appName!g" pom.xml Dockerfile README.md
sed -i "s!templateApp!$appNameCamel!g" Dockerfile
cd ./src
find . -type f -exec sed -i "s!org.mauro.templateapp!org.mauro.$packageName!g" {} +
cd ..
sed -i "s!org.mauro.templateapp!org.mauro.$packageName!g" pom.xml

move_package test
move_package main

mv "src/main/java/org/mauro/$packageDir/TemplateApp.java" "src/main/java/org/mauro/$packageDir/${mainClassName}App.java"
sed -i "s/TemplateApp/${mainClassName}App/g" "src/main/java/org/mauro/$packageDir/${mainClassName}App.java"
sed -i "s!template-app!$appName!g" "src/main/resources/application.yml"

mvn clean package