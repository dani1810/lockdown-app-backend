.PHONY: docker

build:
	mvn package

docker: build
	docker build --build-arg JAR_FILE=./target/*.jar .