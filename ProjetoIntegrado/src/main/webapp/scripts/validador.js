/**
 *Validação dos campos de cadastro 
 */

function validacao() {

	let email = cadastro.usuario.value
	
	let senha = cadastro.senhacadastro.value


	if (email === "") {
		alert('Preencha o campo de E-mail')
		return false;
	}
	
	else if (senha === "") {
		alert('Preencha o campo de senha')
		return false;
	}
	
	else {
		document.forms["cadastro"].submit()
	}

}
