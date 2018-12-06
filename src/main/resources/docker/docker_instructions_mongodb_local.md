#  criar o container mongodb com senha
docker run -d -p 27017:27017 -p 28017:28017 -e MONGODB_PASS="mypass" tutum/mongodb

# inicializar servico
docker start [name_container]