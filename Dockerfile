#Image de base
FROM openjdk:17-alpine
RUN for user in baye; do useradd $user; echo "1234" | passwd $user --stdin; done
Run yum update -y && yum install mysql -y
