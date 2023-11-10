/**
 * VALIDAÇÃO DOS CAMPOS DE SENHA
 */

 function validacaon() {
	 
	//let senha = document.getElementById('senhas').value
	//let senha2 = document.getElementById('senha2').value
    let senha = frmj.senha.value
    let senha2 = frmj.senha2.value
	if (senha === "" || senha2 === "") {
		alert('PREENCHA O CAMPO DA SENHA')
		frmj.senha.focus()
		return false;

	}
	
	else if (senha2!=senha){
		alert('AS SENHAS NÃO CONSIDEM')
		frmj.senha.focus()
	     return false
	}
	
	else {
		//ESSE PEDAÇO VAI REDIRECIONAR OS VALORES DO FORMULARIO PARA A CLASSE SERVLET
		document.forms["frmj"].submit()
	}


}