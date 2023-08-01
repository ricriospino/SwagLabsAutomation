 Feature: Iniciar sesión Fallido
	Como usuario no puedo loguearme satisfactoriamente y requiero un mensaje como respuesta

Background:
	Given que el usuario está en la página de inicio de sesión


@browser
Scenario: No puedo hacer login por usuario o contrasena incorrecta
  When el usuario ingresa el nombre de usuario incorrecto o la contrasena incorrecta
  And hace clic en el botón Login
  Then el usuario debería ver el mensaje de error "Epic sadface: Username and password do not match any user in this service" en rojo.
  
@browser
Scenario: No puedo hacer login por campo username null 
  When el usuario ingresa el nombre de usuario null y la contrasena correcta
  And hace clic en el botón Login por segunda vez
  Then el usuario debería ver el mensaje de error Epic sadface: Username is required en rojo.
  
@browser
Scenario: No puedo hacer login por campo password null 
  When el usuario ingresa el nombre de usuario correcto y la contrasena null
  And hace clic en el botón Login por tercera vez
  Then el usuario debería ver el mensaje de error Epic sadface: Password is required en rojo.
  
  
  
  
  