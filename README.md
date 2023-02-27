# Gestanca

API da aplicação de controle de gastos pessoais.

## Endpoints

- Despesas

    -[Cadastrar despesa](#cadastrar-despesa)

    -Apagar despesa

    -Alterar despesa

    -Listas todas as despesas

    -[Detalhar uma despesa](#detralhar-despesa)

-Receitas

-Tranferências

-Contas

-Categorias

---

### Cadastrar Despesa

 `POST` /gestanca/api/despesa

 | campo | tipo | obrigatório | descrição 
 |-------|------|:-------------:|----------
 |valor | descimal | sim | o valor da despesa deve ser maior que zero
 |data | data | sim | a data em que a despesa ocorreu
 |categoria_id | inteiro | sim | o id da categoria da despesa previamente cadastrada
 |conta_id| inteiro | sim | o id da conta previamente casdastrada
 |descricao | texto | não | um texto com destalhes sobre a despesa

**Exemplo de corpo de requisição**
```js
{
    valor: 100.00,
    data: '2023-01-27',
    categoria_id: 1,
    conta_id: 1,
    descricao: 'cinema'
}
```

**Respotas**

|código | descrição
|-|-
|201| despesa cadastrada com sucesso
|400| a validação dos campos falhou

---

### Detralhar despesa

`GET` /gestanca/api/despesa/{id}

**Respostas**

|código | descrição
|-|-
|200| os dados da despesa foram retornados no corpo da respota
|404| não existe despesa com o id informado

**Exemplo de corpo da resposta**
```js
{
    valor: 100.00,
    data: '2023-01-27',
    categoria{
        categoria_id: 1,
        categoria: 'lazer'
    },
    conta{
        conta_id: 1,
        conta: 'itaú'
    },
    descricao: 'cinema'
}
```



