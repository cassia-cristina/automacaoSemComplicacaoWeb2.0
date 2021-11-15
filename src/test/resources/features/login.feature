#language:pt
@login
Funcionalidade: Login
  Como um usuario valido
  Usuario quer realizar o login
  Para que possa acessar o sistema com sucesso

  Contexto:
    Dado que a modal esteja sendo exibida

  @fecharModal
#  Cenario: Fechar a modal ao clicar fora da mesma
#    Quando for realizado um clique fora da modal
#    Entao a janela modal deve serr fechada

  @fecharModalIcone
#  Cenario: Fechar a modal ao clicar no icone fechar
#    Quando for realizado um clique no icone de fechar a modal
#    Entao a janela modal deve ser fechada

  @abrirNewAccount
  Cenario: Link Create New Account
    Quando for realizado um clique no link Create New Account
    Entao a pagina Create New Account deve ser exibida

  @loginSucesso
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema
    Exemplos:
      | identificacao       | login   | password | remember |
      | campos obrigatorios | chronos | Senha123 | false    |
      | todos os campos     | chronos | Senha123 | true     |

  @loginInvalido
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao o sistema deve exibir uma mensagem de erro
    Exemplos:
      | identificacao    | login    | password | remember
      | usuario invalido | invalido | Senha123 | true
      | senha invalida   | chronos  | invalida | true

  @dadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Entao o botao sign in deve permanecer desabilitado
    Exemplos:
      | identificacao     | login   | password | remember |
      | usuario em branco |         | Senha123 | false    |
      | senha em branco   | chronos |          | false    |