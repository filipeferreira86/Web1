#language: pt

@exec
Funcionalidade: permitir acessar tela de pesquisa

	Contexto: Dado que estou na pagina "http://189.45.198.123:8092/sisc_brandili/servlet/hsiscobra"
		Quando eu informar "9999" no campo "_USUCOD"
		E informar "senha" no campo "_USUSEN"
		E clicar no botão "BUTTON1"
		E clicar no botão "BUTTON3"
	
	
	Cenário: Acessar tela de pesquisa 
		Dado que estou na logado e na tela inicial
		Quando eu colocar o mouse sobre o item de menu "ações"
		E clicar no item "Pesquisar"
		Então deve ser exibido "tela de pesquisa de CNPJ"