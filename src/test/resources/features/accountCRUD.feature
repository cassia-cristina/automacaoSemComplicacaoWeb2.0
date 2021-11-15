#language:pt
@crud
Funcionalidade: Criar, Consultar, Editar e excluir conta de usuario
  Como usuario do sistema
  O usuario deseja cadastrar, consultar, editar e excluir conta
  Para que seja possivel acessar ou remover seus dados

  @cadastroConta
  Cenario: Cadastrar nova conta de usuario
    Dado que a pagina new account esteja sendo exibida
    Quando os campos de cadastro estiverem preenchidos com
      | username | chronosCassia           |
      | email    | chronoscassia@gmail.com |
      | password | Senha123                |
      | country  | Brazil                  |
    Entao deve ser possivel logar no sistema apos o cadastro

  @consultaConta
  Cenario: Realizar login com nova conta
    Dado que a modal esteja sendo exibida
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | chronosCassia |
      | password | Senha123      |
      | remember | false         |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema

  @alteracaoConta
  Cenario: Realizar alteracao de dados da conta
    Dado que esteja logado no sistema com
      | login    | chronosCassia |
      | password | Senha123      |
      | remember | false         |
    Dado que esteja na pagina accountDetails
    Quando sao alterados os seguintes campos
      | firstName | chronosCris |
      | lastName  | Sousa       |
    Quando for realizado o clique em save
    Entao a alteracao deve ser exibida na pagina myAccount

  @exclusaoConta
  Cenario: Realizar exclusao da conta
    Dado que esteja logado no sistema com
      | login    | chronosCassia |
      | password | Senha123      |
      | remember | false         |
    Dado que esteja na pagina myAccount
    Quando for realizado o clique em Delete Account e em yes
    Entao exibe a mensagem de conta deletada com sucesso

  @validacontadeletada
  Cenario: Validar se a conta foi realmente excluida
    Dado que a modal esteja sendo exibida
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | chronosCassia |
      | password | Senha123      |
      | remember | false         |
    Quando for realizado o clique no botao sign in
    Entao o sistema deve exibir uma mensagem de erro