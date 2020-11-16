# Grupo A Desafio - Frontend

## Instalando dependências do projeto
```
npm install
```

## Envs
```
export NODE_ENV=development
```
Os arquivos .env devem ser configurados de acordo com o contexto de cada arquivo.

### Run project in dev mode 
```
npm run serve
```

### Build
```
npm run build
```

### Executar o deploy no servidor de homolagação
```
bash ./build-hom.sh
```
### Executar o deploy no servidor de produção
```
bash ./build.sh
```

### Executar os testes unitários
```
npm run test:unit
```

### Executar os testes end-to-end
```
npm run test:e2e
```

### Lints and fixes files
```
npm run lint
```


### Typescript
Ferramentas para agilizar no desenvolvimento de types
```
https://jvilk.com/MakeTypes/ || http://json2ts.com/
```

### Fake API
Utilizado na mockagem de dados da API, usado no desenvolvimento sem backend e nos testes e2e
##### Doc: https://github.com/typicode/json-server#getting-started
```
npm run api-server
```
