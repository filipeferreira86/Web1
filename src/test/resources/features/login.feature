#language: pt

Funcionalidade: Permitir login
	
	@nexec
	Cenário: Login no site com sucesso
		Dado que estou na pagina "http://189.45.198.123:8092/sisc_brandili/servlet/hsiscobra"
		Quando eu informar "9999" no campo "_USUCOD"
		E informar "senha" no campo "_USUSEN"
		E clicar no botão "BUTTON1"
		E clicar no botão "BUTTON3"
		Então deve logar no site exibindo mensagem "Boa tarde! Administrador"
		